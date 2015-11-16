package com.h3c;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class file {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * String url1="C:/Users/15300/Desktop/1.doc"; String
		 * url2="C:/Users/15300/Desktop/2.doc"; File file1=new File(url1); File
		 * file2=new File(url2);
		 */
		/*
		 * FileInputStream input1=new
		 * FileInputStream("C:/Users/15300/Desktop/1.txt"); int
		 * ch1=input1.read(); FileInputStream input2=new
		 * FileInputStream("C:/Users/15300/Desktop/2.txt"); int
		 * ch2=input2.read();
		 */
		//读出文件中的单词，文件中的单词以空格和回车作为分隔符
		FileManager file1 = new FileManager("C:/Users/15300/Desktop/1.txt",
				new char[] { '\n', ' ' });
		FileManager file2 = new FileManager("C:/Users/15300/Desktop/2.txt",
				new char[] { '\n', ' ' });
		String Word1 = null;
		String Word2 = null;
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		Set<String> set3 = new HashSet<String>();
		Set<String> set4 = new HashSet<String>();
		// try{
		// FileInputStream out1=new FileInputStream(file1);
		// InputStreamReader isr1=new InputStreamReader(out1);
		// int ch1=0;
		// while((ch1=isr1.read())!=-1){
		//将第一个文件夹中的单词放在set1中
		while ((Word1 = file1.nextWord()) != null) {
			set1.add(Word1);

		}

		// }
		// catch(Exception e){}
		// try{
		// FileInputStream out2=new FileInputStream(file2);
		// InputStreamReader isr2=new InputStreamReader(out2);
		// int ch2=0;
		// while((ch2=isr2.read())!=-1){
		//将第二个文件中的单词放在set2中
		while ((Word2 = file2.nextWord()) != null) {
			set2.add(Word2);

		}

		// }
		// catch(Exception e){}
	//	for (Iterator<String> iterator2 = set2.iterator(); iterator2.hasNext();) {
	//		if (set1.contains(iterator2)) {
	//			set3.add("iterator2");
	//		}
	//	}
		//建立一个迭代器，比较文件１和文件２中的单词就，如果有相同的单词，就将相同的单词放入set3中，并将set3输出
		Iterator iterator2=set2.iterator();
		while(iterator2.hasNext()){
			String string=(String) iterator2.next();
			if(set1.contains(string))
			set3.add(string);}
		Iterator<String> iterator3 = set3.iterator();
		System.out.print("文件１和文件２公共单词为:");
		while (iterator3.hasNext()) {
			System.out.print(iterator3.next()+" ");
		}
	//	for (Iterator<String> iterator21 = set2.iterator(); iterator21.hasNext();) {
	//		if (!set1.contains(iterator21)) {
	//			set4.add("iterator21");
	//		}
	//	}
		//重新建立一个迭代器，比较得出文件１和文件２中不相同的单词，放入set4中，并将其输出
		Iterator iterator21=set2.iterator();
		while(iterator21.hasNext()){
			String string=(String) iterator21.next();
			if(!set1.contains(string))
			set4.add(string);}
		Iterator iterator1=set1.iterator();
		while(iterator1.hasNext()){
			String string=(String) iterator1.next();
			set4.add(string);
		}
		Iterator<String> iterator4 = set4.iterator();
		System.out.print("\n文件１和文件２s所有单词为:");
		while (iterator4.hasNext()) {
			System.out.print(iterator4.next()+" ");
					}
		//读出文件１和文件２中单词的个数
		System.out.println("\n文件１总的单词个数为" + set1.size());
		System.out.println("文件２中的单词个数为" + set2.size());
	}

}
