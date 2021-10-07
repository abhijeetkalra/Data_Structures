package com.abhi.practice.datastructures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;


public class Practice {
	
	static class PQS implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			return two-one;
		}
	}

	public static void main(String[] args) {
		//testToArrayMethod();
		//testMap();
		toSQLDate();
		
		PriorityQueue<Integer> pql = new PriorityQueue<Integer>(new PQS());
		
		List myList = new ArrayList();
		myList.add("Test");
		myList.add(12);
		myList.add(true);
		myList.add(new Integer(12));
		
	}
	
	public static void testToArrayMethod() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<5;i++) {
			list.add(i);
		}
		Object[] oa = list.toArray();
		Integer[] ia = new Integer[5];
		ia = list.toArray(ia);
		list.set(0, 6);
	}
	
	public static void testMap() {
		Map<ToDo, String> map = new HashMap<ToDo, String>();
		map.put(new ToDo("Monday"), "a");
		map.put(new ToDo("Monday"), "b");
		map.put(new ToDo("Tuesday"), "c");
		System.out.println(map.size());
		TreeSet<String> s = new TreeSet<String>();
	}
	
	
	
	public static void toSQLDate() {
	    int year = 2009;
	    int month = 0; // January
	    int date = 1;

	    Calendar cal = Calendar.getInstance();
	    cal.clear();

	    cal.set(Calendar.YEAR, year);
	    cal.set(Calendar.MONTH, month);
	    cal.set(Calendar.DATE, date);
	    
	    
	    //Calendar calendar = (GregorianCalendar) entityData.getElementValue(SettlementQtyCalculationInputConstant.DOC_POSTING_DATE);
	    //Instant instant = calendar.toInstant();
	    //settlementQuantityCalculationInput.setDocPostingDate(new java.sql.Date(instant.toEpochMilli()));
	    
	    String dStr = "2020-09-30T00:00";  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	    Date date1;
		try {
			date1 = sdf.parse(dStr);
			java.sql.Date sqlDate = new java.sql.Date(date1.getTime()) ;
		    System.out.println(sqlDate);
				
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    Instant ins = Instant.now();

	    java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
	    System.out.println(sqlDate);
	    sqlDate = new java.sql.Date(ins.toEpochMilli());
	    System.out.println(sqlDate);
	  }
	
	
	
}

class ToDo{
	String day;
	ToDo(String s){
		day=s;
	}
}


