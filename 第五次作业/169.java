public class Solution {
    public int majorityElement(int[] nums) {
    /* int a=nums.length;
     int sum=0;
     int max=0;
     int m=0;
     for(int i=0;i<a;i++){
       for(int j=i+1;j<a;j++){
        if(nums[i]==nums[j])
           sum+=1;
       }
       if(max<sum){
          max=sum;
          m=nums[i];
       }
     }
     return m;*/
     int mid=0;
     int count=0;
     for(int i=0;i<nums.length;i++){//ÿ�ҳ�����ͬ��Ԫ�أ��ͳɶ�ɾ����������ͬԪ��������һ�룬���ʣ�µ�һ����Ԫ����������
         if(count==0){
             mid=nums[i];
             count=1;
         }
         else
           if(mid==nums[i])
              count++;
           else
             count--;
     }
     return mid;
    }
}