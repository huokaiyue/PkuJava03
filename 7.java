public class Solution {
    public int reverse(int x) {
        int rst = 0;
        
        while(x != 0) {
            int next_rst = rst * 10 + x % 10;
            x = x / 10;
            if(next_rst/10 != rst) {
                rst  = 0;
                break;
            }
            rst = next_rst;
        }
        return rst;
        //int sign = 1;
        //if(x<0){
           // sign = -1;
            //x = -x;
       // }
         
       // int reversed = 0;
      //  for (; x>0; x /= 10){
       //     reversed = reversed*10 + x%10;
       // }
         
      //  return reversed*sign;
    }
}