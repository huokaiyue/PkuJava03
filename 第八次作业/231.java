public class Solution {
    public boolean isPowerOfTwo(int n) {
        //do{
        //���һ����Ϊż�������ҿ��Ա����������Ϳ���һֱ�ж���ȥ
        for(int i=0;n>1;i++)
		{	if(n>=2&&n%2==0)
				n=n/2;
				//���һ����Ϊ��������ɲ����жϣ�ֱ����Ϊ�����Ϊfalse
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