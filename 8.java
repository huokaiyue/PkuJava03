import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Atoi {

	public static void main(String[] args)
	   throws IOException{
		BufferedReader K=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入字符串：");
		String a=K.readLine();
		Atoi O=new Atoi();
		System.out.println(O.atoi(a));
	}
	public int atoi(String str){
        	if(str==null||str.length()<1){
        		return 0;
        	}	
        	str=str.trim();//消除空格
        	char mark='+';//用于检查正负
        	int i=0;
        	if(str.charAt(0)=='-'){
        		mark='-';
        		i++;
        	}else if(str.charAt(0)=='+'){
        		i++;
        	}
        	double result=0;
        	while(str.length()>i&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
        		result=result*10+(str.charAt(i)-48);
        		i++;
        	}
        	if(mark=='-'){
        		result=-result;
        	}
        	if(result>Integer.MAX_VALUE)
        		return Integer.MAX_VALUE;
        	if(result<Integer.MIN_VALUE)
        		return Integer.MIN_VALUE;
        	return (int)result;
        	
	}
}