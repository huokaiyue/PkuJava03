public class Solution {
    public int removeElement(int[] nums, int val) {
        int i;
        int count=0;
        int l=0;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]!=val)
            {   
                nums[count++]=nums[i];//如果数组中的值和题目给的值不同的话，按序输入该数组
            }
        }
        //l=nums.length-count;
        return count;//返回最后的长度
    }
}