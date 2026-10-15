package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < dp.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    int x = dp[j];
                    dp[i] = Math.max(dp[i], x + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
