public class Solution {
    public boolean containsDuplicate(int[] nums) { // Ԫ�ظ�������1�Ž�������Ĳ��� 
        if (nums != null && nums.length > 1) {  //����һ��hashSet
            Set<Integer> set = new HashSet<>(nums.length); 
            for(int i : nums) { // ���Ԫ���Ѿ����ھͷ���true
                if (set.contains(i)) { 
                    return true; } // û�о���ӵ�Ԫ�ؼ����� 
                    else { set.add(i); 
                        
                    } 
                 } 
            } 
                    return false; 
        }
}
