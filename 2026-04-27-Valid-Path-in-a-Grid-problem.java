// class Solution {

//     public boolean hasValidPath(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;

//         boolean[][] visited = new boolean[m][n];

//         Queue<int[]> queue = new LinkedList<>();
//         queue.offer(new int[]{0, 0});
//         visited[0][0] = true;

//         // Directions: left, right, up, down
//         int[][] dirs = {
//             {0, -1}, {0, 1}, {-1, 0}, {1, 0}
//         };

//         // Allowed directions for each type
//         int[][][] typeDirs = {
//             {}, // dummy (0 index not used)
//             {{0,-1},{0,1}},       // type 1
//             {{-1,0},{1,0}},       // type 2
//             {{0,-1},{1,0}},       // type 3
//             {{0,1},{1,0}},        // type 4
//             {{0,-1},{-1,0}},      // type 5
//             {{0,1},{-1,0}}        // type 6
//         };

//         while (!queue.isEmpty()) {
//             int[] cur = queue.poll();
//             int r = cur[0];
//             int c = cur[1];

//             if (r == m - 1 && c == n - 1) return true;

//             for (int[] d : typeDirs[grid[r][c]]) {
//                 int nr = r + d[0];
//                 int nc = c + d[1];

//                 if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]) continue;

//                 // Check reverse connection
//                 for (int[] back : typeDirs[grid[nr][nc]]) {
//                     if (nr + back[0] == r && nc + back[1] == c) {
//                         visited[nr][nc] = true;
//                         queue.offer(new int[]{nr, nc});
//                     }
//                 }
//             }
//         }

//         return false;
//     }
// }


// 2. Javascript :

// var hasValidPath = function(grid) {

//     let m = grid.length, n = grid[0].length;

//     const dirs = {
//         1: [[0,-1],[0,1]],
//         2: [[-1,0],[1,0]],
//         3: [[0,-1],[1,0]],
//         4: [[0,1],[1,0]],
//         5: [[0,-1],[-1,0]],
//         6: [[0,1],[-1,0]]
//     };

//     let visited = Array.from({length:m}, ()=>Array(n).fill(false));
//     let queue = [[0,0]];
//     visited[0][0] = true;

//     while (queue.length) {

//         let [r,c] = queue.shift();

//         if (r === m-1 && c === n-1) return true;

//         for (let [dr,dc] of dirs[grid[r][c]]) {

//             let nr = r + dr;
//             let nc = c + dc;

//             if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
//             if (visited[nr][nc]) continue;

//             // reverse check
//             for (let [br,bc] of dirs[grid[nr][nc]]) {
//                 if (nr + br === r && nc + bc === c) {
//                     visited[nr][nc] = true;
//                     queue.push([nr,nc]);
//                     break;
//                 }
//             }
//         }
//     }

//     return false;
// };

// 3. Python : 

// from collections import deque

// class Solution:
//     def hasValidPath(self, grid):

//         m, n = len(grid), len(grid[0])

//         dirs = {
//             1: [(0,-1),(0,1)],
//             2: [(-1,0),(1,0)],
//             3: [(0,-1),(1,0)],
//             4: [(0,1),(1,0)],
//             5: [(0,-1),(-1,0)],
//             6: [(0,1),(-1,0)]
//         }

//         visited = [[False]*n for _ in range(m)]
//         q = deque([(0,0)])
//         visited[0][0] = True

//         while q:

//             r,c = q.popleft()

//             if r == m-1 and c == n-1:
//                 return True

//             for dr,dc in dirs[grid[r][c]]:

//                 nr, nc = r+dr, c+dc

//                 if nr<0 or nc<0 or nr>=m or nc>=n:
//                     continue
//                 if visited[nr][nc]:
//                     continue

//                 # reverse connection check
//                 for br,bc in dirs[grid[nr][nc]]:
//                     if nr+br == r and nc+bc == c:
//                         visited[nr][nc] = True
//                         q.append((nr,nc))
//                         break

//         return False