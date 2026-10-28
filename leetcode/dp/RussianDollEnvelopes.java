package leetcode.dp;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
