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
		//�����ļ��еĵ��ʣ��ļ��еĵ����Կո�ͻس���Ϊ�ָ���
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
		//����һ���ļ����еĵ��ʷ���set1��
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
		//���ڶ����ļ��еĵ��ʷ���set2��
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
		//����һ�����������Ƚ��ļ������ļ����еĵ��ʾͣ��������ͬ�ĵ��ʣ��ͽ���ͬ�ĵ��ʷ���set3�У�����set3���
		Iterator iterator2=set2.iterator();
		while(iterator2.hasNext()){
			String string=(String) iterator2.next();
			if(set1.contains(string))
			set3.add(string);}
		Iterator<String> iterator3 = set3.iterator();
		System.out.print("�ļ������ļ�����������Ϊ:");
		while (iterator3.hasNext()) {
			System.out.print(iterator3.next()+" ");
		}
	//	for (Iterator<String> iterator21 = set2.iterator(); iterator21.hasNext();) {
	//		if (!set1.contains(iterator21)) {
	//			set4.add("iterator21");
	//		}
	//	}
		//���½���һ�����������Ƚϵó��ļ������ļ����в���ͬ�ĵ��ʣ�����set4�У����������
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
		System.out.print("\n�ļ������ļ���s���е���Ϊ:");
		while (iterator4.hasNext()) {
			System.out.print(iterator4.next()+" ");
					}
		//�����ļ������ļ����е��ʵĸ���
		System.out.println("\n�ļ����ܵĵ��ʸ���Ϊ" + set1.size());
		System.out.println("�ļ����еĵ��ʸ���Ϊ" + set2.size());
	}

}
