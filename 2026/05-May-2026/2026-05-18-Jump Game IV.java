// class Solution {
//     public int minJumps(int[] arr) {
//         int n = arr.length;

//         if (n == 1) {
//             return 0;
//         }

//         Map<Integer, List<Integer>> map = new HashMap<>();

//         for (int i = 0; i < n; i++) {

//             map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
//         }

//         Queue<Integer> queue = new LinkedList<>();

//         boolean[] visited = new boolean[n];

//         queue.offer(0);

//         visited[0] = true;

//         int steps = 0;

//         while (!queue.isEmpty()) {

//             int size = queue.size();

//             for (int s = 0; s < size; s++) {

//                 int index = queue.poll();

//                 if (index == n - 1) {
//                     return steps;
//                 }

//                 if (index - 1 >= 0 && !visited[index - 1]) {

//                     visited[index - 1] = true;

//                     queue.offer(index - 1);
//                 }

//                 if (index + 1 < n && !visited[index + 1]) {

//                     visited[index + 1] = true;

//                     queue.offer(index + 1);
//                 }

//                 List<Integer> sameIndexes = map.get(arr[index]);

//                 if (sameIndexes != null) {

//                     for (int next : sameIndexes) {

//                         if (!visited[next]) {

//                             visited[next] = true;

//                             queue.offer(next);
//                         }
//                     }

//                     map.remove(arr[index]);
//                 }
//             }

//             steps++;
//         }

//         return -1;
//     }
// }