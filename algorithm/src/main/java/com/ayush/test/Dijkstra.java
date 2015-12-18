package com.ayush.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ayush.util.RunningTime;

/**
 * <h1>Code to implement Dijkstra algorithm</h1>
 * 
 * @author AD00436114
 *  *
 */
public class Dijkstra {

	private static final Logger logger =
	        Logger.getLogger(Dijkstra.class.getName());
	static int startPoint=0;
	/**
	 *Number of test cases to be executed 
	 */
	static Integer testcasesnumber;
	/**
	 *Number of edges and vertices seperated by space 
	 */
	static String[] edgesVertices;
	
	/**
	 *Number of vertices 
	 */
	static Integer vertices;
	/**
	 *Number of edges 
	 */
	static Integer edges;
	/**
	 *Weight on each edge 
	 */
	static Integer[][] edgeWeight;
	/**
	 *Final output for each test case 
	 */
	static String[] testCaseOutput;
	/**
	 * 
	 */
	static List<List<Integer>> lsEdgeWeight = new LinkedList<List<Integer>>(); 
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {	
		RunningTime r1= new RunningTime();
		r1.getStartTime();		
		Scanner scan = new Scanner(System.in);
		testcasesnumber = Integer.parseInt(scan.nextLine());
		testCaseOutput = new String[testcasesnumber+1];
		
		/*
		 * <code>runs T number of test cases</code>
		 */
		while(testcasesnumber-- >=1){			
				if(logger.isDebugEnabled()){
				logger.debug("Test case"+(testcasesnumber+1));				
			}			
			edgesVertices = scan.nextLine().split(" ");
			logger.debug(edgesVertices[0] +" "+ edgesVertices[1]);
			vertices = Integer.parseInt(edgesVertices[0]);
			edges = Integer.parseInt(edgesVertices[1]);
			
			if(edges< 1 && edges > ((vertices*(vertices-1))/2)){
			
				if(logger.isDebugEnabled()){
					logger.debug("Sorry wrong entry with edges"+edges);
				}				
			}
			
			
			
			
			
			do{				
				String[] temp =  scan.nextLine().split(" ");
				List<Integer> eachEdge= new LinkedList<Integer>();
				for (String string : temp) {					
					
					eachEdge.add(Integer.parseInt(string));
										
					if(eachEdge.size() > 1 && eachEdge.get(0) > eachEdge.get(1)){
						eachEdge.set(0, eachEdge.get(0)-eachEdge.get(1));
						eachEdge.set(1, eachEdge.get(0)+eachEdge.get(1));
						eachEdge.set(0, eachEdge.get(1)-eachEdge.get(0));
					}					
				}
				lsEdgeWeight.add(eachEdge);
				
			}
			while(--edges >=1);			
			
			
			if(logger.isDebugEnabled()){
				logger.debug("Starting node");
			}
			
			startPoint=Integer.parseInt(scan.nextLine());	
			testCaseOutput[testcasesnumber]=dijikstraAlgoImpl();			
		}
		for (String string : testCaseOutput) {
			System.out.println(string);
		}
		r1.getEndTime();
		logger.debug(r1.timeDiff());
	}
	
	
	
	
	
	
	
	
	
	/**
	 * @return <code>the minimum path String for particular case i.e. the weight of each vertices</code>
	 */
	public static String dijikstraAlgoImpl(){
		
		int max = Integer.MAX_VALUE;
		List<Integer> visited =	new   ArrayList<Integer>();
		int[] presentBuffer = new int[vertices];
		int[] finalBuffer = new int[vertices];		
		
		String finalResult="";
		
		for(int i=0;i<vertices;i++){
			presentBuffer[i]=max;
		}
		
		presentBuffer[startPoint-1]=0;
		finalBuffer[startPoint-1]=-1;		
		
		int visiting = startPoint;
		int min=0;
		int minVertices =startPoint;
		Iterator<List<Integer>> directions = null;		
		do{	
			visited.add(visiting);
			directions = lsEdgeWeight.iterator();
			logger.debug(lsEdgeWeight.size());
			
			//Check for all edges as per update the vertices
			while(directions.hasNext()){
				
				List<Integer> temp= directions.next(); //to get each list vertices
				
				if(temp.get(0) == visiting  ){
					if(presentBuffer[temp.get(0)-1] >0 && 
							(presentBuffer[temp.get(1)-1] > (presentBuffer[visiting-1] + temp.get(2)))){
						presentBuffer[temp.get(1)-1] = presentBuffer[visiting-1] + temp.get(2);
						finalBuffer[temp.get(1)-1] = presentBuffer[temp.get(1)-1] ;
						directions.remove();
						lsEdgeWeight.remove(temp);
					}					 
				}
				else if(temp.get(1) == visiting){
					if(presentBuffer[temp.get(0)-1] > 0 && 
							(presentBuffer[temp.get(0)-1] > (presentBuffer[visiting-1] + temp.get(2)))){
						presentBuffer[temp.get(0)-1] = presentBuffer[visiting-1] + temp.get(2);
						finalBuffer[temp.get(0)-1] = presentBuffer[temp.get(0)-1] ;
						directions.remove();
						lsEdgeWeight.remove(temp);
					}
				}
				//temp.clear();
			}			
			presentBuffer[visiting-1] = -1;  //Need to be changed as its makin thing max in next loop
			min=presentBuffer[0];
			for (int i =0 ;i< presentBuffer.length;i++) {
				if(presentBuffer[i] <= min){  //&lt;= did need to check
					min = presentBuffer[i];
					minVertices= i+1;
				}
			}
			visiting=minVertices;
		}
		while(visited.size() < vertices);
		
		for (int i : finalBuffer) {
			if(i>=0){
				finalResult = finalResult+String.valueOf(i)+" ";
			}
		}
		logger.debug(finalResult);		
		return finalResult;
		
	}
}
