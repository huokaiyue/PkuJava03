import java.util.*;
public class Solution{
public static void main(String[] args) {
	System.out.println("����������Ԫ�ظ�����");
	Scanner fin=new Scanner(System.in);
	int input=fin.nextInt();
	System.out.println("��������������"+input+"��Ԫ�أ�");
    int[] one=new int[input];
    for(int i=0;i<input;i++){
    one[i]=fin.nextInt();	
    }
    System.out.println("������Ԫ�������ƶ�����k");
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
	reversal(nums,0,a-1);   //������ǰm-k�����ǰ��ת��
	reversal(nums,a,m-1);   //�������k�����ǰ��ת��
	reversal(nums,0,m-1);   //�����������ǰ��λ��ת��
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
