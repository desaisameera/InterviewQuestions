
public class StringReverse {
	/*Reverse string iteratively
	 * */
	public String reverseStringIterative(String str) {
		if(str == null || str == "") {
			return str;
		}
		char[]strArray = str.toCharArray();
		int right = strArray.length - 1;
		for(int left = 0; left < right; left++, right--) {
			char temp = strArray[left];
			strArray[left] = strArray[right];
			strArray[right] = temp;
		}
		return new String(strArray);
	}
	public static void main(String[]args) {
		String str = "Hello World";
		StringReverse sr = new StringReverse();
		System.out.println(sr.reverseStringIterative(str));
	}

}
