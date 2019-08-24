package lecture8;

import java.util.Scanner;

public class biggestnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		bubblesort(arr);
		for (int val : arr) {
			System.out.print(val);

		}

		System.out.println();

	}

	public static void bubblesort(int[] array) {
		int n = array.length;
		for (int c = 0; c < n - 1; c++) {
			for (int j = 0; j <= n - c - 2; j++) {
				if (compare(array[j], array[j + 1])) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
//	        return array;
	}

	public static boolean compare(int n1, int n2)

	{
		String s1 = n1 + "" + n2;
		String s2 = n2 + "" + n1;
		int s3 = Integer.parseInt(s1);
		int s4 = Integer.parseInt(s2);
		if (s4 > s3) {
			return true;
		} else {
			return false;
		}
	}
}
