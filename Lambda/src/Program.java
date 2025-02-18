
public class Program {

	static void sort(int a[]) {
		for (int i = 0; i < a.length - 1; ++i) {
			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	static void print(int a[]) {
		for (int i = 0; i < a.length; ++i) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		int[] a = { 45, 47565, 6, 78, 5, 16, 6806, 3426, 90, 53, 2, 6234, 6, 769 };
		System.out.println("Array prima dell'ordinamento");
		print(a);
		sort(a);
		System.out.println("Array ordinato in senso crescente");
		print(a);

	}

}
