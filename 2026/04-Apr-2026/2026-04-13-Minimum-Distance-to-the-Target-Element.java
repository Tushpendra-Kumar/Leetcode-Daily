class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                minDistance = Math.min(minDistance, Math.abs(i - start));
            }
        }

        return minDistance;
    }
}

// 2. JavaScript :

// var getMinDistance = function(nums, target, start) {
//     let minDist = Infinity;

//     for (let i = 0; i < nums.length; i++) {
//         if (nums[i] === target) {
//             minDist = Math.min(minDist, Math.abs(i - start));
//         }
//     }

//     return minDist;
// };

// 3. Python Code

// def getMinDistance(nums, target, start):
//     min_dist = float('inf')

//     for i in range(len(nums)):
//         if nums[i] == target:
//             min_dist = min(min_dist, abs(i - start))

//     return min_dist