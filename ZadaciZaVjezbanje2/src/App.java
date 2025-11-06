
public class App {
    public static void main(String[] args) {
        BankovniRacun racun = new BankovniRacun("Nikola", 100.0);

        Transakcija t1 = new Transakcija(50.0, "uplata", "plata");
        Transakcija t2 = new Transakcija(30.0, "isplata", "racun za struju");

        // ako je uplata -> racun.uplati; inače racun.isplati
        if (t1.jeUplata()) racun.uplati(t1.getIznos()); else racun.isplati(t1.getIznos());
        if (t2.jeUplata()) racun.uplati(t2.getIznos()); else racun.isplati(t2.getIznos());

        racun.ispisi();
    }
}