public class Solution {
    public void moveZeroes(int[] nums) {
        //使用压缩数组的方式，将非0的数依次排在数组最前面，剩下的补0
        int position=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[position]=nums[i];
                position++;
            }
        }
        while(position<nums.length){
            nums[position]=0;
            position++;
        }
    }
}