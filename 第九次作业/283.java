public class Solution {
    public void moveZeroes(int[] nums) {
        //ʹ��ѹ������ķ�ʽ������0������������������ǰ�棬ʣ�µĲ�0
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