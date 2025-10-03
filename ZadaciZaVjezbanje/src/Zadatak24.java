import java.util.Scanner;
public class Zadatak24 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double cijena = sc.nextDouble();
        double prosjek = sc.nextDouble();
        int nagrada = sc.nextInt();
        
        double popust = 0.0;
        if (nagrada == 1) {
        	popust = 0.30;
        }
        
        if (prosjek >= 4.5) {
        	popust = 0.40;
        }
        else if (prosjek >= 3.5) {
        	if (nagrada == 1) {
        		popust = 0.30;
        	}
        	else {
        		popust = 0.20;
        	}
        }
        else if (prosjek >= 2.5) {
        	if (nagrada == 1) {
        		popust = 0.30;
        	}
        	else {
        		popust = 0.10;
        	}
        }
        double placa = cijena * (1.0 - popust);
        System.out.printf("%.0f",placa);
		sc.close();
	}

}
