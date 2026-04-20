class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        // compare first element with all
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[0]) {
                maxDist = Math.max(maxDist, i);
            }
        }

        // compare last element with all
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, (n - 1) - i);
            }
        }

        return maxDist;
    }
}

// 2. javascript :

// var maxDistance = function(colors) {

//     let n = colors.length;
//     let maxDist = 0;

//     // Step 1: first element ke saath compare karo
//     for (let i = n - 1; i >= 0; i--) {
//         if (colors[i] !== colors[0]) {
//             maxDist = i;   // distance = i - 0
//             break;
//         }
//     }

//     // Step 2: last element ke saath compare karo
//     for (let i = 0; i < n; i++) {
//         if (colors[i] !== colors[n - 1]) {
//             maxDist = Math.max(maxDist, n - 1 - i);
//             break;
//         }
//     }

//     return maxDist;
// };

// 3. python :

// class Solution:
//     def maxDistance(self, colors):
        
//         n = len(colors)
//         max_dist = 0

//         # compare with first element
//         for i in range(n - 1, -1, -1):
//             if colors[i] != colors[0]:
//                 max_dist = i
//                 break

//         # compare with last element
//         for i in range(n):
//             if colors[i] != colors[n - 1]:
//                 max_dist = max(max_dist, n - 1 - i)
//                 break

//         return max_dist