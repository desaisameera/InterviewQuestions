import java.util.Arrays;

public class AnagramCheck {
	boolean isAnagram1(String str1, String str2) {
		if(str1 == null && str2 == null) {
			return true;
		}
		if(str1.length() != str2.length()) {
			return false;
		}
		char[]charArray1 = str1.toCharArray();
		char[]charArray2 = str2.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		String sortedString1 = new String(charArray1);
		String sortedString2 = new String(charArray2);
		return sortedString1.equals(sortedString2);
	}
	
	boolean isAnagram2(String str1, String str2) {
		if(str1 == null && str2 == null) {
			return true;
		}
		if(str1.length() != str2.length()) {
			return false;
		}
		int[]count = new int[256];
		
		for(int index1 = 0; index1 < str1.length(); index1++) {
			int index = str1.charAt(index1);
			count[index]++;
		}
		
		for(int index2 = 0; index2 < str2.length(); index2++) {
			int index = str2.charAt(index2);
			count[index]--;
			if(count[index] < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[]args) {
		String str1 = "dog";
		String str2 = "god";
		AnagramCheck ac = new AnagramCheck();
		System.out.print(ac.isAnagram1(str1, str2));
		System.out.print(ac.isAnagram2(str1, str2));
	}
}
