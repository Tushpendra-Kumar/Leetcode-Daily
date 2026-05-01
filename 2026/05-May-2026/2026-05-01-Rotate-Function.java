class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        long sum = 0;   // total sum of array
        long f = 0;     // F(0)

        // Step 1: calculate total sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }

        long max = f;

        // Step 2: use formula to calculate next rotations
        for (int k = 1; k < n; k++) {
            f = f + sum - (long) n * nums[n - k];
            max = Math.max(max, f);
        }

        return (int) max;
    }
}

// 2. Javascript :

// var maxRotateFunction = function(nums) {
//     let n = nums.length;
//     let totalSum = 0;
//     let F = 0;

//     // Step 1: total sum & F(0)
//     for (let i = 0; i < n; i++) {
//         totalSum += nums[i];
//         F += i * nums[i];
//     }

//     let maxVal = F;

//     // Step 2: use formula
//     for (let k = 1; k < n; k++) {
//         F = F + totalSum - n * nums[n - k];
//         maxVal = Math.max(maxVal, F);
//     }

//     return maxVal;
// };


// 3. Python :

// def maxRotateFunction(nums):
//     n = len(nums)
//     total_sum = sum(nums)

//     # F(0)
//     F = sum(i * nums[i] for i in range(n))
//     max_val = F

//     # use formula
//     for k in range(1, n):
//         F = F + total_sum - n * nums[n - k]
//         max_val = max(max_val, F)

//     return max_val