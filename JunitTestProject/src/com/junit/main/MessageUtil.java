package com.junit.main;

public class MessageUtil {

	private String str ;
	
	public String getStr(){
		return this.str;
	}
	public void setStr(String str){
		this.str = str;
	}
	
	public MessageUtil(String str){
		this.str = str;
	}
	
	public String printMessage(){
		System.out.println("Str: "+str);
		return str;
	}
}
