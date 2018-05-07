package hackerrank;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
// https://stackoverflow.com/questions/32309078/generate-all-contiguous-sequences-from-an-array

public class MaximumSubarraySum {

	static long maximumSum(long[] arr, long m) {

		int length = arr.length;
		long value = 0L;
		long result = 0L;
		
	    for (int i = 0; i < length; i++)
	    {
	    	value = 0L;
	        for (int j = i; j < length; j++)
	        {
	            for (int k = i; k <= j; k++)
	            {
//	                System.out.print(arr[k]);
	            	value += arr[k];
	            }
	            result = result<(value%m)?value%m:result;
//	            System.out.println();
	        }
	    }
		
		return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            long m = in.nextLong();
            long[] a = new long[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextLong();
            }
            long result = maximumSum(a, m);
            System.out.println(result);
        }
        in.close();
    }
}
