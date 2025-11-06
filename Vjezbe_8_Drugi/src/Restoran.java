import java.util.ArrayList;

public class Restoran {
    private String naziv, adresa, pib;
    private ArrayList<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
    private ArrayList<Smjena> smjene = new ArrayList<Smjena>();

    public Restoran(String naziv, String adresa, String pib){
        this.naziv = naziv; this.adresa = adresa; this.pib = pib;
    }

    public void dodajZaposlenog(Zaposleni z){ zaposleni.add(z); }

    public boolean ukloniZaposlenogPoId(int id){
        for (int i=0;i<zaposleni.size();i++){
            if (zaposleni.get(i).getID() == id){ zaposleni.remove(i); return true; }
        }
        return false;
    }

    public Zaposleni pronadjiPoId(int id){
        for (int i=0;i<zaposleni.size();i++){
            if (zaposleni.get(i).getID() == id) return zaposleni.get(i);
        }
        return null;
    }

    public void dodajSmjenu(Smjena s){ smjene.add(s); }

    private boolean postojeSmjeneZa(int mjesec, int godina){
        String mm = (mjesec<10? "0"+mjesec : String.valueOf(mjesec));
        String gg = String.valueOf(godina);
        for (int i=0;i<smjene.size();i++){
            if (smjene.get(i).getMjesec().equals(mm) && smjene.get(i).getGodina().equals(gg)) return true;
        }
        return false;
    }

    public double ukupnoSatiIzSmjena(int id, int mjesec, int godina){
        double min = 0.0;
        String mm = (mjesec<10? "0"+mjesec : String.valueOf(mjesec));
        String gg = String.valueOf(godina);
        for (int i=0;i<smjene.size();i++){
            Smjena s = smjene.get(i);
            if (!s.getMjesec().equals(mm) || !s.getGodina().equals(gg)) continue;
            for (int k=0;k<s.zaposleniIds.size();k++){
                if (s.zaposleniIds.get(k) == id){ min += s.trajanjeMin(); break; }
            }
        }
        return min / 60.0;
    }

    public ArrayList<ObracunPlate> generisiObracun(int mjesec, int godina){
        ArrayList<ObracunPlate> lista = new ArrayList<ObracunPlate>();
        boolean koristiSmjene = postojeSmjeneZa(mjesec, godina);

        StringBuilder sb = new StringBuilder();
        sb.append("== OBRACUN PLATA za ").append(godina).append("-")
          .append(mjesec<10? "0"+mjesec : mjesec).append(" ==\n");
        sb.append(String.format("%-6s %-22s %-12s %10s %22s %14s\n",
                "ID","Ime i prezime","Tip","Sati","Prekovr./Bonus","Plata(€)"));
        sb.append("--------------------------------------------------------------------------------------\n");

        for (int i=0;i<zaposleni.size();i++){
            Zaposleni z = zaposleni.get(i);

            // odredi sate
            double sati = koristiSmjene ? ukupnoSatiIzSmjena(z.getID(), mjesec, godina)
                                        : z.getUkupanBrojSati();

            // ako treba, privremeno prenesi sate u objekat pa vrati (jer tvoje izračune koriste getUkupanBrojSati)
            double stariSati = z.getUkupanBrojSati();
            z.setUkupanBrojSati(sati);

            // plata po tipu (poštujemo tvoje klase)
            double plata;
            if (z instanceof Menadzer) {
                // Menadzer već override-uje izracunajPlatu
                plata = z.izracunajPlatu();
            } else if (z instanceof Konobari) {
                // Konobari u tvojoj klasi imaju obracunPlate()
                plata = ((Konobari) z).obracunPlate();
            } else if (z instanceof Kuvari) {
                // Kuvari u tvojoj klasi imaju obracunPlate()
                plata = ((Kuvari) z).obracunPlate();
            } else {
                // fallback ako ima još tipova
                plata = z.izracunajPlatu();
            }

            // vrati stare sate (da ne ostanu “zapisani” radi smjena)
            z.setUkupanBrojSati(stariSati);

            // napomena (prekovremeni/bonus) – čitamo iz bazne klase
            String napomena = "prekovr: " + String.format("%.2f", (double)z.getPrekovremeniSati()) + "h, bonus: " +
                              String.format("%.2f", z.getBonus()) + "€";

            lista.add(new ObracunPlate(mjesec, godina, z, plata, napomena));

            sb.append(String.format("%-6d %-22s %-12s %10.2f %22s %14.2f\n",
                    z.getID(), z.getIme() + " " + z.getPrezime(), z.getTip(), sati, napomena, plata));
        }

        System.out.print(sb.toString());
        return lista;
    }

    public double mjesecniTrosakPlata(int mjesec, int godina){
        ArrayList<ObracunPlate> L = generisiObracun(mjesec, godina);
        double s = 0.0;
        for (int i=0;i<L.size();i++) s += L.get(i).iznosEur;
        System.out.println("UKUPAN TROSAK PLATA: " + String.format("%.2f", s) + "€");
        return s;
    }
}