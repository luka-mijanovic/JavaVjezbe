import java.util.Scanner;
public class Zadatak10 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double d = 50;
		double sirinaX = 16;
		double visinaX = 9;
		
		double x = d / Math.sqrt(Math.pow(sirinaX, 2) + Math.pow(visinaX, 2));
		
		double sirina = x * sirinaX;
		double visina = x * visinaX;
		
		double povrsina = sirina * visina;
		System.out.printf("Povrsina monitora ce iznositi %.2f ",povrsina);
		sc.close();
	}

}
