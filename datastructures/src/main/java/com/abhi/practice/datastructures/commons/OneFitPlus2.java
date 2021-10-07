package com.abhi.practice.datastructures.commons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

//Given a playlist of songs , play them in a random way such that the song is not repeated until all of them have been played atleast once.

public class OneFitPlus2 {
	
	public static void main(String[] args) {
		List<Integer> songList = new ArrayList<Integer>();
		songList.add(1);
		songList.add(2);
		songList.add(3);
		songList.add(4);
		songList.add(5);
		sol3(songList);
	}
	
	
	static void sol(int[] list) {
		
		Set<Integer> alreadyPlayed = new HashSet<>();
		for(int a: list) {
			if(!alreadyPlayed.contains(a)) {
				System.out.println("Playing Song :"+a);
				alreadyPlayed.add(a);
			}
		}
		
		
	}
	
	static void sol2(int[] list) {
		int[] played = new int[list.length];
		
		int i =0;
		while(i<list.length) {
			int t = (int) Math.random()%list.length;
			if(played[t] == 0) {
				System.out.println("playing song: " +list[t]);
				played[t] =1;
				i++;
			}
		}
		for(int j = 0;j<played.length;j++) {
			played[j] =0;
		}
		
	}
	
	
	static void sol3(List<Integer> list) {
		List<Integer> played = new ArrayList<Integer>();
		
		Random rand = new Random();
		while(!list.isEmpty()) {
			int q = rand.nextInt(list.size());
			System.out.println("Playing Song:"+list.get(q));
			played.add(list.remove(q));
		}
		
		sol3(played);
		
	}

}



