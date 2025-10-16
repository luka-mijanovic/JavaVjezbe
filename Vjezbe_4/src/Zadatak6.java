import java.util.Scanner;

public class Zadatak6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        System.out.print("Unesi duzinu niza: ");
        int n = sc.nextInt();

        int[] niz = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Unesi broj za niza: ");
            niz[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (niz[j] < niz[j + 1]) {
                    int temp = niz[j];
                    niz[j] = niz[j + 1];
                    niz[j + 1] = temp;
                }
            }
        }
		for (int i=0; i < niz.length; i++) {
			System.out.println(niz[i]);
		}
		
        System.out.print("Unesi broj: ");
        int broj = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
        	if (broj == niz[i]) {
                System.out.println("Broj se nalazi u nizu");
        	}else
                System.out.println("Broj se nalazi u nizu");
        }
        		
		sc.close();
	}

}
