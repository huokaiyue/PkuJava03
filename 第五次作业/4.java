public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //���Ȱ�˳��ϲ��������飬Ȼ��Ѱ���������ֵ
      int a=nums1.length;
      int b=nums2.length;
      int q=0;
      double p=0;
      int[] mid=new int[a+b];
      int m=0,n=0,k=0;
      while(m<a&&n<b){
          mid[k]=(nums1[m]<nums2[n])?nums1[m++]:nums2[n++];
          k++;
      }
      while(m<a){
         mid[k]=nums1[m];
         k++;
         m++;
      }
      while(n<b){
          mid[k]=nums2[n];
          k++;
          n++;
      }
      q=a+b;
      if(q%2==0){  //�жϺϲ�������鳤����ż�����������������ż���������м���������ƽ����������������������м���
          p=(mid[q/2-1]+mid[q/2])/2.0;
          return p;
      }else
          return mid[q/2];
    }
}