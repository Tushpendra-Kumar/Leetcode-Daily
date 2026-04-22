// class Solution {
//     public List<String> twoEditWords(String[] queries, String[] dictionary) {

//         List<String> result = new ArrayList<>();

//         for (String q : queries) {

//             for (String d : dictionary) {

//                 int diff = 0;

//                 for (int i = 0; i < q.length(); i++) {
//                     if (q.charAt(i) != d.charAt(i)) {
//                         diff++;
//                     }
//                 }

//                 if (diff <= 2) {
//                     result.add(q);
//                     break; // no need to check other dictionary words
//                 }
//             }
//         }

//         return result;
//     }
// }


// 2. javascript :

// var twoEditWords = function(queries, dictionary) {

//     let result = [];

//     // helper function: count differences
//     function isValid(q, d) {
//         let diff = 0;

//         for (let i = 0; i < q.length; i++) {
//             if (q[i] !== d[i]) {
//                 diff++;
//                 if (diff > 2) return false; // early break
//             }
//         }

//         return true;
//     }

//     // check each query
//     for (let q of queries) {

//         for (let d of dictionary) {
//             if (isValid(q, d)) {
//                 result.push(q); // match mil gaya
//                 break;          // next query pe jao
//             }
//         }
//     }

//     return result;
// };

// 3. python :

// class Solution:
//     def twoEditWords(self, queries, dictionary):
        
//         def is_valid(q, d):
//             diff = 0
//             for i in range(len(q)):
//                 if q[i] != d[i]:
//                     diff += 1
//                     if diff > 2:
//                         return False
//             return True

//         res = []

//         for q in queries:
//             for d in dictionary:
//                 if is_valid(q, d):
//                     res.append(q)
//                     break

//         return res