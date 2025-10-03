import java.util.Scanner;
public class Zadatak31 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Unesi brzinu vozaca: ");
        double x = sc.nextDouble();
        int kazna;
        
        if (x > 50) {
        	kazna = (int) (x - 50) * 10;
			System.out.printf("Kazna iznosi %d eura", kazna);
        }else
    		System.out.println("Vozac vozi po propisima");
		sc.close();
	}

}
