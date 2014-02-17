
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RabinKarp {

	static int MODULUS = 97;
	static int BASE = 26;
	private long[] powerArray;
	BufferedWriter bw = null;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();
		String pattern = "", str = "";
		RabinKarp rk = new RabinKarp();
		rk.openOutputFile("output.txt");
		while (line != null) {
			String parts[] = line.split("~");
			str = parts[0];
			pattern = parts[1];
			BASE = Integer.parseInt(parts[2]);
			MODULUS = Integer.parseInt(parts[3]);
			rk.rabinKarpRandomized(pattern, str);
			line = br.readLine();

		}
		br.close();
		rk.closeOutputFile();

	}

	void openOutputFile(String fileName) throws IOException{
		bw = new BufferedWriter(new FileWriter(fileName));
		bw.write("Base\tmodulo\tPattern length\tString Length\tCorrect Matches\tFalse Positive\tRunning Time\n");
	}

	void closeOutputFile() throws IOException{
		 bw.flush();
	     bw.close();
	}

	void writeToOutputFile(String str) throws IOException{
		bw.write(str + "\n");
	}

	void calcPower(int pow){
		powerArray = new long[pow + 1];
		powerArray[0] = 1;
		for(int i=1;i<=pow;i++){
			powerArray[i] = (powerArray[i - 1] * BASE)% MODULUS;
		}
	}

	/**
	 * Applies Rabin-Karp to find pattern within a String
	 * @param pattern
	 * @param str
	 * @throws IOException
	 */
	private void rabinKarpRandomized(String pattern, String str) throws IOException{
		long start = System.currentTimeMillis();

		int patternLenght = pattern.length(), correctMatches = 0, falsePositive = 0;
		calcPower(patternLenght);
		long patternHash = 0;
		long strHash = 0;
		for(int i=0;i<patternLenght;i++){
			char ch = pattern.charAt(i);
			//System.out.println(ch-65);
			System.out.println(powerArray[patternLenght-i-1] + " " + ch);
			patternHash += (powerArray[patternLenght - i - 1]*(ch - 65));
			char strch = str.charAt(i);
			strHash += (powerArray[patternLenght - i - 1]*(strch - 65));
		}
		//System.out.println(patternHash);

		patternHash = patternHash % MODULUS;
		strHash = strHash % MODULUS;

		int currentIndex = 0;
		long pow = powerArray[patternLenght];

		while(true){

			boolean matched = false;
			if(strHash == patternHash){
				matched = true;
				for(int i=currentIndex;i<currentIndex+patternLenght;i++){
					if(pattern.charAt(i-currentIndex) != str.charAt(i)){
						matched = false;
						falsePositive++;
						break;
					}
				}
			}
			if(matched){
				correctMatches++;
			}
			currentIndex += 1;
			if(currentIndex + patternLenght -1  < str.length()){

				strHash = ((BASE*strHash + (str.charAt(currentIndex + patternLenght -1) - 65)
						- pow*(str.charAt(currentIndex-1)-65)));
			} else {
				break;
			}
			strHash = (strHash% MODULUS + MODULUS) % MODULUS;
		}
		long end = System.currentTimeMillis();
		writeToOutputFile(BASE + "\t\t" + MODULUS + "\t\t\t" + pattern.length() + "\t\t\t\t" + str.length() + "\t\t\t\t" + correctMatches +
				"\t\t\t\t" + falsePositive + "\t\t\t" + (end-start));
	}

}
