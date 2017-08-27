package com.ayush.java.test;

import java.util.List;

public class Test {
	private String name;
	private List<String> key;
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setKey(List<String> key){
	 this.key = key;
	}
	public List<String> getKey(){
		return this.key;
	
	}
	@Override
	public String toString() {
		return "Test [name=" + name + ", key=" + key + "]";
	}
	
	
}
