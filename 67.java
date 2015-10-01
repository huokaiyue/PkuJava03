import java.io.*;
public class Solution {

	public static void main(String args[])
			throws IOException{
     BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("请输入字符串a：");
     String a;
     a=keyin.readLine();
     System.out.println("请输入字符串b：");
     String b;
     b=keyin.readLine();
     //catch(NumberFormatException e){
    	//System.out.println("输入错误，只能输入数值");
   // }
     Solution S=new Solution();
     S.addBinary(a, b);
     System.out.println(S.addBinary(a, b));
	}
	
/*	public void addBinary(String a,String b){
		//String[] a1=new String[a.length()];
		//String[] b1=new String[b.length()];
		int[] a1=new int[a.length()];
		int[] b1=new int[b.length()];
		for(int i=0;i<a.length();i++){
			//a1[i]=a.substring(i,(i+1));
			String m=a.substring(i, (i+1));
			a1[i]=Integer.parseInt(m);
		}
		/*for(int i=0;i<b1.length;i++){
			b1[i]=b.substring(i,(i+1));
		}*/
	/*	for(int i=0;i<b.length();i++){
			//a1[i]=a.substring(i,(i+1));
			String m=b.substring(i, (i+1));
			b1[i]=Integer.parseInt(m);
		}
		//int m=Math.max(a.length, b.length);
		//if(a.length==b.length){}
		//sum(a1,b1);
		int la=a1.length,lb=b1.length;
		if(la>lb){
			int[] b2=new int[la];
			for(int i=0;i<(la-lb);i++){
				b2[i]=0;
			}
			for(int i=(la-lb);i<la;i++){
				b2[i]=b1[i-la+lb];
			}
			int carry=0;
			int[] mid=new int[la+1];
			for(int i=(la-1);i>=0;i--){
				int m=a1[i]+b2[i];
				if(m==0)
				{ mid[i+1]=m+carry;
				  carry=0;
				}
				if(m==1&&carry==0){
					mid[i+1]=m+carry;
					carry=0;
				}
				if(m==1&&carry==1){
					mid[i+1]=0;
					carry=1;
				}
				if(m==2&carry==0){
					mid[i+1]=0;
					carry=1;
				}
				if(m==2&&carry==1){
					mid[i+1]=1;
					carry=1;
				}
			}
			if(carry==1){
				mid[0]=1;
			//String.copyValueOf(mid);
				//for(int i=0;i<la+1;i++){
				//	y=String.valueOf(mid[i]);
				//}
				System.out.println(mid);
			//	return y;
			}
			if(carry==0){
				int[] mid1=new int[la];
				for(int i=0;i<la;i++){
					mid1[i]=mid[i+1];
				}
				//String y;
				//for(int i=0;i<la;i++){
				//	y=String.valueOf(mid1[i]);
				//}
				System.out.println(mid1);
			//	return y;
			}
		}
		if(la<lb){
			int[] a2=new int[lb];
			
			for(int i=0;i<(lb-la);i++){
				a2[i]=0;
			}
			for(int i=(lb-la);i<la;i++){
				a2[i]=a1[i-lb+la];
			}
			int carry=0;
			//int[] c=new int[lb+1];
			int[] mid=new int[lb+1];
			for(int i=(lb-1);i>=0;i--){
				int m=b1[i]+a2[i];
				if(m==0)
				{ mid[i+1]=m+carry;
				  carry=0;
				}
				if(m==1&&carry==0){
					mid[i+1]=m+carry;
					carry=0;
				}
				if(m==1&&carry==1){
					mid[i+1]=0;
					carry=1;
				}
				if(m==2&carry==0){
					mid[i+1]=0;
					carry=1;
				}
				if(m==2&&carry==1){
					mid[i+1]=1;
					carry=1;
				}
			}
			if(carry==1){
				mid[0]=1;
			//	String y;
			//	for(int i=0;i<lb+1;i++){
			//		y=String.valueOf(mid[i]);
			//	}
		//		return y;
				System.out.println(mid);
			}
			if(carry==0){
				int[] mid1=new int[lb];
				for(int i=0;i<lb;i++){
					mid1[i]=mid[i+1];
				}
			//	String y;
			//	for(int i=0;i<lb;i++){
				//	y=String.valueOf(mid1[i]);
			//	}
			//	return y;
				System.out.println(mid1);
			}
		}
	}
/*	public static void sum(int[] a1,int[] b1){
		if(a1.length>b1.length){
			int[] middle=new int[a1.length+1];
			int carry=0;
			for(int i=b1.length;i>=0;i--){
				int s=b1[i]+a[a1.length];
				while(s%2==0){
					carry=1;
					
				}
				  
				 
				}             				
			}
		}*/
	public String addBinary(String a,String b){
		int la=a.length()-1;
		int lb=b.length()-1;
		int a1=0,b1=0;
		int carry=0;
		StringBuffer r=new StringBuffer();
		while(la>=0&&lb>=0){
			a1=a.charAt(la)=='0'?0:1;
			b1=b.charAt(lb)=='0'?0:1;
			int s=a1+b1+carry;
			r.append(s%2==0?'0':'1');
			carry=s>>1;
			la--;
			lb--;
		}
		if(la>=0){
			while(la>=0){
				a1=a.charAt(la)=='0'?0:1;
				int s=a1+carry;
				r.append(s%2==0?'0':'1');
				carry=s>>1;
				la--;
		 }   
		}
		else  if(lb>=0){
			 while(lb>=0){
				 b1=b.charAt(lb)=='0'?0:1;
				 int s=b1+carry;
				 r.append(s%2==0?'0':'1');
				 carry=s>>1;
				 lb--;
			 }
		 }
		if(carry==1){
			r.append('1');
		}
		return r.reverse().toString();		
	//	System.out.println(r.reverse().toString());
	}
	}


