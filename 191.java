import java.util.Scanner;


public class sulotion {
	

	public static void main(String[] args) {
		int b;
		int d;
		System.out.println("请输入数字：");
		Scanner in=new Scanner(System.in);
		b=in.nextInt();
		d=hammingWeight(b);
		System.out.println("1的个数为："+d);
		
	}
	public static int hammingWeight(int n){
		int i=0;
	while(n!=0)
//	{if((n&1)==1)//“与运算，两位同时为1是得到的结果为1”
//			{i++;//如果得到的结果为1，则证明当前为为1，使i加1，统计1的个数
//	  n=n>>1;}//是n向右移动一位，判断下一位的符号
//		else n=n>>1;}//如果结果不为1，则向右判断接下来的一位
//		return i;
	{
	    i+=n&1;//上一部分的提交因为出现出错是time limited，然后重新改写这一部分
	    n>>>=1;//该部分与上一部分的意思是相同的，取n的每一位与1做与操作，若同时为1则结果为1，否则为0，所以所有的结果加起来即为最终1的个数
	}
	return i;
	}

}
