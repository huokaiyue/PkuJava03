
public class solution2 {

	public static void main(String[] args) {
		int[] a={2,2,1,0,1,0,2,0,1,1,2,0,2,1};
        int[] b;
        b=swap(a);
        System.out.println(b);
	}
	public static int[] swap(int[] a){
		int i;
		int r,w,b;
		r=w=b=0;
		for(i=0;i<a.length;i++)//��ѭ����ͳ��0,1,2һ�������˶��ٴ�
		{
			if(a[i]==0) r++;
			else if(a[i]==1) w++;
			else b++;
		}
		for(i=0;i<a.length;i++)//���ù�һ�λ껷�ֱ����0,1,2.ʹ��ǰ����0��������2���м���1.
		{
			if(i<r) a[i]=0;
			else if(i<r+w) a[i]=1;
			else a[i]=2;
		}
		
		return a;
		
	}

}
//ʱ�临�Ӷ���n,�Ҿ��ÿ����Ż��ĵط�Ӧ���ǻ�������ʡ��һ��ѭ��
