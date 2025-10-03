import java.util.Scanner;
public class Zadatak28 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double x = sc.nextDouble();
        double y;

        if (x <= -7) 
            y = -2 * x + 7 / 2;
        else if (x > -7 && x < 1) 
            y = (x * x - 3 * x + 5) / (x * x + 2);
        else if (x >= 1 && x <= 8)
            y = Math.sqrt(x * x + 2 * x + 2) + Math.sqrt(Math.abs((3 / 2) * x - 4 / 7));
        else
            y =Math.abs(3 / x * x - 11 * x);
        

        System.out.println("y = " + y);
		sc.close();
	}

}
