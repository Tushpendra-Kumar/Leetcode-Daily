// JS code in this file is written by 2026-04-15-Shortest-Distance-to-Target-String-problem.js

var closestTarget = function(words, target, startIndex) {
    let n = words.length;          // total words
    let ans = Infinity;            // minimum distance store karega

    // loop through all words
    for (let i = 0; i < n; i++) {

        // check agar current word target hai
        if (words[i] === target) {

            // direct distance (left ya right normal)
            let dist = Math.abs(i - startIndex);

            // circular distance (wrap around)
            let circularDist = n - dist;

            // minimum update karo
            ans = Math.min(ans, dist, circularDist);
        }
    }

    // agar target mila hi nahi
    return ans === Infinity ? -1 : ans;
};

// Time & Space Complexity
// Time: O(n)
// Space: O(1)


// 2. Python Code

// class Solution:
//     def closestTarget(self, words, target, startIndex):
//         n = len(words)
//         ans = float('inf')

//         for i in range(n):
//             if words[i] == target:
//                 dist = abs(i - startIndex)
//                 circularDist = n - dist
//                 ans = min(ans, dist, circularDist)

//         return -1 if ans == float('inf') else ans

// 3. Java Code
// class Solution {
//     public int closestTarget(String[] words, String target, int startIndex) {
//         int n = words.length;
//         int ans = Integer.MAX_VALUE;

//         for (int i = 0; i < n; i++) {
//             if (words[i].equals(target)) {

//                 int dist = Math.abs(i - startIndex);
//                 int circularDist = n - dist;

//                 ans = Math.min(ans, Math.min(dist, circularDist));
//             }
//         }

//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }