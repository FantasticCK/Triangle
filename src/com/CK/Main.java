package com.CK;

import java.util.List;

public class Main {

    public static void main(String[] args) {
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) continue;

                if (i == 0) dp[i][j] = triangle.get(0).get(0);

                else {

                    if (j == 0)
                        dp[i][j] = dp[i - 1][0] + triangle.get(i).get(0);

                    else if (j == i)
                        dp[i][j] = dp[i - 1][i - 1] + triangle.get(i).get(i);

                    else {

                        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }

        return min;
    }
}
