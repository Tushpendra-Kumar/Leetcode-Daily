class Solution {
    public int[] maxValue(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            int curr_val = nums[i];
            int curr_left = i;
            int curr_right = i;

            while (!stack.isEmpty() && stack.peek()[0] > nums[i]) {

                int[] top = stack.pop();

                curr_val = Math.max(curr_val, top[0]);

                curr_left = top[1];
            }

            stack.push(new int[]{
                curr_val,
                curr_left,
                curr_right
            });
        }

        for (int[] comp : stack) {

            for (int j = comp[1]; j <= comp[2]; j++) {

                ans[j] = comp[0];
            }
        }

        return ans;
    }
}