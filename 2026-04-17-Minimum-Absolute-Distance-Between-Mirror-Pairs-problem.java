class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> pos = new HashMap<>(n);
        int ans = n + 1;
        for (int i = 0; i < n; ++i) {
            if (pos.containsKey(nums[i])) {
                ans = Math.min(ans, i - pos.get(nums[i]));
            }
            pos.put(reverse(nums[i]), i);
        }
        return ans > n ? -1 : ans;
    }

    private int reverse(int x) {
        int y = 0;
        for (; x > 0; x /= 10) {
            y = y * 10 + x % 10;
        }
        return y;
    }
}


// 2. JavaScript:

// var minMirrorPairDistance = function(nums) {
//     let n = nums.length;

//     let map = new Map();  // value -> last index
//     let ans = Infinity;

//     // helper function to reverse number
//     function reverse(x) {
//         let rev = 0;
//         while (x > 0) {
//             rev = rev * 10 + (x % 10);
//             x = Math.floor(x / 10);
//         }
//         return rev;
//     }

//     for (let i = 0; i < n; i++) {

//         // reverse current number
//         let rev = reverse(nums[i]);

//         // check if reverse already seen
//         if (map.has(rev)) {
//             // distance = current index - previous index
//             ans = Math.min(ans, i - map.get(rev));
//         }

//         // store current number index
//         map.set(nums[i], i);
//     }

//     // if no pair found
//     return ans === Infinity ? -1 : ans;
// };

// 3. Python:

// class Solution:
//     def minMirrorPairDistance(self, nums):
//         def reverse(x):
//             rev = 0
//             while x > 0:
//                 rev = rev * 10 + x % 10
//                 x //= 10
//             return rev

//         mp = {}
//         ans = float('inf')

//         for i, num in enumerate(nums):
//             rev = reverse(num)

//             if rev in mp:
//                 ans = min(ans, i - mp[rev])

//             mp[num] = i

//         return -1 if ans == float('inf') else ans