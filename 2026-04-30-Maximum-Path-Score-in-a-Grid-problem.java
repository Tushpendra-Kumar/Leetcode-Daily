// class Solution {
//     public int maxPathScore(int[][] grid, int k) {
//         int m = grid.length;
//         int n = grid[0].length;

//         // dp[i][j][cost] = max score at cell (i,j) using cost
//         int[][][] dp = new int[m][n][k + 1];

//         // initialize with -1
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 for (int c = 0; c <= k; c++) {
//                     dp[i][j][c] = -1;
//                 }
//             }
//         }

//         dp[0][0][0] = 0;

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 for (int cost = 0; cost <= k; cost++) {

//                     if (dp[i][j][cost] == -1) continue;

//                     // Move Right
//                     if (j + 1 < n) {
//                         int newCost = cost + getCost(grid[i][j + 1]);
//                         if (newCost <= k) {
//                             dp[i][j + 1][newCost] = Math.max(
//                                 dp[i][j + 1][newCost],
//                                 dp[i][j][cost] + grid[i][j + 1]
//                             );
//                         }
//                     }

//                     // Move Down
//                     if (i + 1 < m) {
//                         int newCost = cost + getCost(grid[i + 1][j]);
//                         if (newCost <= k) {
//                             dp[i + 1][j][newCost] = Math.max(
//                                 dp[i + 1][j][newCost],
//                                 dp[i][j][cost] + grid[i + 1][j]
//                             );
//                         }
//                     }
//                 }
//             }
//         }

//         int ans = -1;
//         for (int c = 0; c <= k; c++) {
//             ans = Math.max(ans, dp[m - 1][n - 1][c]);
//         }

//         return ans;
//     }

//     private int getCost(int val) {
//         if (val == 0) return 0;
//         return 1;
//     }
// }

// 2. Javascript "

// var maxPathScore = function(grid, k) {

//     let m = grid.length, n = grid[0].length;

//     let dp = Array.from({length: m}, () =>
//         Array.from({length: n}, () =>
//             Array(k+1).fill(-1)
//         )
//     );

//     dp[0][0][0] = 0;

//     for (let i = 0; i < m; i++) {
//         for (let j = 0; j < n; j++) {

//             for (let c = 0; c <= k; c++) {

//                 if (dp[i][j][c] === -1) continue;

//                 // right
//                 if (j + 1 < n) {
//                     let val = grid[i][j+1];
//                     let cost = (val === 0 ? 0 : 1);
//                     let score = val;

//                     if (c + cost <= k) {
//                         dp[i][j+1][c+cost] = Math.max(
//                             dp[i][j+1][c+cost],
//                             dp[i][j][c] + score
//                         );
//                     }
//                 }

//                 // down
//                 if (i + 1 < m) {
//                     let val = grid[i+1][j];
//                     let cost = (val === 0 ? 0 : 1);
//                     let score = val;

//                     if (c + cost <= k) {
//                         dp[i+1][j][c+cost] = Math.max(
//                             dp[i+1][j][c+cost],
//                             dp[i][j][c] + score
//                         );
//                     }
//                 }
//             }
//         }
//     }

//     let ans = -1;

//     for (let c = 0; c <= k; c++) {
//         ans = Math.max(ans, dp[m-1][n-1][c]);
//     }

//     return ans;
// };"

// 3. Python :

// class Solution:
//     def maxPathScore(self, grid, k):

//         m, n = len(grid), len(grid[0])

//         dp = [[[-1]*(k+1) for _ in range(n)] for _ in range(m)]

//         dp[0][0][0] = 0

//         for i in range(m):
//             for j in range(n):
//                 for c in range(k+1):

//                     if dp[i][j][c] == -1:
//                         continue

//                     # right
//                     if j+1 < n:
//                         val = grid[i][j+1]
//                         cost = 0 if val == 0 else 1

//                         if c + cost <= k:
//                             dp[i][j+1][c+cost] = max(
//                                 dp[i][j+1][c+cost],
//                                 dp[i][j][c] + val
//                             )

//                     # down
//                     if i+1 < m:
//                         val = grid[i+1][j]
//                         cost = 0 if val == 0 else 1

//                         if c + cost <= k:
//                             dp[i+1][j][c+cost] = max(
//                                 dp[i+1][j][c+cost],
//                                 dp[i][j][c] + val
//                             )

//         return max(dp[m-1][n-1])