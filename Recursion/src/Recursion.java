
public class Recursion {

	//compute the gcd of two numbers.here a>b
	static int gcd(int a, int b){
			if (b==0) return a;
			return gcd(b, a%b);
	}

	//Tower of Hanoi problem
	static void hanoi(int N, String source, String dest, String other){
		if(N==0){
			System.out.println("Move 1 disk from " + source + " to " + dest);
		}
		else{
		hanoi(N-1, source, other, dest);
		System.out.println("Move " + N + " disks from " + source + " to "+ dest );
		hanoi(N-1, other, dest, source);
		}
	}


	public static void main(String args[]){
		int val=gcd(24,16);
		//System.out.println(val);

		hanoi(3, "a","b","c");
	}
}
