package com.rolta.rapidhana.utility;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.print.attribute.standard.Media;

public class TimerTaskExample {

	
	
	public String method(){
		System.out.println("Print");
		Map<String ,Map<String,String>> map = new LinkedHashMap <String ,Map<String,String>>();
		Map <String ,String> m = new HashMap<String, String>(); 
		Map <String ,String> n = new HashMap<String, String>(); 
		m.put("First", "1");
		m.put("Second", "2");
		n.put("Third", "3");
		n.put("Fourth", "4");
		n.put("First", "1");

		System.out.println("n.keySet()"+n.keySet());
		if(m.containsKey(n.keySet())){
			System.out.println("equal");
		}
		/*System.out.println("value of m: "+m);
		System.out.println("value of m: "+n);*/
		
		
		Map<String, String> st=  new HashMap<String, String>();
		
		String num = Calculator.add("1","2");
		//System.out.println(num);
		
		for(String s : map.keySet()){
			st = map.get(s);
			//System.out.println("Here"+st.get("First"));
			//System.out.println("tHere"+st.get("Second"));
		}
		return num;
	}
	
	/*private int count = 5;
	int i = 0;
	public TimerTaskExample(){
		String hash = "#";
		StringBuffer fnl =new StringBuffer("") ;
		for(; i <count;i++){
			
			fnl.append(hash);
		}
		if(i<=3){
		System.out.println("count: "+i);
		}
	}*/
	
	/*public TimerTaskExample(){
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new tmxScheduler(), 1000,1000);
	}
	
	class tmxScheduler extends TimerTask{

		@Override
		public void run() {
			System.out.println("value of count: "+count);
			count++;
			
		}
		
	}*/
	
	public static void main(String[] args){
//		System.out.println("print");
//		new TimerTaskExample();
		TimerTaskExample tm = new TimerTaskExample();
		String str = tm.method();
	}
}
