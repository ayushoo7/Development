package com.ayush.util;

/**
 * @author AD00436114
 * This utility is for stating initial running time and ending time
 *
 */
public class RunningTime {
	private static long startTime;
	private static long endTime;
	/**
	 * @return current object end time
	 */
	public long getStartTime() {
		startTime=System.currentTimeMillis();
		return startTime;
	}
	/**
	 * @param startTime set time force fully
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return current object end time
	 */
	public long getEndTime() {
		endTime=System.currentTimeMillis();
		return endTime;
	}
	/**
	 * @param endTime set time force fully
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * @return time difference between start time and end time else return -1 
	 */
	public long timeDiff(){		
		if(startTime > endTime){
			return -1;
		}
		else{
			return  (endTime- startTime);
		}
	}
	
	
}
