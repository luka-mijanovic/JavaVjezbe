import java.util.Scanner;
public class DrugiZadatak {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double a = sc.nextDouble(); 
		double b = sc.nextDouble();
		
		double P = (a*b)/100;
		
		System.out.printf("Povrsina je:%.2f",P);
		sc.close();
	}

}
