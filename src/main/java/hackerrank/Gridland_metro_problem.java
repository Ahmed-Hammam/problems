package hackerrank;

import java.util.Scanner;

public class Gridland_metro_problem {


    static int gridlandMetro(int n, int m, int k, int[][] track) {
        // Complete this function
    	int count = n*m;
    	2. Don't miss the very important note: "A train track may overlap other train tracks within the same row."
    	Consider how this problem might be solved if that weren't true (it would be very easy),
    	and how it changes because of that statement.
    	for(int i = 0; i < track.length; i++){
				count -= Math.abs(track[i][1] - track[i][2])+1;
    	}
    	
    	return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] track = new int[k][3];
        for(int track_i = 0; track_i < k; track_i++){
            for(int track_j = 0; track_j < 3; track_j++){
                track[track_i][track_j] = in.nextInt();
            }
        }
        int[][] track2 = new int[4][3];
        System.out.println(track2[0].length);
        System.out.println(track2.length);
        int result = gridlandMetro(n, m, k, track);
        System.out.println(result);
        in.close();
    }

}
