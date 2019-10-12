/**
 * Its the proprietary of Ayush Dwivedi
 * Please contact at https://github.com/ayushoo7
 */
package com.ayush.ladersnake;

/**
 * @author ohm
 *
 */
public class Dice {
	private Integer displayNumber;
	
	

	/**
	 * @return the displayNumber
	 */
	public Integer getDisplayNumber() {
		int displayNumber = (int)(Math.random()*((6-1)+1))+1;
		return Integer.valueOf(displayNumber);
	}



	/**
	 * @param displayNumber the displayNumber to set
	 */
	public void setDisplayNumber(Integer displayNumber) {
		this.displayNumber = displayNumber;
	}



	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Dice [displayNumber=").append(displayNumber).append("]");
		return buffer.toString();
	}
	
	
	
	

}
