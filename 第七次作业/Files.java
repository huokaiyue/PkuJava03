import java.io.BufferedReader;   
import java.io.File;   
import java.io.FileNotFoundException;   
import java.io.FileReader;   
import java.io.IOException;  
import java.util.*; 
import java.util.Map.Entry;
import java.text.NumberFormat;
public class Files {   

    public static void main(String[] args) {   
        File file = new File("d:\\00\\one.txt"); //所读的文件one.txt和文件two.txt放在该目录下 
        File file1 = new File("d:\\00\\two.txt"); 
        try {   
            FileReader f_reader = new FileReader(file);   
            BufferedReader reader = new BufferedReader(f_reader);   
            FileReader f_reader1 = new FileReader(file1);   
            BufferedReader reader1 = new BufferedReader(f_reader1);  
            String str = reader.readLine();   
            String str1 = reader1.readLine();   
            String a=new String();
            String b=new String();
            String c=new String();
           
            while (str != null) { 
                System.out.println("读取的文件一中单词有：");  
                System.out.println(str);   
                
                //String stringArr[]= str.split(" "); //把字符串转换成字符串数组
                a=str;
                str = reader.readLine();  
               // String stringArr[]= str.split(" "); //把字符串转换成字符串数组
            } 
         //   ArrayList<String>  stringArray = new ArrayList<String> (); 
            //String a=new String();
            //a=str;
            //String[] stringArr1= str1.split(" "); 
            //String[] stringArr= str.split(" "); //把字符串转换成字符串数组
            while (str1 != null) { 
            	System.out.println("读取的文件二中的单词有："); 
                System.out.println(str1); 
               
                //String[] stringArr1=str1.split(" ");
                b=str1;
                str1 = reader1.readLine();   
            } 
          
           String[] stringArr=a.split(" ");
           String[] stringArr1=b.split(" ");
           System.out.println("文件一中单词个数为"+stringArr.length+"个");
           System.out.println("文件二中单词个数为"+stringArr1.length+"个");
            String[] result_union = union(stringArr, stringArr1);
            String[] result_insect = intersect(stringArr, stringArr1);
            System.out.println("两文件中单词并集为：");
            for (String strs : result_union)
            {
            System.out.print(strs+" ");
              }
            System.out.println(" ");
              //   String[] result_insect = intersect(stringArr,stringArr1);
            System.out.println("两个文件中单词的交集为：");
            String[] stringArr2=new String[10];
            int m=0;
            for (String strs : result_insect)
            { 
              System.out.print(strs+" ");
              stringArr2[m]=strs;
              m++;
            }
            System.out.println(" ");
           // System.out.println(stringArr2[0]);
           // String[] stringArr2=c.split(" ");
            System.out.println("属于文件一，但不属于文件二的单词有：");
            String[] result_minus1 = minus(stringArr, stringArr2); 
            double i=0.0,j=0.0;
            for (String stra : result_minus1) {  
                System.out.print(stra+" ");
                i++;
               } 
            System.out.println(" ");
          System.out.print("属于文件一不属于文件二时，所占一的百分比为：");
            // double percent1=stra1.length/stringArr.length;
          double percent1=i/stringArr.length;
          NumberFormat nt = NumberFormat.getPercentInstance();
             //设置百分数精确度2即保留两位小数
          nt.setMinimumFractionDigits(2);
             //最后格式化并输出
          System.out.println(nt.format(percent1));
          System.out.println("属于文件二，但不属于文件一的单词有：");
          String[] result_minus2 = minus(stringArr1, stringArr2); 
          for (String strb : result_minus2) {  
              System.out.print(strb+" ");
              j++;
             } 
          System.out.println(" ");
        System.out.print("属于文件二不属于文件一时，所占二的百分比为：");
        double percent2=j/stringArr1.length;
        NumberFormat nt2 = NumberFormat.getPercentInstance();
           //设置百分数精确度2即保留两位小数
        nt2.setMinimumFractionDigits(2);
           //最后格式化并输出
        System.out.println(nt2.format(percent2));  
            
        } catch (FileNotFoundException e) {   
            e.printStackTrace();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }   
 // 利用set的元素唯一性,求两个字符串数组的并集

    public static String[] union(String[] arr1, String[] arr2)

    {
       Set<String> set = new HashSet<String>();
       for (String str : arr1)
        {
          set.add(str);
        }
       for (String str : arr2)
       {
          set.add(str);
        }
       String[] result = {};
       return set.toArray(result);
    }
    // 求两个数组的交集
    public static String[] intersect(String[] arr1, String[] arr2)
    {
      Map<String, Boolean> map = new HashMap<String, Boolean>();
      List<String> list = new ArrayList<String>();
      for (String str : arr1)
       {
           if (!map.containsKey(str))
           {
                map.put(str, Boolean.FALSE);
            }
        }
      for (String str : arr2)
      {
           if (map.containsKey(str))
         {
           map.put(str, Boolean.TRUE);
         }
       }
      for (Iterator<Entry<String, Boolean>> it = map.entrySet().iterator();it.hasNext();)
      {
        Entry<String,Boolean> e = (Entry<String,Boolean>)it.next();
        if (e.getValue().equals(Boolean.TRUE))
           {
                list.add(e.getKey());
              }
       }
       return list.toArray(new String[] {});
    }
    public static String[] minus(String[] arr1, String[] arr2) {  
        LinkedList<String> list = new LinkedList<String>();  
        LinkedList<String> history = new LinkedList<String>();  
        String[] longerArr = arr1;  
        String[] shorterArr = arr2;  
        
        if (arr1.length > arr2.length) { // 选出较长数组
            longerArr = arr2;  
            shorterArr = arr1;  
        }  
        for (String str : longerArr) {  
            if (!list.contains(str)) {  
                list.add(str);  
            }  
        }  
        for (String str : shorterArr) {  
            if (list.contains(str)) {  
                history.add(str);  
                list.remove(str);  
            } else {  
                if (!history.contains(str)) {  
                    list.add(str);  
                }  
            }  
        }  
  
        String[] result = {};  
        return list.toArray(result);  
    }  
}