public class Solution {
    public int addDigits(int num) {
       // int n=0;
       // int i=0;
        if(num<10)//如果本身num就是一位数，则直接返回该数字
        return num;
        while(num>=10)
        {   
            //i=num%10;这种方法把10这个临界值给排除在外
           // n=n+i;
           // num=num/10;
           num=(num/10)+(num%10);
        }
       //if(n>9)
       //{num=n;
        //   while(num>0)
        //{   
        //    i=num%10;不能一直循环
       //     n=n+i;
       //     num=num/10;
       // } 
      // }
       //else return n;
       return num;
    }
}