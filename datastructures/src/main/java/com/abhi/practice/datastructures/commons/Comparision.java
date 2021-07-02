package com.abhi.practice.datastructures.commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparision {
	
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("ABC",1));
		list.add(new Employee("DEF",2));
		list.add(new Employee("EFG",5));
		list.add(new Employee("XYZ",3));
		
		List<String> strLis = new ArrayList<>(); 
		strLis.add("abc");
		strLis.add("bc");
		strLis.add("e");
		strLis.add("adc");
		
		
		Collections.sort(strLis, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length()-o2.length();
			}
			
		});
		Collections.sort(list, new EmpComparatorDesc());
		//Collections.reverse(list);
		//Printing list
		list.forEach(e-> System.out.println(e.name+" "+e.age));
		System.out.println("");
		strLis.forEach(e->System.out.println(e));
		
		
		
		
		
		
		
		
		
		//Employee e1 = new Employee("Saloni", 15);
		//e1.compareTo(new Employee("abc",10));
		
		
		//e1.compareTo(new Employee("abc",10));
	}

}


class Employee implements Comparable<Employee>{
	String name;
	int age;
	public Employee(){};
	public Employee(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if(this.age == o.age) {
			return 0;
		}
		return o.age-this.age;
	};
}

class EmpComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if(o1.age == o2.age) {
			return 0;
		}
		return o1.age-o2.age;
	}
	
}

class EmpComparatorDesc implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if(o1.age == o2.age) {
			return 0;
		}
		return o2.age-o1.age;
	}
	
}