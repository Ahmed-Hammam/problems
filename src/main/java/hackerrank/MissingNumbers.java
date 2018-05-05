package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MissingNumbers {

    static int[] missingNumbers(int[] arr, int[] brr) {
        // Complete this function
    	
    	return new int[0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Long,Long> map = new TreeMap<Long,Long>(); 
        for(int arr_i = 0; arr_i < n; arr_i++){
        	long input = in.nextLong();
        	if(!map.containsKey(input)){
        		map.put(input, 1L);
        	}else{
        		long value = map.get(input)+1;
        		map.put(input, value);
        	}
        }
        int m = in.nextInt();
        for(int brr_i = 0; brr_i < m; brr_i++){
        	long input = in.nextLong();
        	if(!map.containsKey(input)){
        		map.put(input, 1L);
        	}else{
        		long value = map.get(input)-1;
        		map.put(input, value);
        	}
        }
        List<Long> result = new ArrayList<>();
        for(Map.Entry<Long, Long> entry : map.entrySet()){
        	Long value = entry.getValue(); 
        	if(value != 0) result.add(entry.getKey());
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i != result.size() - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
