import java.util.Scanner;


public class sulotion {
	

	public static void main(String[] args) {
		int b;
		int d;
		System.out.println("���������֣�");
		Scanner in=new Scanner(System.in);
		b=in.nextInt();
		d=hammingWeight(b);
		System.out.println("1�ĸ���Ϊ��"+d);
		
	}
	public static int hammingWeight(int n){
		int i=0;
	while(n!=0)
//	{if((n&1)==1)//�������㣬��λͬʱΪ1�ǵõ��Ľ��Ϊ1��
//			{i++;//����õ��Ľ��Ϊ1����֤����ǰΪΪ1��ʹi��1��ͳ��1�ĸ���
//	  n=n>>1;}//��n�����ƶ�һλ���ж���һλ�ķ���
//		else n=n>>1;}//��������Ϊ1���������жϽ�������һλ
//		return i;
	{
	    i+=n&1;//��һ���ֵ��ύ��Ϊ���ֳ�����time limited��Ȼ�����¸�д��һ����
	    n>>>=1;//�ò�������һ���ֵ���˼����ͬ�ģ�ȡn��ÿһλ��1�����������ͬʱΪ1����Ϊ1������Ϊ0���������еĽ����������Ϊ����1�ĸ���
	}
	return i;
	}

}
