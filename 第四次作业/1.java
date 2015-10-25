public class Solution {
    public int[] twoSum(int[] nums, int target) {
     
     /*   这种方法超时了
     Arrays.sort(nums);
        int index1,index2;
        int sum;
        int[] index={0,0};
        for(int i=0;i<nums.length-1;i++)
        {   index1=0;
            index2=nums.length-1;
            while(index1<index2){
                //设两个指针分别从数组的两端开始走
            sum=nums[index1]+nums[index2];
            if(sum==target){
                //如果结果和target相等，则返回他们的位置
                index[0]=index1+1;
                index[1]=index2+1;
                index1++;
                index2--;
            }
            //如果大于target，则让左边的指针右移
            if(sum>target){
                index1++;
            }
            //如果小于target,则让右边的指针左移
            if(sum<target){
                index2--;
            }
            }
        }*/
       // List<Integer> list=new ArrayList<>();
       int[] index={0,0};
     for(int i=0;i<nums.length;i++){
     for(int j=i+1;j<nums.length;j++){
         if(nums[i]+nums[j]==target){
         //list.add(i+1);
        // list.add(j+1);
        index[0]=i+1;
        index[1]=j+1;
            
         }
     }
     }
        return index;
    }
}