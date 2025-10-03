import java.util.Scanner;
public class Zadatak17 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        int godina = sc.nextInt();
        boolean prestupna;
        
        if (godina % 400 == 0) {
        	prestupna = true;
        }
        else if (godina % 100 == 0) {
        	prestupna = false;
        }
        else if (godina % 4 == 0) {
        	prestupna = true;
        }
        else {
        	prestupna = false;
        }
        
        if (prestupna) {
        	System.out.println("Prestupna");
        }
        else {
        	System.out.println("Nije prestupna");
        }
		sc.close();
	}

}
