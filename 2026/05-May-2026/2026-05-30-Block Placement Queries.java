// class Solution {

//     class Fenwick {
//         int[] bit;

//         Fenwick(int n) {
//             bit = new int[n + 2];
//         }

//         void update(int idx, int val) {
//             while (idx < bit.length) {
//                 bit[idx] = Math.max(bit[idx], val);
//                 idx += idx & -idx;
//             }
//         }

//         int query(int idx) {
//             int res = 0;
//             while (idx > 0) {
//                 res = Math.max(res, bit[idx]);
//                 idx -= idx & -idx;
//             }
//             return res;
//         }
//     }

//     public List<Boolean> getResults(int[][] queries) {

//         int maxX = 0;

//         for (int[] q : queries) {
//             if (q[0] == 1) {
//                 maxX = Math.max(maxX, q[1]);
//             } else {
//                 maxX = Math.max(maxX, q[1]);
//             }
//         }

//         int LIMIT = maxX + 1;

//         TreeSet<Integer> obstacles = new TreeSet<>();
//         obstacles.add(0);
//         obstacles.add(LIMIT);

//         for (int[] q : queries) {
//             if (q[0] == 1) {
//                 obstacles.add(q[1]);
//             }
//         }

//         Fenwick fenwick = new Fenwick(LIMIT + 2);

//         Integer prev = null;
//         for (int pos : obstacles) {
//             if (prev != null) {
//                 fenwick.update(pos, pos - prev);
//             }
//             prev = pos;
//         }

//         List<Boolean> answer = new ArrayList<>();

//         for (int i = queries.length - 1; i >= 0; i--) {

//             int[] q = queries[i];

//             if (q[0] == 2) {

//                 int x = q[1];
//                 int size = q[2];

//                 int lastObstacle = obstacles.floor(x);

//                 int bestGapBefore = fenwick.query(lastObstacle);
//                 int tailGap = x - lastObstacle;

//                 answer.add(Math.max(bestGapBefore, tailGap) >= size);

//             } else {

//                 int pos = q[1];

//                 int left = obstacles.lower(pos);
//                 int right = obstacles.higher(pos);

//                 fenwick.update(right, right - left);

//                 obstacles.remove(pos);
//             }
//         }

//         Collections.reverse(answer);
//         return answer;
//     }
// }