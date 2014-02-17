public class LongestSubstring {
	static void longestSubString(String str1, String str2) {
		int maxLength = 0;
		int currentlength = 0;
		int end = 0;
		int i = 0, j = 0;
		while (i < str1.length()) {
			while (j < str2.length()) {
				if (i >= str1.length()) {
					break;
				}
				if (str1.charAt(i) == str2.charAt(j)) {
					currentlength++;
					i++;
					j++;
					continue;
				}
				j++;
			}
			if (maxLength < currentlength) {
				maxLength = currentlength;
				end = i;
			}
			i = i - currentlength + 1;
			j = 0;
			currentlength = 0;
		}
		System.out.println(str1.substring(end - maxLength, end));
		System.out.println("end index: " + (end - 1) + " maxlength "
				+ maxLength);
	}

	static void longestSubSequence(String str1, String str2) {
		int[][] arr = new int[str1.length() + 1][str2.length() + 1];
		// initialization of the matrix
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				arr[0][j] = 0;
			}
			arr[i][0] = 0;
		}
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}

		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				System.out.print(" " + arr[i][j]);
			}
			System.out.println();
		}

		// Get the LCS
		int i = 0, j = 0;
		while (i < str1.length() && j < str2.length()) {
			if (str1.charAt(i) == str2.charAt(j)) {
				System.out.print(str1.charAt(i));
				i++;
				j++;
			} else if (arr[i + 1][j] <= arr[i][j + 1]) {
				i++;
				System.out.println("i :" + i + " j: " + j);
			} else {
				j++;
				// System.out.println("i :"+i+" j: "+j);
			}
		}
	}
}
