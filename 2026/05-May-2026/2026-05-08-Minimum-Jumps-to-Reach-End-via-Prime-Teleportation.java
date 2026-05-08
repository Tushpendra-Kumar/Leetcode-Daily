// class Solution {

//     public int minJumps(int[] nums) {

//         int n = nums.length;

//         if (n == 1) return 0;

//         Map<Integer, List<Integer>> map = new HashMap<>();

//         // Store divisible indices
//         for (int i = 0; i < n; i++) {

//             int val = nums[i];

//             for (int d = 1; d * d <= val; d++) {

//                 if (val % d == 0) {

//                     map.computeIfAbsent(d, k -> new ArrayList<>()).add(i);

//                     if (d != val / d) {
//                         map.computeIfAbsent(val / d, k -> new ArrayList<>()).add(i);
//                     }
//                 }
//             }
//         }

//         Queue<Integer> queue = new LinkedList<>();
//         boolean[] visited = new boolean[n];

//         Set<Integer> usedPrime = new HashSet<>();

//         queue.offer(0);
//         visited[0] = true;

//         int steps = 0;

//         while (!queue.isEmpty()) {

//             int size = queue.size();

//             while (size-- > 0) {

//                 int idx = queue.poll();

//                 if (idx == n - 1) return steps;

//                 // Move Left
//                 if (idx - 1 >= 0 && !visited[idx - 1]) {
//                     visited[idx - 1] = true;
//                     queue.offer(idx - 1);
//                 }

//                 // Move Right
//                 if (idx + 1 < n && !visited[idx + 1]) {
//                     visited[idx + 1] = true;
//                     queue.offer(idx + 1);
//                 }

//                 int val = nums[idx];

//                 // Prime Teleportation
//                 if (isPrime(val) && !usedPrime.contains(val)) {

//                     usedPrime.add(val);

//                     List<Integer> next = map.getOrDefault(val, new ArrayList<>());

//                     for (int nextIdx : next) {

//                         if (!visited[nextIdx]) {

//                             visited[nextIdx] = true;
//                             queue.offer(nextIdx);
//                         }
//                     }
//                 }
//             }

//             steps++;
//         }

//         return -1;
//     }

//     private boolean isPrime(int num) {

//         if (num < 2) return false;

//         for (int i = 2; i * i <= num; i++) {

//             if (num % i == 0) return false;
//         }

//         return true;
//     }
// }