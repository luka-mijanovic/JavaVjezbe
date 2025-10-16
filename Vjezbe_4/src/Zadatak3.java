import java.util.Scanner;
public class Zadatak3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        System.out.print("Unesi duzinu niza: ");
        int n = sc.nextInt();

        int[] bodovi = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Unesi bodove za studenta " + (i + 1) + ": ");
            bodovi[i] = sc.nextInt();
        }
        
        double suma = 0;
        for (int b: bodovi) {
        suma += b;
        }
        
		sc.close();
	}

}
