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
        File file = new File("d:\\00\\one.txt"); //�������ļ�one.txt���ļ�two.txt���ڸ�Ŀ¼�� 
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
                System.out.println("��ȡ���ļ�һ�е����У�");  
                System.out.println(str);   
                
                //String stringArr[]= str.split(" "); //���ַ���ת�����ַ�������
                a=str;
                str = reader.readLine();  
               // String stringArr[]= str.split(" "); //���ַ���ת�����ַ�������
            } 
         //   ArrayList<String>  stringArray = new ArrayList<String> (); 
            //String a=new String();
            //a=str;
            //String[] stringArr1= str1.split(" "); 
            //String[] stringArr= str.split(" "); //���ַ���ת�����ַ�������
            while (str1 != null) { 
            	System.out.println("��ȡ���ļ����еĵ����У�"); 
                System.out.println(str1); 
               
                //String[] stringArr1=str1.split(" ");
                b=str1;
                str1 = reader1.readLine();   
            } 
          
           String[] stringArr=a.split(" ");
           String[] stringArr1=b.split(" ");
           System.out.println("�ļ�һ�е��ʸ���Ϊ"+stringArr.length+"��");
           System.out.println("�ļ����е��ʸ���Ϊ"+stringArr1.length+"��");
            String[] result_union = union(stringArr, stringArr1);
            String[] result_insect = intersect(stringArr, stringArr1);
            System.out.println("���ļ��е��ʲ���Ϊ��");
            for (String strs : result_union)
            {
            System.out.print(strs+" ");
              }
            System.out.println(" ");
              //   String[] result_insect = intersect(stringArr,stringArr1);
            System.out.println("�����ļ��е��ʵĽ���Ϊ��");
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
            System.out.println("�����ļ�һ�����������ļ����ĵ����У�");
            String[] result_minus1 = minus(stringArr, stringArr2); 
            double i=0.0,j=0.0;
            for (String stra : result_minus1) {  
                System.out.print(stra+" ");
                i++;
               } 
            System.out.println(" ");
          System.out.print("�����ļ�һ�������ļ���ʱ����ռһ�İٷֱ�Ϊ��");
            // double percent1=stra1.length/stringArr.length;
          double percent1=i/stringArr.length;
          NumberFormat nt = NumberFormat.getPercentInstance();
             //���ðٷ�����ȷ��2��������λС��
          nt.setMinimumFractionDigits(2);
             //����ʽ�������
          System.out.println(nt.format(percent1));
          System.out.println("�����ļ��������������ļ�һ�ĵ����У�");
          String[] result_minus2 = minus(stringArr1, stringArr2); 
          for (String strb : result_minus2) {  
              System.out.print(strb+" ");
              j++;
             } 
          System.out.println(" ");
        System.out.print("�����ļ����������ļ�һʱ����ռ���İٷֱ�Ϊ��");
        double percent2=j/stringArr1.length;
        NumberFormat nt2 = NumberFormat.getPercentInstance();
           //���ðٷ�����ȷ��2��������λС��
        nt2.setMinimumFractionDigits(2);
           //����ʽ�������
        System.out.println(nt2.format(percent2));  
            
        } catch (FileNotFoundException e) {   
            e.printStackTrace();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }   
 // ����set��Ԫ��Ψһ��,�������ַ�������Ĳ���

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
    // ����������Ľ���
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
        
        if (arr1.length > arr2.length) { // ѡ���ϳ�����
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