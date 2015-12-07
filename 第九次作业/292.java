public class Solution {
    public boolean canWinNim(int n) {
    //每个人都取不到4个，自己先拿石子，使得每次剩下的数是4的倍数，那么自己就会赢；相反，如果在石子数是4的倍数情况下，我方先走，则必输；
        if(n%4==0) 
           return false;
        else
           return true;
    }
}