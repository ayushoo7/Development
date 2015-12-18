package com.aeesha.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.ayush.util.RunningTime;

/**
 * @author AD00436114
 *<p>Counting Impl to implement counting fort</p>
 *<h1>Implemented Using List Array</h1>
 *
 */
public class CountingImpl implements Counting {
	public void countigSort(){
		RunningTime rStart = new RunningTime();
		long start = rStart.getStartTime();
		System.out.println(start);
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int numberOfInput= Integer.parseInt(scan.nextLine());
		int counter=0;
		List<List<String>> listOfInput = new ArrayList<List<String>>();		
		int[] tempArray = new int[100];
		int[] tempArray2 = new int[100];
		int temp=0;
		List<String> tempDualArray ;
		/*Input form user and inserting in array 
		 * 
		 */
		while(counter<numberOfInput){
			String input = scan.nextLine();
			tempDualArray = Arrays.asList(input.split(" "));
			if(counter++ < (numberOfInput/2)){
				tempDualArray.set(1, "-");
				listOfInput.add(tempDualArray);//l1.get(j++).get(0)
			}
			else{
				listOfInput.add(tempDualArray);
			}			
		}
		String[] listOfOutput = new String[listOfInput.size()];  
		if(listOfInput.size() != numberOfInput){
			System.out.println("Wrong input");
			System.exit(0);
		}		 
		/*Creating temp array containing frequency of each element
		 * 
		 */
		for (List<String> i : listOfInput) {
			tempArray[Integer.parseInt(i.get(0))]++;
		}
		/*Cumulative array of value inserted  
		 * 
		 */
		for(int i =0 ;i<tempArray.length;i++){
			temp = temp + tempArray[i];
			tempArray[i] = temp;
			tempArray2[i]= temp;
			
		}
		/*Sorting the original List
		 * 
		 */
			
		for (List<String> i : listOfInput) {
			if(Integer.parseInt(i.get(0)) != 0 && 
					((tempArray2[Integer.parseInt(i.get(0))]) - tempArray2[Integer.parseInt(i.get(0))-1]) ==1){
				listOfOutput[(tempArray[Integer.parseInt(i.get(0))]-1)]=i.get(1);
			}
			else if(Integer.parseInt(i.get(0)) != 0 && 
					((tempArray2[Integer.parseInt(i.get(0))]) - tempArray2[Integer.parseInt(i.get(0))-1]) >1){
				temp= (tempArray2[Integer.parseInt(i.get(0))] - tempArray[Integer.parseInt(i.get(0))]);
				listOfOutput[tempArray2[Integer.parseInt(i.get(0))-1]+temp]=i.get(1);
				
			}
			else{
				listOfOutput[(tempArray2[Integer.parseInt(i.get(0))]) - tempArray[Integer.parseInt(i.get(0))]]=i.get(1);
			}
			tempArray[Integer.parseInt(i.get(0))]--;			
		}
		/*
		 * Final output for sorted array 
		 */
		for (String i : listOfOutput) {
			System.out.print(i+" ");
		}
		long end = rStart.getEndTime();
		System.out.println(end);
		System.out.println(rStart.timeDiff());
		
	}
}
