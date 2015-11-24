public class Solution {
    public int titleToNumber(String s) {
        //先将输入的字母全部变为大写字母
		String ups=s.toUpperCase();
		char[] CharArray=ups.toCharArray();
		int i=0;
		int j=0;
		int colNum=0;
		//如果传进来的字符串是两位数，就要将第一位与Ａ的差乘２６，第二位与Ａ的差相加
		for(i=0;i<CharArray.length;i++)
	//	if(CharArray.length==2){
	//	i=CharArray[0]-'A'+1;
		{j=CharArray[i]-'A'+1;
		colNum=colNum*26+j;}
		//如果传进来的字符串是一位数，直接将其与Ａ作差
		 if(CharArray.length==1) colNum=CharArray[0]-'A'+1;
		//如果没有任何字母，则直接返回零
	//	else colNum=0;
		return colNum;
    }
}