// class Solution {

//     public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
//         int n = source.length;

//         UnionFind uf = new UnionFind(n);

//         // Step 1: Build connected components
//         for (int[] swap : allowedSwaps) {
//             uf.union(swap[0], swap[1]);
//         }

//         // Step 2: Group indices by root
//         Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

//         for (int i = 0; i < n; i++) {
//             int root = uf.find(i);

//             map.putIfAbsent(root, new HashMap<>());
//             Map<Integer, Integer> freq = map.get(root);

//             freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
//         }

//         // Step 3: Try to match target
//         int mismatch = 0;

//         for (int i = 0; i < n; i++) {
//             int root = uf.find(i);
//             Map<Integer, Integer> freq = map.get(root);

//             if (freq.getOrDefault(target[i], 0) > 0) {
//                 freq.put(target[i], freq.get(target[i]) - 1);
//             } else {
//                 mismatch++;
//             }
//         }

//         return mismatch;
//     }

//     class UnionFind {
//         int[] parent;

//         UnionFind(int n) {
//             parent = new int[n];
//             for (int i = 0; i < n; i++) parent[i] = i;
//         }

//         int find(int x) {
//             if (parent[x] != x)
//                 parent[x] = find(parent[x]);
//             return parent[x];
//         }

//         void union(int a, int b) {
//             parent[find(a)] = find(b);
//         }
//     }
// }


// 2. javascript : 

// var minimumHammingDistance = function(source, target, allowedSwaps) {

//     let n = source.length;

//     // DSU (Union Find)
//     let parent = Array(n).fill(0).map((_, i) => i);

//     function find(x) {
//         if (parent[x] !== x) {
//             parent[x] = find(parent[x]); // path compression
//         }
//         return parent[x];
//     }

//     function union(a, b) {
//         let pa = find(a);
//         let pb = find(b);
//         if (pa !== pb) parent[pa] = pb;
//     }

//     // Step 1: build groups
//     for (let [a, b] of allowedSwaps) {
//         union(a, b);
//     }

//     // Step 2: group -> frequency map
//     let groups = new Map();

//     for (let i = 0; i < n; i++) {
//         let root = find(i);

//         if (!groups.has(root)) {
//             groups.set(root, new Map());
//         }

//         let freq = groups.get(root);
//         freq.set(source[i], (freq.get(source[i]) || 0) + 1);
//     }

//     // Step 3: match with target
//     let ans = 0;

//     for (let i = 0; i < n; i++) {
//         let root = find(i);
//         let freq = groups.get(root);

//         if (freq.get(target[i]) > 0) {
//             // match ho gaya
//             freq.set(target[i], freq.get(target[i]) - 1);
//         } else {
//             // mismatch
//             ans++;
//         }
//     }

//     return ans;
// };

// 3. Python : 

// class Solution:
//     def minimumHammingDistance(self, source, target, allowedSwaps):
        
//         n = len(source)
//         parent = list(range(n))

//         def find(x):
//             if parent[x] != x:
//                 parent[x] = find(parent[x])
//             return parent[x]

//         def union(a, b):
//             pa, pb = find(a), find(b)
//             if pa != pb:
//                 parent[pa] = pb

//         # Step 1: union
//         for a, b in allowedSwaps:
//             union(a, b)

//         # Step 2: group frequencies
//         from collections import defaultdict

//         groups = defaultdict(lambda: defaultdict(int))

//         for i in range(n):
//             root = find(i)
//             groups[root][source[i]] += 1

//         # Step 3: match target
//         ans = 0

//         for i in range(n):
//             root = find(i)
//             if groups[root][target[i]] > 0:
//                 groups[root][target[i]] -= 1
//             else:
//                 ans += 1

//         return ans