// class Solution {
//   public int maxDistance(int side, int[][] points, int k) {
//     List<int[]> ordered = getOrderedPoints(side, points);
//     int l = 0;
//     int r = side;

//     while (l < r) {
//       final int m = (l + r + 1) / 2;
//       if (isValidDistance(ordered, k, m))
//         l = m;
//       else
//         r = m - 1;
//     }

//     return l;
//   }

//   private record Sequence(int startX, int startY, int endX, int endY, int length) {}

//   // Returns true if we can select `k` points such that the minimum Manhattan
//   // distance between any two consecutive chosen points is at least `m`.
//   private boolean isValidDistance(List<int[]> ordered, int k, int d) {
//     Deque<Sequence> dq = new ArrayDeque<>(List.of(new Sequence(
//         ordered.get(0)[0], ordered.get(0)[1], ordered.get(0)[0], ordered.get(0)[1], 1)));
//     int maxLength = 1;

//     for (int i = 1; i < ordered.size(); ++i) {
//       final int x = ordered.get(i)[0];
//       final int y = ordered.get(i)[1];
//       int startX = x;
//       int startY = y;
//       int length = 1;
//       while (!dq.isEmpty() &&
//              (Math.abs(x - dq.peekFirst().endX()) + Math.abs(y - dq.peekFirst().endY()) >= d)) {
//         if (Math.abs(x - dq.peekFirst().startX()) + Math.abs(y - dq.peekFirst().startY()) >= d &&
//             dq.peekFirst().length() + 1 >= length) {
//           startX = dq.peekFirst().startX();
//           startY = dq.peekFirst().startY();
//           length = dq.peekFirst().length() + 1;
//           maxLength = Math.max(maxLength, length);
//         }
//         dq.pollFirst();
//       }
//       dq.addLast(new Sequence(startX, startY, x, y, length));
//     }

//     return maxLength >= k;
//   }

//   // Returns the ordered points on the perimeter of a square of side length
//   // `side`, starting from left, top, right, and bottom boundaries.
//   private List<int[]> getOrderedPoints(int side, int[][] points) {
//     List<int[]> left = new ArrayList<>();
//     List<int[]> top = new ArrayList<>();
//     List<int[]> right = new ArrayList<>();
//     List<int[]> bottom = new ArrayList<>();

//     for (int[] point : points) {
//       final int x = point[0];
//       final int y = point[1];
//       if (x == 0 && y > 0)
//         left.add(point);
//       else if (x > 0 && y == side)
//         top.add(point);
//       else if (x == side && y < side)
//         right.add(point);
//       else
//         bottom.add(point);
//     }

//     left.sort(Comparator.comparingInt(a -> a[1]));
//     top.sort(Comparator.comparingInt(a -> a[0]));
//     right.sort(Comparator.comparingInt(a -> - a[1]));
//     bottom.sort(Comparator.comparingInt(a -> - a[0]));
//     List<int[]> ordered = new ArrayList<>();
//     ordered.addAll(left);
//     ordered.addAll(top);
//     ordered.addAll(right);
//     ordered.addAll(bottom);
//     return ordered;
//   }
// }

// 2. javascript :

// var maxDistance = function(side, points, k) {

//     // Step 1: convert to 1D perimeter
//     let arr = [];

//     for (let [x, y] of points) {
//         if (y === 0) arr.push(x);
//         else if (x === side) arr.push(side + y);
//         else if (y === side) arr.push(3 * side - x);
//         else arr.push(4 * side - y);
//     }

//     arr.sort((a, b) => a - b);

//     let n = arr.length;
//     let total = 4 * side;

//     // Step 2: check function
//     function can(d) {
//         for (let i = 0; i < n; i++) {

//             let count = 1;
//             let last = arr[i];

//             for (let j = i + 1; j < i + n; j++) {
//                 let curr = arr[j % n];

//                 let dist = curr >= last ? curr - last : curr + total - last;

//                 if (dist >= d) {
//                     count++;
//                     last = curr;
//                 }

//                 if (count >= k) return true;
//             }
//         }
//         return false;
//     }

//     // Step 3: binary search
//     let left = 0, right = total;

//     while (left <= right) {
//         let mid = Math.floor((left + right) / 2);

//         if (can(mid)) left = mid + 1;
//         else right = mid - 1;
//     }

//     return right;
// };

// 3. python :

// class Solution:
//     def maxDistance(self, side, points, k):

//         arr = []

//         # convert to 1D
//         for x, y in points:
//             if y == 0:
//                 arr.append(x)
//             elif x == side:
//                 arr.append(side + y)
//             elif y == side:
//                 arr.append(3 * side - x)
//             else:
//                 arr.append(4 * side - y)

//         arr.sort()
//         n = len(arr)
//         total = 4 * side

//         def can(d):
//             for i in range(n):
//                 count = 1
//                 last = arr[i]

//                 for j in range(i + 1, i + n):
//                     curr = arr[j % n]

//                     dist = curr - last if curr >= last else curr + total - last

//                     if dist >= d:
//                         count += 1
//                         last = curr

//                     if count >= k:
//                         return True
//             return False

//         left, right = 0, total

//         while left <= right:
//             mid = (left + right) // 2

//             if can(mid):
//                 left = mid + 1
//             else:
//                 right = mid - 1

//         return right