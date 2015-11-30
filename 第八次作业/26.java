public class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int index = 0;//[0,index]ֻ��¼�����г��ֵİ���С�����Ψһһ�������Ѿ��ź�����
        int next = 1;

        // ��index֮��ı�nums[index]������������ҵ����ƶ���nums[index+1]����
        // index�ƶ�����һ��λ�ã�next�ƶ�����һ��λ�ã����ұ�nums[index]�����

        while (next < nums.length) {
            while (next < nums.length && nums[index] == nums[next] ) { // �Ҳ�������������
                next++;
            }

            if (next < nums.length) {
                index++;
                nums[index] = nums[next];
                next++;
            }
        }
        return index + 1;
    }

    private void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}