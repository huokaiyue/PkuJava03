public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       // int[] num3;
        int i=0;
        int j=0;
       // for(i=0;i<n+m;i++){
        //    nums1[i]=nums1[i]+nums2[i];
    //    }
    //�����飲�е�Ԫ�ط��������ĺ���
    //Ȼ��Ӧ��Array.sort�������ɽ�����������
    for(i=m;i<m+n;i++){
        nums1[i]=nums2[j++];
    }
        Arrays.sort(nums1);
    }
}