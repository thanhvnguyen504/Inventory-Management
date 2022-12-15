import java.util.*;
  
class KnapsackMem1{
  static void knapSack(int W, int wt[], int val[], int n)
  {
    // making and initializing dp array
    int dp[] = new int[W + 1];
  
  
    for (int i = 1; i < n + 1; i++) {
      for (int w = W; w >= 0; w--) {
  
        if (wt[i - 1] <= w)
            
          // finding the maximum value
          dp[w] = Math.max(dp[w],
                           dp[w - wt[i - 1]] + val[i - 1]);
      }
    }
    int res = dp[W];
    System.out.println("\nMax Value Capacity: " + res);
    System.out.print("\n");

    w = W;
    for (i=n; i > 0 && res > 0; i--) {
        if (res == dp[i-1][w])
            continue;
        else {
            System.out.println("Item Weight, Value: " + wt[i-1] + ", " + val[i-1]);
            res = res - val[i-1];
            w = w - wt[i-1];
        }
    }
}
    
  // Driver code
  public static void main(String[] args)
  {
    int val[] = { 60, 100, 120 };
    int wt[] = { 10, 20, 30 };
    int W = 50;
    int n = val.length;
    System.out.print(knapSack(W, wt, val, n));
  }
}