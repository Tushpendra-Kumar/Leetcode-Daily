// class Solution {

//     public int numberOfSpecialChars(String word) {

//         Set<Character> lower = new HashSet<>();

//         Set<Character> upper = new HashSet<>();

//         // Store lowercase and uppercase letters
//         for (char ch : word.toCharArray()) {

//             if (Character.isLowerCase(ch)) {
//                 lower.add(ch);
//             } else {
//                 upper.add(ch);
//             }
//         }

//         int count = 0;

//         // Check all letters from a to z
//         for (char ch = 'a'; ch <= 'z'; ch++) {

//             if (lower.contains(ch) &&
//                 upper.contains(Character.toUpperCase(ch))) {

//                 count++;
//             }
//         }

//         return count;
//     }
// }