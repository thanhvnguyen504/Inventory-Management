import java.time.*; 

class KnapsackTab1 {

    // Utility function that returns max of two integers 
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the max value that can be put in a knapsack capacity W 
    static void knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n+1][W+1];

        // This builds table K[][] with bottom up approach 
        for (i=0; i <= n; i++) {
            for (w = 0; w <= W; w++) {

                // if item = 0, return 0
                if (i == 0 || w == 0)
                    K[i][w] = 0;

                //if item is 
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
                // Skip the item 
                else
                    K[i][w] = K[i-1][w];
            }
        }
        int res = K[n][W];
        System.out.println("\nMax Value Capacity: " + res);
        System.out.print("\n");

        // This helps print out the items 
        w = W;
        for (i=n; i > 0 && res > 0; i--) {
            if (res == K[i-1][w])
                continue;
            else {
                System.out.println("Item Weight, Value: " + wt[i-1] + ", " + val[i-1]);
                res = res - val[i-1];
                w = w - wt[i-1];
            }
        }
    }

    // Driver code 
    public static void main(String args[]) {
        Instant start = Instant.now();

        int val[] = new int[] {40, 100, 50, 60};
        int wt[] = new int[] {20, 10, 40, 30};
        int W = 60;
        int n = val.length;

        knapSack(W, wt, val, n); 
        Instant end = Instant.now();
        Duration elapsedTime = Duration.between(start, end);
        System.out.println("\nElapsed Time = " + elapsedTime + "\n");
    }
}