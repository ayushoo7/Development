package com.ayush.unique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MainDevelopment {
	public static void main(String args[]) {
		int n=6;
		int k=0;
		boolean reverse = false;
		List<Integer> tmp = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			reverse = false;
			
			tmp = new ArrayList<>();
			
			if(i%2==0) {
				reverse = true;
			}
			for(int j=1;j<i;j++) {
				if(reverse) {					
					tmp.add(++k);
					
				}else {
					System.out.print(++k+"*");
				}
			}
			if(reverse) {
				System.out.print(++k+"*");
				if(tmp.size()>0) {
					Collections.reverse(tmp);
					for (Iterator<Integer> iterator = tmp.iterator(); iterator.hasNext();) {
						Integer integer = (Integer) iterator.next();
						if(!iterator.hasNext()) {
							System.out.print(integer );
						}else {
						System.out.print(integer +"*");
						}
						
						
					}
					
				}
				System.out.println();
				
			}
			else {
				System.out.println(++k);
			}
			
		}
		
		
		
	}

}
