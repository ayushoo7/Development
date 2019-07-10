package ayush_sum_of_numbers;

import java.util.Arrays;
import java.util.List;

public class AdditionOfArrayNumber {

	public static void main(String[] args) throws Exception {
			int[] sum = new TestClass().sum(new int[] {1,2,9}, new int[]{3,4,9});
			Arrays.stream(sum).forEach(System.out:: println);
	}

	public int[] sum(int[] a, int[] b) throws Exception {

		boolean aMatch = Arrays.stream(a).anyMatch(x -> x > 10 || x < 0);
		boolean bMAtch = Arrays.stream(b).anyMatch(x -> x > 10 || x < 0);
		if (aMatch || bMAtch) {
			throw new Exception();

		}
		int[] rturningk;
		if (a.length >= b.length) {
			rturningk = new int[a.length];
		} else {
			rturningk = new int[b.length];
		}
		int carry = 0;
		if (a.length >= b.length) {
			for (int k = a.length - 1; k >= 0; k--) {
				int temp = carry + a[k] + b[k];
				carry = temp / 10;
				rturningk[k] = temp / 10 > 0 ? temp % 10 : temp;
				if(!(temp / 10 > 0)){
					carry =0;
				}
			}
		} else {
			
			for (int k = b.length - 1; k <= 0; k--) {
				int temp = carry + a[k] + b[k];
				carry = temp / 10;
				rturningk[k] = temp / 10 > 0 ? temp % 10 : temp;
				if(!(temp / 10 > 0)){
					carry =0;
				}
			}

		}
		return rturningk;
	}

}
