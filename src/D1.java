import java.io.FileNotFoundException;
import java.io.PrintStream;


public class D1 {

	static void a(){
		try {
			System.setOut( new PrintStream("test"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
