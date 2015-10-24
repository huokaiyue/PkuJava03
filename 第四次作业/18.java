public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      /*  int L=num.length();
        int m=0;
        int[] num_two=new int[L];
        Arrays.sort(num);  //对数组num进行排序
        List<List<Integer>> list=new ArrayList<List<Integer>>;
        for(int i=0;i<L-1;i++){
            num_two[m]=num[i];
            for(int j=i+1;j<L;i++){
                if(num[i]!=num[j])
                    num_two[m+1]=num[j];
                    m++;
            }
            
        }*/
        int L=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0;i<L-3;i++){
            if(i!=0&&nums[i]==nums[i-1])
                  continue;
                  for(int j=i+1;j<L-2;j++){
                      if(j!=i+1&&nums[j]==nums[j-1])
                          continue;
                      int font=j+1;
                      int rear=L-1;
                      while(font<rear){
                          if(font!=j+1&&nums[font]==nums[font-1]){
                          font++;
                          continue;
                            
                          }
                          if(rear!=L-1&&nums[rear]==nums[rear+1]){
                            rear--;
                            continue;
                          }
                         
                      int sum=nums[i]+nums[j]+nums[font]+nums[rear];
                      if(sum==target){
                       //  List<List<Integer>> item=new ArrayList<List<Integer>>();  
                         List<Integer> item = new ArrayList<Integer>();
                         item.add(nums[i]);
                         item.add(nums[j]);
                         item.add(nums[font]);
                         item.add(nums[rear]);
                         list.add(item);
                         font++;
                         rear--;
                      }
                      else if(sum>target)
                         rear--;
                         else font++; 
                         
                  }
                  }
        }
        return list;
    }
}