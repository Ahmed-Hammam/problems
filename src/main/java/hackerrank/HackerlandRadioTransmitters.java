package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class HackerlandRadioTransmitters {

	//7 2 4 6 5 9 12 11 
	// 3 ts, 4-9-12
	// k = 2
	 static int hackerlandRadioTransmitters(int[] x, int k) {
	     /*if(x.length==1)
	    	 return 1;
	     
	     Arrays.sort(x);//2 4 5 6 7 9 11 12
	     int count = 0,transmitterHouse=0;
		 for(int i=0;i<x.length;i++){
			 if(transmitterHouse == 0){
				 transmitterHouse = i+1;//5
				 count+=1;
				 continue;
			 }
			 if(x[i]-x[transmitterHouse]>k && x[i]-x[i-1]>=k){
				 transmitterHouse = i;//5
				 count+=1;
			 }else if(i==x.length-1 && x[i]-x[transmitterHouse]>k){
				 count+=1;
			 }
		 }
	     
		 return count;*/
		 
		 Arrays.sort(x);
		 int count = 0;
		 int n = x.length;
		 int transmitterHouse=0;
		 for(int i=0;i<n;i++){
			 transmitterHouse=x[i]+k;
			 count++;
			 i+=k;
			 transmitterHouse = x[--i] + k;
			 i+=k;
			 if(i==n-1 && transmitterHouse<x[i] )
				 count++;
		 }
		 
		 /*int i = 0;
		 count = 0;
		 while (i < n) {
		     count++;
		     int loc = x[i] + k;
		     while (i < n && x[i] <= loc) i++;
		     loc = x[--i] + k;
		     while (i < n && x[i] <= loc) i++;
		 }*/
//		 System.out.println(numOfTransmitters);
		 return count;
	    }

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] x = new int[n];
	        for(int x_i = 0; x_i < n; x_i++){
	            x[x_i] = in.nextInt();
	        }
	        int result = hackerlandRadioTransmitters(x, k);
	        System.out.println(result);
	        in.close();
	    }
}
