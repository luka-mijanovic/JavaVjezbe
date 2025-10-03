import java.util.Scanner;
public class Zadatak33 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Unesi neki broj: ");
        int broj = sc.nextInt();
        int zbir = 0;
        int i = 0;

        while (broj > 0) {
            zbir += broj % 10;
            i++;
            broj /= 10;
        }
        double aritmeticka = (double) zbir / i;
        System.out.println("Zbir cifara: " + zbir);
        System.out.println("Aritmeticka sredina: " + aritmeticka);
		sc.close();
	}

}
