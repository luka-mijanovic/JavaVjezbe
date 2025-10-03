import java.util.Scanner;
public class Zadatak30 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Unesi koliko eura ima: ");
        double n = sc.nextDouble();
		System.out.print("Unesi staru cijenu akcije: ");
        double x = sc.nextDouble();
        
        double novaCijena = x * 1.15;
        int kolicina = (int)(n / novaCijena);
        if (kolicina > 0)
            System.out.printf("Moze kupiti %d akcija", kolicina);
        else 
            System.out.println("Ne moze kupiti nijednu akciju");
        
		sc.close();
	}

}
