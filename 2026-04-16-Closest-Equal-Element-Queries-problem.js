var solveQueries = function(nums, queries) {
    let n = nums.length;

    // Step 1: map value -> sorted indices
    let map = new Map();
    for (let i = 0; i < n; i++) {
        if (!map.has(nums[i])) map.set(nums[i], []);
        map.get(nums[i]).push(i);
    }

    let res = [];

    // Binary search helper (lower bound)
    function lowerBound(arr, target) {
        let left = 0, right = arr.length;
        while (left < right) {
            let mid = Math.floor((left + right) / 2);
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    for (let q of queries) {
        let val = nums[q];
        let arr = map.get(val);

        // only one occurrence
        if (arr.length === 1) {
            res.push(-1);
            continue;
        }

        // find position using binary search
        let idx = lowerBound(arr, q);

        // previous and next indices (circular)
        let prev = arr[(idx - 1 + arr.length) % arr.length];
        let next = arr[idx % arr.length];

        // distances
        let dist1 = Math.abs(q - prev);
        let dist2 = Math.abs(q - next);

        // circular distances
        dist1 = Math.min(dist1, n - dist1);
        dist2 = Math.min(dist2, n - dist2);

        res.push(Math.min(dist1, dist2));
    }

    return res;
};

// | Approach                  | Time         |
// | ------------------------- | ------------ |
// | Tera (findIndex)          | ❌ O(n²)      |
// | Optimized (Binary Search) | ✅ O(n log n) |


// 2. Python version:

// from collections import defaultdict
// import bisect

// class Solution:
//     def solveQueries(self, nums, queries):
//         n = len(nums)
//         mp = defaultdict(list)

//         for i, num in enumerate(nums):
//             mp[num].append(i)

//         res = []

//         for q in queries:
//             arr = mp[nums[q]]

//             if len(arr) == 1:
//                 res.append(-1)
//                 continue

//             idx = bisect.bisect_left(arr, q)

//             prev = arr[(idx - 1) % len(arr)]
//             next_ = arr[idx % len(arr)]

//             dist1 = min(abs(q - prev), n - abs(q - prev))
//             dist2 = min(abs(q - next_), n - abs(q - next_))

//             res.append(min(dist1, dist2))

//         return res

// 3. Java version:

// import java.util.*;

// class Solution {
//     public int[] solveQueries(int[] nums, int[] queries) {
//         int n = nums.length;

//         Map<Integer, List<Integer>> map = new HashMap<>();

//         for (int i = 0; i < n; i++) {
//             map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
//         }

//         int[] res = new int[queries.length];

//         for (int qi = 0; qi < queries.length; qi++) {
//             int q = queries[qi];
//             List<Integer> arr = map.get(nums[q]);

//             if (arr.size() == 1) {
//                 res[qi] = -1;
//                 continue;
//             }

//             int idx = Collections.binarySearch(arr, q);
//             if (idx < 0) idx = -idx - 1;

//             int prev = arr.get((idx - 1 + arr.size()) % arr.size());
//             int next = arr.get(idx % arr.size());

//             int dist1 = Math.min(Math.abs(q - prev), n - Math.abs(q - prev));
//             int dist2 = Math.min(Math.abs(q - next), n - Math.abs(q - next));

//             res[qi] = Math.min(dist1, dist2);
//         }

//         return res;
//     }
// }