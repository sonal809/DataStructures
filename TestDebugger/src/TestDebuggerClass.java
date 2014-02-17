
public class TestDebuggerClass {
	public static void main(String[] args) {
		int i = 4;
		int b = 4%5;
		long f=(5*5*5*5*5*5*5*5*5*5*5*5*5*5L);
		System.out.println("f" + " " + f);
		long c= i + 5*5*5*5*5*5*5*5*5*5*5*5*5*5L;
		//int c= i + 5*5*5*5*5*5*5*5*5*5*5*5*5*5*5*5;
		long d = c%5;
		System.out.println("d" + " " + d);
		System.out.println("b" + " " + b);
		System.out.println(b == d); // logically b and d are both same, then why is the answer false?
	}
}
