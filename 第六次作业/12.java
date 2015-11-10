public class Solution {
    public String intToRoman(int num) {
        String str="";
        //一次输出典型的几个数字对应的罗马字母，要特别输出其中几个特别的数字900,400,40,9,4，因为他们不能用连续三个以上的数字来表示
        String[] symbol={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i=0;num!=0;++i){
            //一次和上述字符串数组进行比较，大于该值则减去该值，并记录其罗马字母
            while(num>=value[i]){
                num=num-value[i];
                str=str+symbol[i];
            }
        }
        return str;
    }
}