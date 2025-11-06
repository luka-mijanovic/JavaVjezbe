/*Za potrebe kompanije, uvoznika različitih linija proizvoda, potrebno je kreirati sistem
za upravljanje proizvodima. Zajedničke karakteristike svih proizvoda jesu opis
proizvoda, barkod, zemlja proizvodnje, godina proizvodnje i uvozna cijena proizvoda.
Proizvodi se dijele u tri kategorije: Garderoba, Hemijski proizvodi i Hrana. Svaka
kategorija ima svoje specificne atribute i pravila za računanje maloprodajne cijene:
a. Garderoba: Atribut - Materijal proizvodnje, Sezona.
Pravilo za obračun cijene: Uvozna cijena uvećana za maržu od 5 %
b. Hemijski proizvodi: Atribut - Temperatura skladištenja, Zapaljivo.
Pravilo za obračun cijene: Uvozna cijena uvećana za maržu od 12.5 % ukoliko
je proizvod zapaljiv a ukoliko nije 10%
c. Hrana: Atribut - Broj kalorija, Datum rok upotrebe.
Pravilo za obračun cijene: Uvozna cijena uvećana za maržu od 5 % ukoliko je
rok trajanja manji od 6 mjeseci a ukoliko nije 10%
Osim unosa samih proizvoda, potrebno je omogućiti i sledeće:
∙ Prikaz svih informacija za sve proizvode,
∙ Prikaz maloprodajne cijene za sve proizvode
∙ Na osnovu odabrane grupe proizvoda prikazati prosječnu maloprodajnu cijenu.
*/

import java.util.ArrayList; // samo za ArrayList varijantu
class Proizvod {
	private String opis;
	private String barkod;
	private String zemljaProizvodnje;
	private int godinaProizvodnje;
	private double uvoznaCijena;
	public Proizvod(String opis, String barkod, String zemljaProizvodnje, int
godinaProizvodnje, double uvoznaCijena) {
		this.opis = opis;
		this.barkod = barkod;
		this.zemljaProizvodnje = zemljaProizvodnje;
		this.godinaProizvodnje = godinaProizvodnje;
		this.uvoznaCijena = uvoznaCijena;
	}
	public String getOpis() { return opis; }
	public double getUvoznaCijena() { return uvoznaCijena; }
	
	public double izracunajMaloprodajnuCijenu() {
		return uvoznaCijena;
	}
	public String osnovneInfo() {
		return "Opis: " + opis + " | Barkod: " + barkod + " | Zemlja: " +
zemljaProizvodnje + " | Godina: " + godinaProizvodnje + " | Uvozna: " +
uvoznaCijena + "€";}
	public String toString() {
		return osnovneInfo();
	}
}
