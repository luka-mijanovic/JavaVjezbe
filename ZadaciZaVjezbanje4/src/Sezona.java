/*
ZADATAK 12 (Sezona enum)
Enum PROLJECE, LJETO, JESEN, ZIMA sa min/max prosječnim temperaturama i metodom opis().
*/
public enum Sezona {
    PROLJECE(5,20), LJETO(20,35), JESEN(8,22), ZIMA(-5,7);

    private int tMin, tMax;

    Sezona(int tMin, int tMax){ this.tMin = tMin; this.tMax = tMax; }

    public int getMin(){ return tMin; }
    public int getMax(){ return tMax; }

    public String opis(){
        return "U sezoni " + this.name() + " prosječne temperature se kreću od " +
               tMin + "°C do " + tMax + "°C.";
    }
}