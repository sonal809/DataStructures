import java.util.*;

public class PracQues1 {
	int arr[] = new int[20];
	int sumArrF[] = new int[20];
	int sumArrB[] = new int[20];

	void sumCheck(int arr[]) {
		sumArrF[0] = 0;
		sumArrB[arr.length - 1] = 0;
		Arrays.copyOf(arr, arr.length * 2);
		int flag = 1;
		for (int i = 1; i < arr.length; i++) {
			sumArrF[i] = sumArrF[i - 1] + arr[i - 1];
			sumArrB[arr.length - i - 1] = sumArrB[arr.length - i]
					+ arr[arr.length - i];
			// System.out.println("sumArrF["+i+"]" + sumArrF[i]);
			// System.out.println("sumArrB["+ (arr.length-i-1) +"]" +
			// sumArrB[arr.length-i-1]);
		}
		for (int i = 0; i < arr.length; i++) {
			if (sumArrF[i] == sumArrB[i]) {
				System.out.println("Array index is:" + i);
				flag = 0;
			}
		}
		if (flag == 1)
			System.out.println("No such array index");

	}

}
