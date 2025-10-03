import java.util.Scanner;
public class Zadatak35 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        System.out.print("Unesi broj karata: ");
        int n = sc.nextInt();

        boolean ispravno = true;
        boolean Neparne = false;

        for (int i = 0; i < n; i++) {
            int karta = sc.nextInt();

            if (Neparne) {
                if (karta % 2 == 0) {
                    ispravno = false;
                }
            } else {
                if (karta % 2 != 0) {
                    Neparne = true;
                }
            }
        }

        if (ispravno) {
            System.out.println("Ispravno složene karte.");
        } else {
            System.out.println("Nijesu ispravno složene karte.");
		sc.close();
	}
	}

}
