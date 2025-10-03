import java.util.Scanner;
public class Zadatak38 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        int n = sc.nextInt();
        double r1 = sc.nextDouble();
        double r2 = sc.nextDouble();
        int ukupno = 0;
        int unutarR1 = 0;
        int izmedju = 0;
        int iznadPrave = 0;
        
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double d = Math.sqrt(x * x + y * y);
            
            boolean pripada = false;
            if (d <= r1) { 
            	pripada = true; 
            	unutarR1++; 
            }
            else if (d <= r2) { 
            	pripada = true;
            	izmedju++; 
            }
            if (pripada) ukupno++;
            // provjera iznad/ispod prave? x - y - 4 = 0  => ako x - y -4 > 0 -> iznad / ili ispod? 
            // iznad kada je y > (x - 4) -> y > x - 4?????????
            if (y >= x - 4) iznadPrave++;
        }
        System.out.println("Ukupno u osjencenom: " + ukupno);
        System.out.println("Unutar r1: " + unutarR1);
        System.out.println("Izmedju r1 i r2: " + izmedju);
        System.out.println("Broj tacaka iznad prave (y >= x-4): " + iznadPrave);
		sc.close();
	}

}
