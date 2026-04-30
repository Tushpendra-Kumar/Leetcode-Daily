class Solution {

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited,
                        int r, int c, int pr, int pc, char ch) {

        int m = grid.length;
        int n = grid[0].length;

        if (visited[r][c]) return true;

        visited[r][c] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if (grid[nr][nc] != ch) continue;

            // skip parent
            if (nr == pr && nc == pc) continue;

            if (dfs(grid, visited, nr, nc, r, c, ch)) {
                return true;
            }
        }

        return false;
    }
}


// 2. JavaScript :


// var containsCycle = function(grid) {

//     let m = grid.length;
//     let n = grid[0].length;

//     let visited = Array.from({ length: m }, () => Array(n).fill(false));

//     let dirs = [[1,0],[-1,0],[0,1],[0,-1]];

//     function dfs(r, c, pr, pc) {

//         visited[r][c] = true;

//         for (let [dr, dc] of dirs) {
//             let nr = r + dr;
//             let nc = c + dc;

//             if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

//             if (grid[nr][nc] !== grid[r][c]) continue;

//             // parent skip
//             if (nr === pr && nc === pc) continue;

//             if (visited[nr][nc]) return true;

//             if (dfs(nr, nc, r, c)) return true;
//         }

//         return false;
//     }

//     for (let i = 0; i < m; i++) {
//         for (let j = 0; j < n; j++) {

//             if (!visited[i][j]) {
//                 if (dfs(i, j, -1, -1)) return true;
//             }
//         }
//     }

//     return false;
// };

// 3. Python : 

// class Solution:
//     def containsCycle(self, grid):

//         m, n = len(grid), len(grid[0])
//         visited = [[False] * n for _ in range(m)]

//         directions = [(1,0), (-1,0), (0,1), (0,-1)]

//         def dfs(r, c, pr, pc):
//             visited[r][c] = True

//             for dr, dc in directions:
//                 nr, nc = r + dr, c + dc

//                 if nr < 0 or nc < 0 or nr >= m or nc >= n:
//                     continue

//                 if grid[nr][nc] != grid[r][c]:
//                     continue

//                 if nr == pr and nc == pc:
//                     continue

//                 if visited[nr][nc]:
//                     return True

//                 if dfs(nr, nc, r, c):
//                     return True

//             return False

//         for i in range(m):
//             for j in range(n):
//                 if not visited[i][j]:
//                     if dfs(i, j, -1, -1):
//                         return True

//         return False