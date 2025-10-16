
public class FudbalNiz {

	public static void main(String[] args) {
	int[] niz = new int[10];
	int max = 0;
		for (int i=0; i < niz.length; i++) {
			if (niz[i] > max) {
				max = niz[i];
			}
		}
		System.out.println(max);
	}
}
