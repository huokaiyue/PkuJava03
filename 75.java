
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
		for(i=0;i<a.length;i++)//用循环来统计0,1,2一共出现了多少次
		{
			if(a[i]==0) r++;
			else if(a[i]==1) w++;
			else b++;
		}
		for(i=0;i<a.length;i++)//再用过一次魂环分别输出0,1,2.使得前面是0，后面是2，中间是1.
		{
			if(i<r) a[i]=0;
			else if(i<r+w) a[i]=1;
			else a[i]=2;
		}
		
		return a;
		
	}

}
//时间复杂度是n,我觉得可以优化的地方应该是还可以再省略一个循环
