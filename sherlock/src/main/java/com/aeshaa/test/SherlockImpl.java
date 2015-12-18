package com.aeshaa.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;

public class SherlockImpl implements Sherlock {

	/*
	 * (non-Javadoc)
	 * @see com.aeshaa.test.Sherlock#parseString(java.lang.String)
	 */
	public void parseString(String input) {
		
	    
		
		NavigableMap<Character, Integer> characterIndex = new TreeMap<Character, Integer>();
		char[] character = input.toCharArray();
		for(Character c1 : character){
			if(characterIndex.containsKey(c1)){
				Integer temp=characterIndex.get(c1);
				characterIndex.put(c1, ++temp);
			}
			else{
				characterIndex.put(c1, 1);
			}			
		}
		NavigableSet<Character> navigateDesc = characterIndex.descendingKeySet();
		int test=0;
		loop1: for (Character character2 : navigateDesc) {
			if(characterIndex.get(characterIndex.firstKey()) != characterIndex.get(character2) && test <=2){
				test++;
			}
			else{
				break loop1;
			}
		}
		if(test > 1){
			System.out.println("No");
		}
		else{
			System.out.println("Yes");	
		}
	}
}
