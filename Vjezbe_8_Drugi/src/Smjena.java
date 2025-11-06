import java.util.ArrayList;

/*
Evidencija jedne smjene:
- datum: "YYYY-MM-DD"
- pocetak/kraj u minutima od 00:00
- tip: jutarnja / popodnevna / nocna (tekst)
- zaposleniIds: lista ID-jeva zaposlenih koji su radili smjenu
*/
public class Smjena {
    String datum;
    int pocetakMin;
    int krajMin;
    String tip;
    ArrayList<Integer> zaposleniIds = new ArrayList<Integer>();

    public Smjena(String datum, int pocetakMin, int krajMin, String tip) {
        this.datum = datum;
        this.pocetakMin = pocetakMin;
        this.krajMin = krajMin;
        this.tokTip(tip);
    }

    private void tokTip(String t) {
        if (t == null || t.trim().length() == 0) this.tip = "jutarnja";
        else this.tip = t.trim().toLowerCase();
    }

    public static int parseHHMMuMinute(String hhmm){
        // očekuje "HH:MM"
        int k = hhmm.indexOf(':');
        if (k == -1) return 0;
        return sigurnoUInt(hhmm.substring(0, k)) * 60 + sigurnoUInt(hhmm.substring(k+1));
    }

    private static int sigurnoUInt(String s){
        int v=0;
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c<'0' || c>'9') break;
            v = v*10 + (c - '0');
        }
        return v;
    }

    public int trajanjeMin(){
        if (krajMin <= pocetakMin) return 0;
        return krajMin - pocetakMin;
    }

    public String getMjesec(){ return (datum.length()>=7)? datum.substring(5,7):""; }
    public String getGodina(){ return (datum.length()>=4)? datum.substring(0,4):""; }

    public static String fmt(int m){
        String hh = String.valueOf(m/60); if (hh.length()==1) hh="0"+hh;
        String mm = String.valueOf(m%60); if (mm.length()==1) mm="0"+mm;
        return hh + ":" + mm;
    }

    public String toString(){
        return datum + " " + tip + " [" + fmt(pocetakMin) + "-" + fmt(krajMin) + "] " + zaposleniIds;
    }
}
