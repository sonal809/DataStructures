
public class TestDebugger {

	public static void main(String[] args) {
		int i = 4;
		int b = 4%5;
		int c= i + 5*5*5*5*5*5*5*5*5*5*5*5*5*5*5*5;
		int d = c%5;
		System.out.println(b == d); // logically b and d are both same, then why is the answer false?
	}


}
