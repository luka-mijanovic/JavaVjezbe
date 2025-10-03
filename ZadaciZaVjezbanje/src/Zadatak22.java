import java.util.Scanner;
public class Zadatak22 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        int broj = sc.nextInt();
        int min = 9;
        int max = 0;
        
        while (broj > 0) {
            int c = broj % 10;
            if (c < min) {
            	min = c;
            }
            if (c > max) {
            	max = c;
            }
            broj /= 10;
        }
        System.out.println(min + max);
		sc.close();
	}

}
