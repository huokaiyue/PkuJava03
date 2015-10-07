public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> line = new ArrayList<Integer>();
        // 加入第一个1
        
        line.add(1);
        int k = rowIndex;
         if(k <= 0) return line;
          k = rowIndex + 1;
        
        /*
        int k = rowIndex + 1;
        if(k <= 0) return line;*/
        //for(int i = 1; i < =k; i++)

        for(int i = 1; i < k; i++){
            // 计算j+1位置的值，是根据j位置的值和j+1位置的值得到的，相当于往后位移一位
            
/*for(int j = line.size() - 1; j >= 0; j--){
                line.set(j + 1, line.get(j) + line.get(j + 1));*/
           for(int j = line.size() - 2; j >= 0; j--){
                line.set(j + 1, line.get(j) + line.get(j + 1));

            }
            // 加上最后一个1
            line.add(1);
        }
        return line;
    }
}




/*public class Solution {
    public List<Integer> getRow(int rowIndex) {
      List<Integer> list = new ArrayList<>();
        list.add(1);
         
        if (rowIndex==0)
            return list;
         
        for (int i=1; i<=rowIndex; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            int prev=0;
            for (int num : list) {
                if (prev==0){
                    prev = num;
                    continue;
                }
                newList.add(prev+num);
                prev = num;
            }
            newList.add(1);
            list = newList;
        }
         
        return list;
    }
}*/