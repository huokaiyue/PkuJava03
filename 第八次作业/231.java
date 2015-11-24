public class Solution {
    public boolean isPowerOfTwo(int n) {
        //do{
        //如果一个数为偶数，并且可以被２整除，就可以一直判断下去
        for(int i=0;n>1;i++)
		{	if(n>=2&&n%2==0)
				n=n/2;
				//如果一个数为奇数，则可不比判断，直接设为，结果为false
				else {n=0;
				return false;}
		}
		//	else return false;
	//	}while(n>1);
		if(n==1){
			return true;
		}
		return false;
	}
	
}