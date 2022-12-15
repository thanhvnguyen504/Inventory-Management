import java.time.*;

public class KnapBrute{
    static int max(int a, int b){
        return (a > b) ? a : b;
    }
    
    // Returns maximum value that can placed in a knapsack of size W
    static int knapSack(int W, int wt[], int val[], int n){
        
        // base case
        if(n == 0 || W == 0)
            return 0;
        
        // if Weight of N item is more than knapsack size W, then item not included
        if(wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
        
        // Returns max of 2 cases, N item in bag, and the N item not included.
        else
            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
    }

    public static void main(String[] args){
        Instant start = Instant.now();

         /*3 values
        int val[] = new int[] {60, 100, 120 };
        int wt[] = new int [] {10, 20, 30  };
        */
        

        /* 25 values
        int val[] = new int[] {60, 100, 120, 61, 51, 56, 89, 79, 69, 23, 45, 90, 63, 35, 50, 30, 22, 100, 99, 41, 89, 46, 28, 39, 55 };
        int wt[] = new int[] {10, 20, 30, 15, 25, 20, 15, 50, 25, 35, 19, 30, 80, 22, 15, 99, 33, 44, 30, 25, 51, 30, 15, 11, 22  };
        */

        /* 50 values
        int val[] = {360, 83, 59, 130, 431, 67, 230, 52, 93, 125, 670, 892, 600, 38, 48, 147,
            78, 256, 63, 17, 120, 164, 432, 35, 92, 110, 22, 42, 50, 323, 514, 28, 87, 73, 78, 15, 26,
            78, 210, 36, 85, 189, 274, 43, 33, 10, 19, 389, 276, 312};
        int wt[] = {7, 0, 30, 22, 80, 94, 11, 81, 70, 64, 59, 18, 0, 36, 3, 8, 15, 42, 9,
            0, 42, 47, 52, 32, 26, 48, 55, 6, 29, 84, 2, 4, 18, 56, 7, 29, 93, 44, 71, 30, 86, 66, 31,
            65, 15, 79, 20, 65, 52, 13} */

        int W = 150;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
        Instant end = Instant.now();

        Duration elapsedTime = Duration.between(start, end);
        System.out.println("The Elapsed Time is: " + elapsedTime);
    }
}