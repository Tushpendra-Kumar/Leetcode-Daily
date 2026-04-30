// class Solution {
//     long pref[][];
//     int grid[][];
//     int n;
//     long dp[][][]; 
//     public long maximumScore(int[][] grid) {
//         this.grid = grid;
//         n = grid.length;

//         pref = new long[n+1][n+1];
//         dp = new long[2][n+1][n+1];

//         for(int j=0; j<n; j++) {
//             for(int i=1; i<=n; i++) {
//                 pref[i][j+1] = pref[i-1][j+1] + grid[i-1][j];
//             }
//         }

//         for(int i=0; i<2; i++) {
//             for(int j=0; j<=n; j++) 
//                 Arrays.fill(dp[i][j], -1);
//         }

//         return helper(0,0,1);
//     }

//     long helper(int prevTaken, int prevLen, int col) {
//         // O(n^3)
//         if(col==n+1)
//             return 0;
//         if(dp[prevTaken][prevLen][col]!=-1)
//             return dp[prevTaken][prevLen][col];

//         long ans = 0;
        
//         for(int len=0; len<=n; len++) {
//             long prevans = 0, currans = 0;

//             if(prevTaken==0 && col>1 && len > prevLen) {
//                 prevans = pref[len][col-1] - pref[prevLen][col-1];
//             }

//             // currans
//             if(prevLen > len) {
//                 currans = pref[prevLen][col] - pref[len][col];
//             }

//             long ans1 = currans + prevans + helper(1, len, col+1);
//             long ans2 = prevans + helper(0, len, col+1);

//             ans = Math.max(ans, Math.max(ans1, ans2));
//         }

//         return dp[prevTaken][prevLen][col] = ans;
//     }
// }

// // 2. Javascript :

// // var maximumScore = function(grid) {

// //     let n = grid.length;

// //     let colPrefix = Array.from({length: n}, () => Array(n+1).fill(0));

// //     for (let j = 0; j < n; j++) {
// //         for (let i = 0; i < n; i++) {
// //             colPrefix[j][i+1] = colPrefix[j][i] + grid[i][j];
// //         }
// //     }

// //     let dp = Array.from({length: n}, () => Array(n+1).fill(0));

// //     for (let j = 1; j < n; j++) {

// //         let leftMax = Array(n+1).fill(0);
// //         let rightMax = Array(n+1).fill(0);

// //         leftMax[0] = dp[j-1][0];
// //         for (let i = 1; i <= n; i++) {
// //             leftMax[i] = Math.max(leftMax[i-1], dp[j-1][i]);
// //         }

// //         rightMax[n] = dp[j-1][n];
// //         for (let i = n-1; i >= 0; i--) {
// //             rightMax[i] = Math.max(rightMax[i+1], dp[j-1][i]);
// //         }

// //         for (let i = 0; i <= n; i++) {
// //             let best = Math.max(leftMax[i], rightMax[i]);
// //             dp[j][i] = best;

// //             if (i > 0) {
// //                 dp[j][i] += colPrefix[j-1][i];
// //             }
// //         }
// //     }

// //     return Math.max(...dp[n-1]);
// // };

// // 3. Python :

// // class Solution:
// //     def maximumScore(self, grid):

// //         n = len(grid)

// //         colPrefix = [[0]*(n+1) for _ in range(n)]

// //         for j in range(n):
// //             for i in range(n):
// //                 colPrefix[j][i+1] = colPrefix[j][i] + grid[i][j]

// //         dp = [[0]*(n+1) for _ in range(n)]

// //         for j in range(1, n):

// //             leftMax = [0]*(n+1)
// //             rightMax = [0]*(n+1)

// //             leftMax[0] = dp[j-1][0]
// //             for i in range(1, n+1):
// //                 leftMax[i] = max(leftMax[i-1], dp[j-1][i])

// //             rightMax[n] = dp[j-1][n]
// //             for i in range(n-1, -1, -1):
// //                 rightMax[i] = max(rightMax[i+1], dp[j-1][i])

// //             for i in range(n+1):
// //                 dp[j][i] = max(leftMax[i], rightMax[i])

// //                 if i > 0:
// //                     dp[j][i] += colPrefix[j-1][i]

// //         return max(dp[n-1])