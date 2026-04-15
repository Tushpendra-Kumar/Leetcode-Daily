/**
 * @param {number[]} robot
 * @param {number[][]} factory
 * @return {number}
 */
var minimumTotalDistance = function(robot, factory) {

    // Step 1: sort robots and factories
    robot.sort((a, b) => a - b);
    factory.sort((a, b) => a[0] - b[0]);

    // Step 2: expand factories into slots
    let slots = [];
    for (let [pos, limit] of factory) {
        for (let i = 0; i < limit; i++) {
            slots.push(pos); // same position repeated 'limit' times
        }
    }

    let n = robot.length;
    let m = slots.length;

    // Step 3: create DP table
    // dp[i][j] = min cost to fix first i robots using first j slots
    let dp = Array.from({ length: n + 1 }, () =>
        Array(m + 1).fill(Infinity)
    );

    // Base case:
    // 0 robots = 0 cost
    for (let j = 0; j <= m; j++) {
        dp[0][j] = 0;
    }

    // Step 4: fill DP
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {

            // Option 1: skip this slot
            dp[i][j] = dp[i][j - 1];

            // Option 2: assign this slot to current robot
            let cost = Math.abs(robot[i - 1] - slots[j - 1]);

            dp[i][j] = Math.min(
                dp[i][j],
                dp[i - 1][j - 1] + cost
            );
        }
    }

    // Final answer
    return dp[n][m];
};


// Time & Space Complexity

// Time: O(n * m)
// Space: O(n * m)



// 2. Python Version

// class Solution:
//     def minimumTotalDistance(self, robot, factory):
//         robot.sort()
//         factory.sort()

//         # expand slots
//         slots = []
//         for pos, limit in factory:
//             slots += [pos] * limit

//         n, m = len(robot), len(slots)

//         dp = [[float('inf')] * (m + 1) for _ in range(n + 1)]

//         for j in range(m + 1):
//             dp[0][j] = 0

//         for i in range(1, n + 1):
//             for j in range(1, m + 1):
//                 # skip
//                 dp[i][j] = dp[i][j - 1]

//                 # take
//                 cost = abs(robot[i - 1] - slots[j - 1])
//                 dp[i][j] = min(dp[i][j], dp[i - 1][j - 1] + cost)

//         return dp[n][m]


//         ## Time & Space Complexity
//         # Time: O(n * m)
//         # Space: O(n * m)


// 3. Java Version

// class Solution {
//     public long minimumTotalDistance(int[] robot, int[][] factory) {

//         Arrays.sort(robot);
//         Arrays.sort(factory, (a, b) -> a[0] - b[0]);

//         List<Integer> slots = new ArrayList<>();

//         // expand factories
//         for (int[] f : factory) {
//             int pos = f[0], limit = f[1];
//             for (int i = 0; i < limit; i++) {
//                 slots.add(pos);
//             }
//         }

//         int n = robot.length;
//         int m = slots.size();

//         long[][] dp = new long[n + 1][m + 1];

//         for (int i = 0; i <= n; i++) {
//             Arrays.fill(dp[i], Long.MAX_VALUE);
//         }

//         for (int j = 0; j <= m; j++) {
//             dp[0][j] = 0;
//         }

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {

//                 // skip
//                 dp[i][j] = dp[i][j - 1];

//                 // take
//                 long cost = Math.abs(robot[i - 1] - slots.get(j - 1));

//                 if (dp[i - 1][j - 1] != Long.MAX_VALUE) {
//                     dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + cost);
//                 }
//             }
//         }

//         return dp[n][m];
//     }
// }