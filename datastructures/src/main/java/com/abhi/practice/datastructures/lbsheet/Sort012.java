package com.abhi.practice.datastructures.lbsheet;

public class Sort012 {
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {0,2,1,2,0,1,0,1};
		sort012(arr);
		
		for (int e : arr) {
			System.out.print(" "+e);
		}
	}
	
	
	public static void sort012(int a[])
    {
        // code here
        int low = 0;
        //int mid = a.length/2;
        int high = a.length-1;
        int i = 0;
        while(i<=high){
            if(a[i]==0){
                int t = a[low];
                a[low] = a[i];
                a[i] = t;
                low++;
                i++;
            }
            else if(a[i] == 2){
                int t = a[high];
                a[high] = a[i];
                a[i] = t;
                high--;
            }
            else {
            	i++;
            }
            
        }
    }

}
