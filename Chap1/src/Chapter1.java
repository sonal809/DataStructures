
public class Chapter1 {
	public static void main(String args[]){
		UniqueChar  ch=new UniqueChar();
		ch.findUniq();

		Ques8 q8=new Ques8();
		boolean check;
		//check=q8.isSubstring("hello", "hellt");

		check=q8.findRotation();
		System.out.println(check);
	}
}
