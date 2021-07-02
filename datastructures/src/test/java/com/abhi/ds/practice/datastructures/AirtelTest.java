package com.abhi.ds.practice.datastructures;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.abhi.practice.datastructures.Airtel;

import junit.framework.Assert;


public class AirtelTest {
	
	Airtel obj = new Airtel();
	
	@Test
	public void test() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(4);
		list.add(5);
		int a=10;
		float b=3;
		float f=a/b;
		System.out.println(f);
		System.out.println(obj.avg(list));
		Assert.assertEquals(3.33f, f, 0.01);
		
	}

}
