class Solution {
    public boolean isGood(int[] nums) {

        int n = 0;

        // Find maximum element
        for (int num : nums) {
            n = Math.max(n, num);
        }

        // Length must be n + 1
        if (nums.length != n + 1) {
            return false;
        }

        int[] freq = new int[n + 1];

        // Count frequency
        for (int num : nums) {

            // Invalid number
            if (num > n) {
                return false;
            }

            freq[num]++;
        }

        // Check numbers 1 to n-1
        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) {
                return false;
            }
        }

        // n must appear twice
        return freq[n] == 2;
    }
}