//import java.util.Scanner;
import java.io.*;
import java.util.*;

public class PracQues4 {
	static String words[];
	static List<String> allWords = new ArrayList<String>();
	// static String allWords[]=new String[20];
	HashMap<String, Integer> count = new HashMap<String, Integer>();

	void ReadInput() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();

		int allWordIndex = 0;
		while (line != null) {
			words = line.split(" ");
			int startIndex = 0;
			// System.out.println(words[words.length-1]);

			for (; startIndex < words.length; startIndex++) {
				allWords.add(allWordIndex, words[startIndex]);
				// System.out.println(" "+ allWords[allWordIndex]);
				allWordIndex++;
			}

			// System.out.println(line);
			line = br.readLine();
			System.out.println(allWords.size());

		}
		for (int i = 0; i < allWords.size(); i++) {
			System.out.print(" " + allWords.get(i));
		}

		br.close();
	}

	void DuplicateWords(List<String> allWords) {
		for (int i = 0; i < allWords.size(); i++) {
			if (count.containsKey(allWords.get(i))) {
				count.put(allWords.get(i), count.get(allWords.get(i)) + 1);
			} else {
				count.put(allWords.get(i), 1);
			}
		}
		System.out.println();
		for (String key : count.keySet())
			System.out.println("key:" + key + " value:" + count.get(key));

		String wordString = count.toString();
		System.out.println(wordString);
		List<String> uniqWordList = new ArrayList<>();
		for (int i = 0; i < allWords.size(); i++) {
			if (uniqWordList.contains(allWords.get(i))) {
				continue;
			} else {
				uniqWordList.add(allWords.get(i));
			}
		}
		System.out.println("UniqueWordList:");
		for (int i = 0; i < uniqWordList.size(); i++) {

			System.out.print(" " + uniqWordList.get(i));
		}
		System.out.println();

		for (int i = 0; i < uniqWordList.size(); i++) {
			// Implement selection sort on <key,value> to print words by their
			// wordCount in descending order.

			String maxWord = uniqWordList.get(i);
			int max = count.get(uniqWordList.get(i));
			// System.out.println("initial maxword"+maxWord+ " " + max);

			for (int j = i; j < uniqWordList.size(); j++) {
				if (count.get(uniqWordList.get(j)) > max) {
					max = count.get(uniqWordList.get(j));
					int temp = j;
					maxWord = uniqWordList.get(j);
					// uniqWordList.add(temp,uniqWordList.get(temp));
					// uniqWordList.add(i, maxWord);
					String tempWord = uniqWordList.get(i);
					uniqWordList.set(i, maxWord);
					uniqWordList.set(temp, tempWord);

				}
			}

			if (max > 1) {
				System.out.println((i + 1) + ". " + maxWord + " " + max);
			}

		}
	}

	void ques4Caller() {
		try {
			ReadInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DuplicateWords(allWords);
	}

}