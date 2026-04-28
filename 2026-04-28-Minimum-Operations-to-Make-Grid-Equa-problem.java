// class Solution {
//     public int minOperations(int[][] grid, int x) {

//         List<Integer> list = new ArrayList<>();

//         // Step 1: Flatten grid
//         for (int[] row : grid) {
//             for (int val : row) {
//                 list.add(val);
//             }
//         }

//         // Step 2: Check feasibility
//         int remainder = list.get(0) % x;
//         for (int val : list) {
//             if (val % x != remainder) {
//                 return -1;
//             }
//         }

//         // Step 3: Sort
//         Collections.sort(list);

//         // Step 4: Take median
//         int median = list.get(list.size() / 2);

//         // Step 5: Calculate operations
//         int operations = 0;
//         for (int val : list) {
//             operations += Math.abs(val - median) / x;
//         }

//         return operations;
//     }
// }

// // 2. Javascript Version:

// // var minOperations = function(grid, x) {

// //     let arr = [];

// //     for (let row of grid) {
// //         for (let val of row) {
// //             arr.push(val);
// //         }
// //     }

// //     let base = arr[0];

// //     // feasibility check
// //     for (let num of arr) {
// //         if ((num - base) % x !== 0) return -1;
// //     }

// //     arr.sort((a,b) => a-b);

// //     let median = arr[Math.floor(arr.length / 2)];

// //     let ops = 0;

// //     for (let num of arr) {
// //         ops += Math.abs(num - median) / x;
// //     }

// //     return ops;
// // };

// // 3. Python Version:

// // class Solution:
// //     def minOperations(self, grid, x):

// //         arr = [val for row in grid for val in row]

// //         base = arr[0]

// //         # feasibility check
// //         for num in arr:
// //             if (num - base) % x != 0:
// //                 return -1

// //         arr.sort()

// //         median = arr[len(arr)//2]

// //         ops = 0

// //         for num in arr:
// //             ops += abs(num - median) // x

// //         return ops