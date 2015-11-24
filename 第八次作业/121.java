public class Solution {
    public int maxProfit(int[] prices) {
        //使用当前价格减去在此之前的最低价格，依次遍历整个数组，就可得到最大的利润
        int length=prices.length;
        if(length<=1||prices==null)
          return 0;
          //int smallest=0;
         int smallest=prices[0];
         int max=0;
         for(int i=1;i<=length-1;i++){
             int profit=prices[i]-smallest;
             if(profit>max){
                 max=profit;
             }
             if(smallest>prices[i]){
                 smallest=prices[i];
             }
         }
         return max;
    }
}