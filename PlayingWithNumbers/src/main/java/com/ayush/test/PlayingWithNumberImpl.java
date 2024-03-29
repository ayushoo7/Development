package com.ayush.test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.ayush.util.RunningTime;
/**
 * @author AD00436114
 *
 */
public class PlayingWithNumberImpl implements PlayingWithNumber {
	
	/**
	 * @param args <p>args is the argument to Program argument </p>
	 */
	public static void main(String... args){
		RunningTime r1= new RunningTime();
		System.out.println(r1.getStartTime());
		Scanner scan = new Scanner(System.in);
		String N= scan.nextLine();
		String[] Narray=scan.nextLine().split(" ");
		String Q= scan.nextLine();
		String[] Qarray = scan.nextLine().split(" ");
		//if(Integer.parseInt(N) != Narray.length){
			//System.out.println("Wrong choice");
			//System.exit(-1);
		//}
		//if(Integer.parseInt(Q) != Qarray.length){
			//System.out.println("Wrong choice");
			//System.exit(-1);
		//}
		Arrays.sort (Narray, new PlayingWithNumberImpl().new Element());
		
		
		System.out.println(r1.getEndTime());
		System.out.println(r1.timeDiff()/1000);
		
	}
	
	/**
	 * 
	 * {@code PlayingWithNumberImpl.Element}
	 * 
	 * @author AD00436114
	 *
	 */
	private  class Element implements Comparator<String>{

		public int compare(String o1, String o2) {
			System.out.println(Integer.parseInt(o1));
			return Integer.parseInt(o1) - Integer.parseInt(o2);
		}
		
	}
	

}
