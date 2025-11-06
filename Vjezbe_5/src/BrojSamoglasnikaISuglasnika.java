//Odrediti broj samoglasnika i suglasnika u unesenoj riječi.
import java.util.Scanner;
public class BrojSamoglasnikaISuglasnika {

	private static boolean isVowel(char c) {
		c = Character.toLowerCase(c);
		return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String s = sc.next().trim();
			
			int v = 0, c = 0;
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (Character.isLetter(ch)) {
					if (isVowel(ch)) v++; else c++;
				}
			}
			System.out.println("Samoglasnika: " + v + ", Suglasnika: " + c);
			sc.close();
		}
	}

