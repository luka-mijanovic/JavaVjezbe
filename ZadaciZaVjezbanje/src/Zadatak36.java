import java.util.Scanner;
public class Zadatak36 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        System.out.print("Unesi koliko brojeva imamo: ");
        int n = sc.nextInt();

        int red = 0;
        boolean ispravno = true;

        for (int i = 0; i < n; i++) {
            int broj = sc.nextInt();

            if (red == 0) {
                if (broj < 0) {
                } else if (broj == 0) {
                    red = 1;
                } else {
                    red = 2;
                }
            } else if (red == 1) {
                if (broj == 0) {
                } else if (broj > 0) {
                    red = 2;
                } else {
                    ispravno = false;
                }
            } else {
                if (broj <= 0) {
                    ispravno = false;
                }
            }
        }

        if (ispravno) {
            System.out.println("Ispravno poredani brojevi.");
        } else {
            System.out.println("Nisu ispravno poredani brojevi.");
        }
		sc.close();
	}

}
