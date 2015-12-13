public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] test = new int[26];
        for (int i = 0; i < s.length(); i++){
            test[s.charAt(i) - 'a']++;
        } 
        for (int i = 0; i < t.length(); i++){
             test[t.charAt(i) - 'a']--;
        }
        for(int i=0;i<test.length;i++){
            if(test[i]!=0){
                return false;
            }
        }
        return true;
    }
}
