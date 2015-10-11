import java.io.*;
public class Palindrome {

	public static void main(String[] args) 
			throws IOException {
		   BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
		   System.out.println("ÇëÊäÈë×Ö·û´®");
		   String a=k.readLine();
		   Palindrome P=new Palindrome();
		   System.out.println(P.isPalindrome(a));
	}
	public boolean isPalindrome(String s){
		if(s==null){
			return false;
		}
		if(s.length()==0){
			return true;
		}
	/*	int i=0,j=s.length()-1;
		while(i<j){
			char c1=s.charAt(i);
			char c2=s.charAt(j);
			if(c1==c2){
				i++;
				j--;
			}else
				return false;
		}
		return true;*/
		StringBuffer mm=new StringBuffer();
		for(int i=0;i<s.length();i++){
			Character ch=s.charAt(i);
			if(Character.isLetter(ch)||Character.isDigit(ch)){
				char a=Character.toUpperCase(ch);
				mm.append(a);
			}
			else  continue;
				
		}
		int l=0,r=mm.length()-1;
		while(l<r&&r>0){
			char font=mm.charAt(l);
			char rear=mm.charAt(r);
			if(font==rear){
				l++;
				r--;
			}else 
				return false;
		}
		return true;
	}

}
