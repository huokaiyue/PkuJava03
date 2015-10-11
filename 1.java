public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int m=nums.length;
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<m&&j!=i;j++){
                if(nums[i]+nums[j]==target&&j<i)
                return new int[]{j+1,i+1};
                else if(nums[i]+nums[j]==target&&j>i)
                return new int[]{i+1,j+1};
            }
        }
        return null;
    }
}