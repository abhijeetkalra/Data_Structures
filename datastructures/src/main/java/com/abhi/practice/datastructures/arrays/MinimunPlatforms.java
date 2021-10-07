package com.abhi.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimunPlatforms {
	
	
	
	public  static int sol(int arr[], int dep[], int n) {
		
		List<Train> lis = new ArrayList<>();
		
		for(int i =0;i<n;i++) {
			
			lis.add(new Train(arr[i], 'a'));
			lis.add(new Train(dep[i], 'd'));
		}
		
		Collections.sort(lis, new Comparator<Train>() {
			public int compare(Train t1, Train t2) {
				if(t1.time == t2.time) return t1.type -t2.type;
				return t1.time - t2.time;
			}
		});
		
		int res = 1;
		int count = 0;
		
	
		for(int i = 0; i< lis.size();i++) {
			
			if(lis.get(i).type == 'a') {
				count ++ ;
			} else {
				count --;
			}
			
			if(count > res) res =count;
		}
		
		return res;
	}

}



class Train{
	int time;
	char type;
	
	public Train(int arv, char type) {
		this.time = arv;
		this.type= type;
	}
}