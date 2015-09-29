import java.util.*;
public class Solution{
public static void main(String[] args) {
	System.out.println("请输入数组元素个数：");
	Scanner fin=new Scanner(System.in);
	int input=fin.nextInt();
	System.out.println("请向数组中输入"+input+"个元素：");
    int[] one=new int[input];
    for(int i=0;i<input;i++){
    one[i]=fin.nextInt();	
    }
    System.out.println("请输入元素向右移动步数k");
    int k=fin.nextInt();
    Solution1 S=new Solution1();
    S.rotate(one,k);
  //  new Solution1().rotate(one, k);
	}
public static void rotate(int[] nums,int k){
	int m=nums.length;
	k=k%m;
	/*int l=m+k;
	int[] two=new int[l];
	for(int i=0;i<m;i++){
		two[i+k]=nums[i];
	}
	for(int i=0;i<k;i++){
		two[i]=two[i+m];
	}
	for(int i=0;i<m;i++)
	System.out.print(two[i]);*/
	int a=m-k;
	reversal(nums,0,a-1);   //对数组前m-k项进行前后转换
	reversal(nums,a,m-1);   //对数组后k项进行前后转换
	reversal(nums,0,m-1);   //最后对整体进行前后位置转换
	for(int i=0;i<m;i++){
		System.out.print(nums[i]);
	}
}
public static void reversal(int[] num1,int f,int r){
	if(num1==null||num1.length==1)
	return;
	while(f<r){
		int middle=num1[f];
		num1[f]=num1[r];
		num1[r]=middle;
		f++;
		r--;
	}
}
}
