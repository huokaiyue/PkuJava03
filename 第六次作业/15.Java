public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list =new ArrayList<>();
        
        Arrays.sort(nums);
     int num=nums.length;
     if(num<3)
     return list;
     int left,right;
        
     for(int i=0;i<num-2;i++){
          
         if(i!=0&&nums[i]==nums[i-1])
         continue;
         left=i+1;
         right=num-1;
       //  if(left==right||left==i)
       //  if(i!=0 && left==i)
       //continue;
         //else if(i!=0&&right==right)
         //continue;
         while(left<right){
          if(left>i+1&&nums[left]==nums[left-1]){
    
         left++;
         continue;}
          if(right<num-2&&nums[right]==nums[right+1])
         {   right--;
             continue;}
          if(nums[i]+nums[left]+nums[right]==0)
         {//如果三个数的和等于0，就把结果加入到list中
             List<Integer> item=new ArrayList();
             item.add(nums[i]);
             item.add(nums[left]);
             item.add(nums[right]);
             list.add(item);
             //左边继续向右移动，右边继续向左移动，继续判断
             left++;
             right--;
         }
         //如果小于0，则左边应该往右边移动
         else if(nums[i]+nums[left]+nums[right]<0)
             left++;
            // 如果大于0，则右边应该往左移动
             else
             right--;}}
            return list;
     }
      
}