public class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int index = 0;//[0,index]只记录数组中出现的按从小到大的唯一一个数，已经排好序了
        int next = 1;

        // 找index之后的比nums[index]大的数，如是找到就移动到nums[index+1]处，
        // index移动到下一个位置，next移动到下一个位置，再找比nums[index]大的数

        while (next < nums.length) {
            while (next < nums.length && nums[index] == nums[next] ) { // 找不等于数组中最
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