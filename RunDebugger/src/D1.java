import java.io.FileNotFoundException;
import java.io.PrintStream;


public class D1 {

	static void a(){
		System.out.println("hello in D1");
		try {
			System.setOut( new PrintStream("mjjjjj"));
			System.out.println("booonaaa");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("booonaaa");
			//e.printStackTrace();
		}
	}

}
