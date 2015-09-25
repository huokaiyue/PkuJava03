import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Solution1 {

	public static void main(String[] args) {
		int a;
		boolean n;
		System.out.println("请输入一个数字，用来判断是否为happy number：");
		Scanner in=new Scanner(System.in);
		a=in.nextInt();
        n=solution(a);
        if(n)
        	System.out.println("该数是happy number");
        else
        	System.out.println("该数不是happy number");
	}
   public static boolean solution(int i)
   {   boolean c;
       c=true;
	   if(i<1)
		   {c=false;
		   return c;}
	   if(i==1)
	   { c=true;
	   return c;}
	   if(i>1)
	   {  Set<Integer> set=new HashSet<Integer>();//实例化一个hash对象
	   while(i!=1)
	   {
		   int sum=0;
		   while(i>0)
		   {
			   sum+=(i%10)*(i%10);
			   i=i/10;
		   }
		   if(set.contains(sum))
		   {
			   c=false;
			   return c;
		   }
		   else
		   {
			   set.add(sum);//把对象添加都hashset中
		   }
		   i=sum;
	   }
	   c=true;
	   
	   }return c;
   }
}
		   //int mode=1;
		  // int j=i;
		  // int sum=0;
		 //  while(j>=10)
		 //  {
		//	   j=j/10;
		//	   mode=mode*10;  
		//   }
		 //  while(mode>0)
		 //  {
		//	   sum+=(i/mode)*(i/mode);
		//	   i=i%mode;
		//	   sum+=i*i;
		//	   mode=mode/10;
		  // }
		   //int s = 0;
      // while(i!=0)
       //{
        //   s += (i % 10) * (i % 10);
         //  i = i / 10;
      // }
		   //int sum=0;
		  // while(i!=0)
		  // {i=(i%10)*(i%10)+(i/10)*(i/10);
		     
		  // }
		//   if(sum==1)
		//	   {c=true;
		//   return c;}
		//   else  {c=false;
		 //  return c;}
	 //  }
	//return c;
  // }
//}
//时间复杂度是n