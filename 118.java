public class Solution {
    public List<List<Integer>> generate(int numRows) {
        // 输入0
           List<List<Integer>> list = new ArrayList<>();
        if (numRows==0)
            return list;
        
        // 输入1
        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);
        if (numRows==1)
            return list;
         
        // 输入>1
        for (int i=2; i<=numRows; i++) {
            List<Integer> latest = list.get(list.size()-1);
            List<Integer> line = new ArrayList<>();
            
            /* for(int j = 1; j < i; j++){
                line.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }*/
            
            line.add(1);//加入中间的数
            int prev = 0;
            for (int num : latest) {
                if (prev==0) {
                    prev = num;
                    continue;
                }
                 
                line.add(prev + num);
                prev = num;
            }
            line.add(1);
            list.add(line);
        }
        return list;
    }
}