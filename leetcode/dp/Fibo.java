package leetcode.dp;

public class Fibo {
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        
        System.out.println(FiboTD(n, dp));
    }
    public static int FiboTD(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int f1 = FiboTD(n - 1, dp);
        int f2 = FiboTD(n - 2, dp);
        return dp[n] = f1 + f2;
    }
}
