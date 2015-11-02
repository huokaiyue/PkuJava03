public class Solution {
    public int climbStairs(int n) {
        //一个台阶的方法次数为1次，两个台阶的方法次数为2个。n个台阶的方法可以理解成上n-2个台阶，然后2步直接上最后一步；或者上n-1个台阶，再单独上一步。
        if(n==0||n==1||n==2)
        return n;
       // else return climbStairs(n-1)+climbStairs(n-2);
       //刚开始使用递归算法超时了，递归算法重复计算了好多值
       //可以直接将前三次的值取出来，每次计算的时候就可以不用重复计算了，提高了速度
       else {int[] num=new int[n+1];
       num[0]=0;
       num[1]=1;
       num[2]=2;
       for(int i=3;i<=n;i++)
       num[i]=num[i-1]+num[i-2];
       return num[n];}
    }
}