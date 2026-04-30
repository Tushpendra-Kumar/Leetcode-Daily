// Java implementation of the solution for the "Sum of Distances" problem

import java.util.*;

class Solution {
    public long[] distance(int[] nums) {

        int n = nums.length;
        long[] res = new long[n];

        // Step 1: group indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: process each group
        for (List<Integer> list : map.values()) {

            int size = list.size();

            long[] prefix = new long[size];
            prefix[0] = list.get(0);

            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            for (int i = 0; i < size; i++) {

                long idx = list.get(i);

                // left side
                long left = (long)i * idx - (i > 0 ? prefix[i - 1] : 0);

                // right side
                long right = (prefix[size - 1] - prefix[i]) - (long)(size - i - 1) * idx;

                res[(int)idx] = left + right;
            }
        }

        return res;
    }
}

// 2. JavaScript implementation of the solution for the "Sum of Distances" problem

// var distance = function(nums) {

//     let n = nums.length;
//     let res = new Array(n).fill(0);

//     // Step 1: group indices
//     let map = new Map();

//     for (let i = 0; i < n; i++) {
//         if (!map.has(nums[i])) map.set(nums[i], []);
//         map.get(nums[i]).push(i);
//     }

//     // Step 2: process each group
//     for (let list of map.values()) {

//         let size = list.length;

//         // prefix sum of indices
//         let prefix = new Array(size);
//         prefix[0] = list[0];

//         for (let i = 1; i < size; i++) {
//             prefix[i] = prefix[i - 1] + list[i];
//         }

//         for (let i = 0; i < size; i++) {

//             let idx = list[i];

//             // left contribution
//             let left = i * idx - (i > 0 ? prefix[i - 1] : 0);

//             // right contribution
//             let right = (prefix[size - 1] - prefix[i]) - (size - i - 1) * idx;

//             res[idx] = left + right;
//         }
//     }

//     return res;
// };

// 3. Python implementation of the solution for the "Sum of Distances" problem

// from collections import defaultdict

// class Solution:
//     def distance(self, nums):

//         n = len(nums)
//         res = [0] * n

//         # Step 1: group indices
//         mp = defaultdict(list)

//         for i, num in enumerate(nums):
//             mp[num].append(i)

//         # Step 2: process each group
//         for lst in mp.values():

//             size = len(lst)

//             # prefix sum
//             prefix = [0] * size
//             prefix[0] = lst[0]

//             for i in range(1, size):
//                 prefix[i] = prefix[i - 1] + lst[i]

//             for i in range(size):

//                 idx = lst[i]

//                 left = i * idx - (prefix[i - 1] if i > 0 else 0)
//                 right = (prefix[-1] - prefix[i]) - (size - i - 1) * idx

//                 res[idx] = left + right

//         return res