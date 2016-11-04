/*
 * Given a string "2-4a0r7-4k", there are two dashes which we can split into 3 groups of length 1, 5, 2. 
 * If we want each group to be length 4, then we get "24A0-R74k" .Given a String A and an int K, return 
 * a correctly formatted string. IF A is "2-4A0r7-4k" and B is 4, string is "24A0-R74K" .
 * IF K is 3, string is "24-A0R-74K" as the first grp could be shorter.
*/
public class FormatString {
	private int findLength(String str, int n) {
		int length = 0;
		for(int index = 0; index < str.length(); index++) {
			if(str.charAt(index) != '-') {
				length++;
			}
		}
		return length % n;
	}
	private String FormatString1(String str, int n) {
		if(str.length() == 0 || str.isEmpty()) {
			return null;
		}
		if(str.length() == n) {
			return str;
		}
		int firstGroupLength = findLength(str, n);
		StringBuffer newString = new StringBuffer(""); // Empty String
		int stringIndex = 0;
		
		//First Group
		if(firstGroupLength > 0) { //If no need for first smaller group
			for(int i = 0; i < firstGroupLength; i++) {
				while(str.charAt(stringIndex) == '-'){
					stringIndex++;
				}
				newString.append(str.charAt(stringIndex));
				stringIndex++;
			}
			newString.append('-');
		}
		
		int count = 0;
		while(stringIndex < str.length()){
			if(str.charAt(stringIndex) == '-') {
				stringIndex++;
			}
			else if(count == n){
				newString.append('-');
				count = 0;
			}
			else{
				newString.append(str.charAt(stringIndex));
				count++;
				stringIndex++;
			}
		}
		return newString.toString();
	}
	
	public static void main(String[]args) {
		String str = "2-4a0r7-4k";
		int n = 4;
		FormatString f = new FormatString();
		String formattedString = f.FormatString1(str, n);
		System.out.println(formattedString);
	}

}
