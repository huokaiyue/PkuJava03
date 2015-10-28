public class Solution {
    public String reverseWords(String s) {
       //String[] a=s.split(" "); 
       if(s==null)
          return s;
      
       int font=0,end=0;
       while(font<s.length()&&s.charAt(font)==' '){
           font++;
       }
       if(font==s.length()){
           return "";
       }
        if(s.length()<=1){
           return s;
       }
      StringBuilder result=new StringBuilder("");
      while(font<s.length()&&end<s.length()){
         while(font<s.length()&&s.charAt(font)==' '){
             font++;
         } 
         if(font==s.length())
             break;
         end=font+1;
         while(end<s.length()&&s.charAt(end)!=' '){
             end++;
         }
         if(result.length()!=0){
             result.insert(0," ");
         }
         if(end<s.length()){
             result.insert(0,s.substring(font,end));
         }else{
             result.insert(0,s.substring(font,s.length()));
             break;
         }
         font=end+1;
      }
      return result.toString();
    }
}