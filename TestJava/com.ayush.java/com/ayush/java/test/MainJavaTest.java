package com.ayush.java.test;

import java.util.ArrayList;
import java.util.List;

public class MainJavaTest {

	public static void main(String[] args) {
		
			Test t1 = new Test();
			List<String> lstString = new ArrayList<>();
			lstString.add("Dwivedi");
			lstString.add("Bla Bla");
			t1.setName("Ayush");
			t1.setKey(lstString);
		
		
			Test t2 = new Test();
			List<String> lstString2 = new ArrayList<>();
			lstString2.add("[RBKeys=");
			lstString2.add("Ayush");
			lstString2.add("Dwivedi]");
			t2.setName("Ayush");
			t2.setKey(lstString2);
		
		List<Test> testList = new ArrayList<>();
		testList.add(t1);
		testList.add(t2);
		List<String> lstString3 = new ArrayList<>();
		lstString3.add("  name =Ayush  ");
		lstString3.addAll(lstString2);
		lstString3.add("caste =gen  ");
		lstString3.add("address =xxxx-ff-rrr  ");
		
	
//				+ "[Test [name=Ayush, key=[Dwivedi, Bla Bla]], Test [name=Ayush, key=[Dwivedi, Bla Bla]]]");
		List<String> rbKeys= new ArrayList<String>();
		Boolean keyInsert= false;
		for (String string : lstString3) {
			if( keyInsert && string.endsWith("]")){
				String substring = string.trim().substring(0, string.trim().length()-1);
				rbKeys.add(substring);				
				keyInsert = false;
				continue;
			}else if(keyInsert){
				rbKeys.add(string);
				continue;
			}else if(keyInsert || string.startsWith("[")){
				String replaceFirst = string.substring(1);
				rbKeys.add(replaceFirst);
				keyInsert = true;
				continue;
			}
			System.out.println(string);
			
			
		}
		System.out.println(rbKeys);
	}

}
