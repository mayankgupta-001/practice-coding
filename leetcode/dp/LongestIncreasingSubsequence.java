package leetcode.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        IO.println(lengthOfLIS(nums));
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
    public  static int lengthOfLIS_N_LogN(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i++){
            if(dp[len-1] < nums[i]){
                dp[len++] = nums[i];
            } else {
                int idx = BinarySearch(dp, 0, len-1, nums[i]);
                dp[idx] = nums[i];
            }
        }
        return len;
    }
    private static int BinarySearch(int[] dp, int low, int high, int target){
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(dp[mid] < target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
