/**
 * Its the proprietary of Ayush Dwivedi
 * Please contact at https://github.com/ayushoo7
 */
package com.ayush.ladersnake;

/**
 * @author ohm
 *
 */
public class NumberBox {
	private Integer number;
	private Boolean snakePresent;
	private Integer snakeTerminatingNumber;
	private Boolean ladderPresent;
	private Integer laderTerminatingNumber;
	String comments;
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Boolean getSnakePresent() {
		return snakePresent;
	}
	public void setSnakePresent(Boolean snakePresent) {
		this.snakePresent = snakePresent;
	}
	public Integer getSnakeTerminatingNumber() {
		return snakeTerminatingNumber;
	}
	public void setSnakeTerminatingNumber(Integer snakeTerminatingNumber) {
		this.snakeTerminatingNumber = snakeTerminatingNumber;
	}
	public Boolean getLadderPresent() {
		return ladderPresent;
	}
	public void setLadderPresent(Boolean ladderPresent) {
		this.ladderPresent = ladderPresent;
	}
	public Integer getLaderTerminatingNumber() {
		return laderTerminatingNumber;
	}
	public void setLaderTerminatingNumber(Integer laderTerminatingNumber) {
		this.laderTerminatingNumber = laderTerminatingNumber;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((ladderPresent == null) ? 0 : ladderPresent.hashCode());
		result = prime * result + ((laderTerminatingNumber == null) ? 0 : laderTerminatingNumber.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((snakePresent == null) ? 0 : snakePresent.hashCode());
		result = prime * result + ((snakeTerminatingNumber == null) ? 0 : snakeTerminatingNumber.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumberBox other = (NumberBox) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (ladderPresent == null) {
			if (other.ladderPresent != null)
				return false;
		} else if (!ladderPresent.equals(other.ladderPresent))
			return false;
		if (laderTerminatingNumber == null) {
			if (other.laderTerminatingNumber != null)
				return false;
		} else if (!laderTerminatingNumber.equals(other.laderTerminatingNumber))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (snakePresent == null) {
			if (other.snakePresent != null)
				return false;
		} else if (!snakePresent.equals(other.snakePresent))
			return false;
		if (snakeTerminatingNumber == null) {
			if (other.snakeTerminatingNumber != null)
				return false;
		} else if (!snakeTerminatingNumber.equals(other.snakeTerminatingNumber))
			return false;
		return true;
	}
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("NumberBox [number=").append(number).append(", snakePresent=").append(snakePresent)
				.append(", snakeTerminatingNumber=").append(snakeTerminatingNumber).append(", ladderPresent=")
				.append(ladderPresent).append(", laderTerminatingNumber=").append(laderTerminatingNumber)
				.append(", comments=").append(comments).append("]");
		return buffer.toString();
	}
	
	
	
	
	
}
