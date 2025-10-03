import java.util.Scanner;
public class Zadatak42 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        int n = sc.nextInt();
        long d = sc.nextLong();
        long hd = sc.nextLong();
        long ka = sc.nextLong();
        int brojPrijetnji = 0;

        for (int i = 0; i < n; i++) {
            long xi = sc.nextLong();
            long yi = sc.nextLong();
            long Nd = Math.abs(xi) + Math.abs(yi);
            
            if (Nd <= d) {
            	brojPrijetnji ++;
            }
        }
        long totalDmg = brojPrijetnji * ka;
        
        System.out.printf("Nas dvorac je ugrozen od strane %f prijetnji ",brojPrijetnji);
        if (totalDmg >hd)
        	System.out.printf("Dvorac je srusen, ukupan broj dmg je %f",totalDmg);
        else
            System.out.printf("Dvorac nije srusen, ukupan broj dmg je %f",totalDmg);
		sc.close();
	}

}
