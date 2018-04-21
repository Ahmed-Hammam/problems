
import java.util.Arrays;
import java.util.OptionalLong;
import java.util.Scanner;
import java.util.stream.LongStream;

public class mini_max_sum_problem {

    static void miniMaxSum(long[] arr) {
    	// java 7 code
    	long sum = 0,min =0, max=0;
        for(long x:arr){
        	sum += x;
        }
        min = sum-arr[0];
        max = arr[0];
        for(long i:arr){
        	min =(min>sum-i)?(sum-i):min;
        	max =(max<sum-i)?(sum-i):max;
        }
        System.out.println(min+" "+max);
    	
    	// java 8 code
    	long sum2 = LongStream.of(arr).sum();
    	final long min2 = sum-arr[0];
        final long max2 = arr[0];
        
        long minVal = Arrays.stream(arr).filter(x->(min2>sum2-x))
        		.map(x->sum2-x).min().orElse(min2);

        long maxVal = Arrays.stream(arr).filter(x->(max2<sum2-x))
        		.map(x->sum2-x).max().orElse(max2);
        
        System.out.println(minVal+" "+maxVal);
        
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        long[] arr = new long[5];
    	
        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < 5; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        miniMaxSum(arr);
    }

}

// 15 -> 1,2,3,4,5	min = 15-1=14,, sum-i<min ---> min = sum-i
// 