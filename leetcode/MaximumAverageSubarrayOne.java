package leetcode;

public class MaximumAverageSubarrayOne {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        int x = 0;
        int n = nums.length;
        for(int i = 0; i < k; i++){
            avg += (double)nums[i] / k;
        }
        double ans = avg;
        for(int j = k; j< n; j++){
            avg += (double) nums[j] / k;
            avg -= (double) nums[x] / k;
            x++;
            ans = Math.max(avg, ans);
        }
        return ans;
    }
}
