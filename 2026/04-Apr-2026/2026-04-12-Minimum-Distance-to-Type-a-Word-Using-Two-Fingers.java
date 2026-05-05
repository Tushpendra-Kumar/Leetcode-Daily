class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        
        // dp[i][j] = max saved distance
        int[][] dp = new int[n][26];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(word, 0, -1, dp);
    }

    private int helper(String word, int i, int secondFinger, int[][] dp) {
        if (i == word.length()) return 0;

        if (secondFinger != -1 && dp[i][secondFinger] != -1) {
            return dp[i][secondFinger];
        }

        int curr = word.charAt(i) - 'A';

        // Option 1: Use first finger (always continues)
        int useFirst = 0;
        if (i > 0) {
            int prev = word.charAt(i - 1) - 'A';
            useFirst = distance(prev, curr);
        }
        useFirst += helper(word, i + 1, secondFinger, dp);

        // Option 2: Use second finger
        int useSecond = 0;
        if (secondFinger != -1) {
            useSecond = distance(secondFinger, curr);
        }
        useSecond += helper(word, i + 1, i > 0 ? word.charAt(i - 1) - 'A' : -1, dp);

        int ans = Math.min(useFirst, useSecond);

        if (secondFinger != -1) {
            dp[i][secondFinger] = ans;
        }

        return ans;
    }

    private int distance(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}