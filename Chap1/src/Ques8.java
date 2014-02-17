
public class Ques8 {
	/*
	 * Find if s2 is a rotation of s1
	 *
	 * Requires- rotation point of s1
	 * s1 is broken onto two parts x and y and then rearranged to get s2.
	 * So we need to do the reverse
	 * We can use only isSubstring() method
	 *
	 * In this program i have used two calls to contains method. But we have to use one.
	 * Solution:- check is s2 is a substring of s1s1. o(1) time.
	 */
	String s1="waterbottle";
	String s2="terbottlewa";



	boolean findRotation(){
		int flag=0;
		if(s1.length()==s2.length() && s1.length()>0){
		for(int i=0; i<s1.length();i++){
			String subS1=s1.substring(0, i);
			String subS2=s1.substring(i, s1.length());
			if(s2.contains(subS1) && s2.contains(subS2)){
				System.out.println(subS1 + " " + subS2);
				flag=1;
				break;
			}
		}
		}
		if(flag==1)
			return true;
		else
			return false;

	}
}
