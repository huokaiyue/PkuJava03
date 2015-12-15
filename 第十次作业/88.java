public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       // int[] num3;
        int i=0;
        int j=0;
       // for(i=0;i<n+m;i++){
        //    nums1[i]=nums1[i]+nums2[i];
    //    }
    //将数组２中的元素放在数１的后面
    //然后应用Array.sort函数即可进行重新排列
    for(i=m;i<m+n;i++){
        nums1[i]=nums2[j++];
    }
        Arrays.sort(nums1);
    }
}