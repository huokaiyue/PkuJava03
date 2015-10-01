import java.io.*;
public class LengthOfLastWord {

	public static void main(String[] args)
	   throws IOException{
		BufferedReader K=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("ÇëÊäÈëÒ»Ó¢ÎÄÓï¾ä£º");
		String a=K.readLine();
		LengthOfLastWord O=new LengthOfLastWord();
		System.out.println(O.LengthOfLastWord(a));
	}
	public int LengthOfLastWord(String s){
	/*	int i=s.length();
		for(int j=i-1;j>=0;j--){
			if(s.charAt(j)==' ')
				break;
		}
		return i-1-j;*/
    /*	int i=s.length()-1;
		while(i>=0&&s.charAt(i)==' '){
			i--;
		}
		if(i<0)
			return 0;
		int j=i;
		while(j-1>=0&&s.charAt(j-1)!=' '){
			j--;
		}
		return i-j+1;*/
		String[] one=s.split(" ");
		for(int i=one.length-1;i>=0;i--){
			System.out.print(i);
			if(one[i].length()>0){
				return one[i].length();
			}
			
		}
		return 0;
		
	}

}
