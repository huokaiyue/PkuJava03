public class Solution {
    public int titleToNumber(String s) {
        //�Ƚ��������ĸȫ����Ϊ��д��ĸ
		String ups=s.toUpperCase();
		char[] CharArray=ups.toCharArray();
		int i=0;
		int j=0;
		int colNum=0;
		//������������ַ�������λ������Ҫ����һλ����Ĳ�ˣ������ڶ�λ����Ĳ����
		for(i=0;i<CharArray.length;i++)
	//	if(CharArray.length==2){
	//	i=CharArray[0]-'A'+1;
		{j=CharArray[i]-'A'+1;
		colNum=colNum*26+j;}
		//������������ַ�����һλ����ֱ�ӽ����������
		 if(CharArray.length==1) colNum=CharArray[0]-'A'+1;
		//���û���κ���ĸ����ֱ�ӷ�����
	//	else colNum=0;
		return colNum;
    }
}