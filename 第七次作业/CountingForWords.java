import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingForWords {
	public static void main(String[] args) throws IOException {
		String fileReadPath1 ="/Users/zhangkaiyun/AA/text1.txt";
		String fileReadPath2 = "/Users/zhangkaiyun/AA/text2.txt";
		
		//String[] string1, string2;

		String[] string1 = readTxt(fileReadPath1);
		String[] string2 = readTxt(fileReadPath2);

		
		int j = string1.length;
		System.out.println("The first file has " + j + " words");
		int i = string2.length;
		System.out.println("The second file has " + i + " words");

		List<String> l1 = Arrays.asList(string1);
		List<String> l2 = Arrays.asList(string2);
		List<Object> resultList = new ArrayList<>();
		resultList.addAll(l1);
		
		resultList.addAll(l2);
		String[] result = resultList.toArray(new String[i + j]);

		// System.out.println(j);
		// // System.out.println(i);
		// for (int i = 0; i < string2.length; i++) {
		// int a = j + i;
		// string1[a] = string2[i];
		// }
		// String[] string = (String[])result;
		

		ArrayList<String> tem = new ArrayList<>();
		int m = 0;
		// int n = 0;
		for (int x = 0; x < j; x++) {
			if (l2.contains(string1[x])) {
				if (!tem.contains(string1[x])) {
					tem.add(string1[x]);
					// tem.add(" ");
					// n = n + 1;
				}
				// System.out.println(string1[x]);
				m = m + 1;// ����ͳ�ƽ����ĵ�����Ŀ
			}

		}
		System.out.println(tem);
		float c = (float) (j - m) / j;
		float d = (float) (i - m) / i;
		System.out.println("The first file contains " + c * 100
				+ "% different words!");
		System.out.println("The second file contains " + d * 100
				+ "% different words!");
	}

	public static String[] readTxt(String filePath) {
		StringBuffer strarray1 = new StringBuffer();
		String[] ss = null;
		try {
			String encoding = "utf-8";
			String mem = "";
			int mm = 0;
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					System.out.println(lineTxt);
					ss = strarray1.append(lineTxt).toString().split(" ");
//					lineTxt = lineTxt.trim();
//					mem += lineTxt + " ";
//					mm = mm + 1;
				}
//				Thread.sleep(1);
//				strarray1 = mem.split(" ");
				read.close();
//				return ss;
			} else {
				System.out.println("�ļ�������");
			}
		} catch (Exception e) {
			System.out.println("�ļ������쳣");
			e.printStackTrace();
		}
		return ss;
	}

	// Map<String, Integer> map = new HashMap<String, Integer>();
	public static void counting(String[] words)
			throws IOException {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int a = 0;
		for (int j = 0; j < words.length; j++) {
			// map��get������keyֵ��value��ֵ������ֵΪint�������a=words��1�������ǲ�a�Ĵ���
			Integer count = map.get(words[j]);// ����ָ������ӳ���ֵ�������ӳ�䲻�����ü���ӳ���ϵ���򷵻�
												// null
			if (count == null) {
				map.put(words[j], 1);
			} else {
				map.put(words[j], ++count);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {// entrySet()��ӳ���а�����ӳ���ϵ��
																	// set ��ͼ
			System.out.println(entry.getKey() + "," + entry.getValue());
			
			// a����֤�Ƿ�©��ͳ�Ƶ��ʸ����ı���
			a = a + entry.getValue();
		}
		System.out.println(a);
	}

	
}