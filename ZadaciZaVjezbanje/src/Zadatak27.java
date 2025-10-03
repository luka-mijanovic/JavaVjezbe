import java.util.Scanner;
public class Zadatak27 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        int broj = sc.nextInt();
        int brojac = 0;
        int zbir = 0;
        
        while (broj > 0) {
            int c = broj % 10;
            zbir += c;
            brojac ++;
            broj /= 10;
        }
        double aritmetickaSred = (double) zbir / brojac;
        System.out.printf("%.2f",aritmetickaSred);
		sc.close();
	}

}
