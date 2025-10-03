import java.util.Scanner;
public class Zadatak3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double Rastojanje_cm = sc.nextDouble(); 

		double Rastojanje_m = Rastojanje_cm / 100;
		
		System.out.printf("Rastojanje izmedju dvije kancelarije iznosi %.0fm",Rastojanje_m);
		sc.close();
	}

}
