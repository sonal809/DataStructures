public class RemoveDuplicates {

	int abs(int i) {
		if (i >= 0)
			return i;
		else
			return -i;
	}

	void printDup(String string) {
		int flag = 0;
		System.out.println("print duplicate characters:");
		// System.out.println();
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < string.length(); i++) {
			int val = string.charAt(i);
			if (char_set[val]) {
				System.out.print(string.charAt(i) + " ");
				flag = 1;
				continue;
			} else {
				char_set[val] = true;
			}
		}
		if (flag == 0) {
			System.out.println("no duplicates exist");
		}
	}

	// This function uses only O(1) extra space of only one integer.
	int setBit(int num, int i) {
		return num | (1 << i);
	}

	boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}

	void removeDup2(String string) {
		int numberA = 0;
		int numbera = 0;
		int iIndex;
		int flag = 0;
		System.out.println();
		System.out.println("The duplicates in the string are: ");
		for (int i = 0; i < string.length(); i++) {
			if ((int) string.charAt(i) < 90)
				iIndex = (int) string.charAt(i) - 65;
			else
				iIndex = (int) string.charAt(i) - 97;
			// System.out.println("  " +iIndex);
			// if(getBit(numbera,iIndex)){
			if (getBit(numberA, iIndex) || getBit(numbera, iIndex)) {
				System.out.println(string.charAt(i));
				flag = 1;
			} else {
				if ((int) string.charAt(i) > 90) {
					numbera = setBit(numbera, iIndex);

				} else {
					numberA = setBit(numberA, iIndex);
				}

			}
		}

		if (flag == 0) {
			System.out.println("No duplicates in the string");
		}

	}

}
