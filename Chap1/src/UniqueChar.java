import java.lang.*;
import java.util.*;

public class UniqueChar {
String  string1 = "sinchan";
HashMap<Character, Integer> count=new HashMap<Character, Integer>();
int flag=1;
void findUniq(){
	for(int i=0;i<string1.length();i++){
		count.put(string1.charAt(i), 0);
		//System.out.println("key:" + string1.charAt(i) + " value:" + count.get(string1.charAt(i)));
	}
for(int i=0;i< string1.length(); i++){
		if(count.containsKey(string1.charAt(i))){
			count.put(string1.charAt(i), count.get(string1.charAt(i))+1);
		}


}
	for(Character key: count.keySet()){
		System.out.println("key:" + key + " value:" + count.get(key));
		if (count.get(key)>1){
			System.out.println("duplicate character:" + key);
			flag=0;
			break;
		}


	}
	if (flag==1){
		System.out.println("no duplicate character");
	}
}
}


