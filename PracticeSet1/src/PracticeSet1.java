
public class PracticeSet1 {
	public static void main(String args[]) {

		// Question1 caller:
		/*
		 * System.out.println("Start question 1"); int[]
		 * array={1,2,3,4,3,2,1,7};
		 * 
		 * PracQues1 p1=new PracQues1(); p1.sumCheck(array);
		 */

		// Question2 caller
		PracQues4 p4 = new PracQues4();
		p4.ques4Caller();
		RemoveDuplicates rd = new RemoveDuplicates();
		rd.printDup("sonalssa");
		rd.removeDup2("sonalsa");
		/*
		 * int num=0; num=rd.setBit(num, 1); boolean a=rd.getBit(num, 1);
		 * System.out.println(a);
		 */
		// LongestSubstring.longestSubString("sinchanss", "sitchanss");;
		LongestSubstring.longestSubSequence("hello", "mehlw");
	}
}
