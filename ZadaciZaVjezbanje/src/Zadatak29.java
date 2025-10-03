import java.util.Scanner;
public class Zadatak29 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Unesi x: ");
        double x = sc.nextDouble();
		System.out.print("Unesi y: ");
        double y = sc.nextDouble();
        
        if (x == 0 && y == 0) 
            System.out.println("Tacka je u koordinatnom pocetku");
        else if (x == 0)
            System.out.println("Tacka je na Y-osi");
        else if (y == 0)
            System.out.println("Tacka je na X-osi");
        else if (x > 0 && y > 0)
            System.out.println("I kvadrant");
        else if (x < 0 && y > 0)
            System.out.println("II kvadrant");
        else if (x < 0 && y < 0)
            System.out.println("III kvadrant");
        else
            System.out.println("IV kvadrant");
		sc.close();
	}

}
