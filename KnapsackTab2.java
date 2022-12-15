import java.util.*;
import java.time.*; 

class KnapsackTab2 {

    static void knapSack(int W, int wt[], int val[], int n) {

        // Utility function that returns max of two integers 
        int i, w;
        int K[][] = new int[2][W+1];

        
        for (i=0; i <= n; i++) {
            for (w=0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i % 2][w] = 0; 
                else if (wt[i-1] <= w)
                    K[i % 2][w] = Math.max(val[i-1] + K[(i-1) % 2][w - wt[i-1]], K[(i-1) % 2][w]);
                else
                    K[i % 2][w] = K[(i-1) % 2][w];
            }
        }
        int res = K[n % 2][W];
        System.out.println("\nMax Value Capacity: " + res);
        System.out.print("\n");

        w = W;
        for (i=n; i > 0 && res > 0; i--) {
            if (res == K[(i-1) % 2][w])
                continue;
            else {
                // System.out.print(wt[(i-1) % 2] + " ");
                System.out.println("Item Weight, Value: " + wt[(i-1) % 2] + ", " + val[(i-1) % 2]);
                res = res - val[(i-1)];
                w = w - wt[(i-1) % 2];
            }
        }
    }

    public static void main(String[] args) {
        Instant start = Instant.now();

        int val[] = {40, 100, 50, 60};
        int wt[] = {20, 10, 40, 30};
        int W = 60;
        int n = val.length;
        
        knapSack(W, wt, val, n);
        Instant end = Instant.now();
        Duration elapsedTime = Duration.between(start, end);
        System.out.println("\nElapsed Time = " + elapsedTime + "\n");
    }
}