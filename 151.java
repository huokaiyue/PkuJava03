public class Solution {
    public String reverseWords(String s) {
    		if (s == null || s.length() == 0) {
			return "";
		}
 
		// �ո�ָ��ַ�
		String[] arr = s.split(" ");
		
		//String[arr]  = s.split(" ");
	
		StringBuffer sb = new StringBuffer();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		//return sb.length() == 0 ? "" : sb.toString();
		return sb.length() == 0 ? "" : sb.toString().trim();//ȥ���ո�
	}
}    
   