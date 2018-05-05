package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Gridland_metro_problem {


    static int gridlandMetro(int n, int m, int k, int[][] track) {
        // Complete this function
    	int count = n*m;

    	for(int i = 0; i < track.length; i++){
				count -= Math.abs(track[i][1] - track[i][2])+1;
    	}
    	
    	return count;
    }

    private static class Pairs{
    	long from ,to;

		public Pairs(long from, long to) {
			super();
			this.from = from;
			this.to = to;
		}
    	
    }
    
    static long removeDuplicateTrainTrack(long n, long m, int k,long[][] track){
    	
    	long count = n*m;
    	Map<Long,ArrayList<Pairs>> map = new HashMap<>();
    	for(int i = 0; i < k; i++){
    		long row = track[i][0];
    		long from = track[i][1];
    		long to = track[i][2];
    		boolean isMatched = false;
    		if(map.containsKey(row)){
    			ArrayList<Pairs> values = map.get(row);
    			for(Pairs pair:values){
    				/*
    				 * to < pair.from : means new interval of train track doesn't overlap the current interval
    				 * 					as new interval before current pair
    				 * from > pair.to : means new interval of train track doesn't overlap the current interval
    				 * 					as new interval after current pair
    				 * else if (to < pair.from) = false || (from > pair.to) = false means overlap occurs
    				 * 		so check where's the overlap in from or in tos
    				 */
    				if(!( (to < pair.from) || (from > pair.to))) {
						if (to > pair.to) pair.to = to;
						if (from < pair.from) pair.from = from;
					}
    				/*if( (pair.to == from)|| (pair.from == to)){
    					if(pair.to == from) pair.to = to;
    					if(pair.from == to) pair.from = from;    					
    				}*/
					else {
						values.add(new Pairs(from,to));
						break;
					}
    			}
    			isMatched = true;
    		}if(!isMatched){
    			ArrayList<Pairs> values = new ArrayList<>(1);
    			values.add(new Pairs(from,to));
    			map.put(row, values);    				
    		}
        }
    	
    	for(Map.Entry<Long,ArrayList<Pairs>> entry : map.entrySet()){
    		for(Pairs pair : entry.getValue()){
    			count -= (pair.to - pair.from) +1;
    		}
    	}
    	return count;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long m = in.nextInt();
        int k = in.nextInt();
        long[][] track = new long[k][3];
        for(int track_i = 0; track_i < k; track_i++){
            for(int track_j = 0; track_j < 3; track_j++){
                track[track_i][track_j] = in.nextLong();
            }
        }
//        int[][] track2 = new int[4][3];
//        System.out.println(track2[0].length);
//        System.out.println(track2.length);
        long result = removeDuplicateTrainTrack(n, m, k, track);
        System.out.println(result);
        in.close();
    }

}
