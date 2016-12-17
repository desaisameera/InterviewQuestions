import java.util.HashMap;
import java.util.Map;

public class DuplicateStrings {
	public void printDuplicateStrings(String str) {
		if(str == null || str == ""){
			return;
		}
		Map<Character, Integer>countOfChars = new HashMap<Character, Integer>();
		for(int index = 0; index < str.length(); index++) {
			char key = str.charAt(index);
			if(countOfChars.containsKey(key)) {
				countOfChars.put(key, countOfChars.get(key) + 1);
			}
			else {
				countOfChars.put(key, 1);
			}
		}
		for(Character ch : countOfChars.keySet()) {
			int count = countOfChars.get(ch);
			if(count > 1) {
				System.out.print(ch);
			}
		}
	}
	public static void main(String[]args) {
		String str = "Programming";
		DuplicateStrings ds = new DuplicateStrings();
		ds.printDuplicateStrings(str);
	}

}
