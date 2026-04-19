class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int maxDist = 0;

        while (i < n1 && j < n2) {

            if (nums1[i] <= nums2[j]) {
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDist;
    }
}

// 2. Java Solution :

// var maxDistance = function(nums1, nums2) {

//     let i = 0; // pointer for nums1
//     let j = 0; // pointer for nums2
//     let maxDist = 0;

//     // jab tak dono arrays ke andar hain
//     while (i < nums1.length && j < nums2.length) {

//         // valid condition
//         if (nums1[i] <= nums2[j]) {
//             // distance update karo
//             maxDist = Math.max(maxDist, j - i);

//             // j ko aage badhao (distance increase karne ke liye)
//             j++;
//         } else {
//             // invalid hai → i ko aage badhao
//             i++;
//         }
//     }

//     return maxDist;
// };

// 3. Python Solution :

// class Solution:
//     def maxDistance(self, nums1, nums2):
        
//         i, j = 0, 0
//         max_dist = 0

//         while i < len(nums1) and j < len(nums2):

//             if nums1[i] <= nums2[j]:
//                 max_dist = max(max_dist, j - i)
//                 j += 1   # expand distance
//             else:
//                 i += 1   # fix condition

//         return max_dist