class Solution {
    public int furthestDistanceFromOrigin(String moves) {

        int left = 0;
        int right = 0;
        int blank = 0;

        // Step 1: Count L, R, _
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') left++;
            else if (ch == 'R') right++;
            else blank++;
        }

        // Step 2: Maximize distance
        return Math.abs(left - right) + blank;
    }
}

// 2. javascript :

// var furthestDistanceFromOrigin = function(moves) {

//     let L = 0, R = 0, blank = 0;

//     // count characters
//     for (let ch of moves) {
//         if (ch === 'L') L++;
//         else if (ch === 'R') R++;
//         else blank++; // '_'
//     }

//     // max distance
//     return Math.abs(L - R) + blank;
// };

// 3. python :

// class Solution:
//     def furthestDistanceFromOrigin(self, moves: str) -> int:
        
//         L = moves.count('L')
//         R = moves.count('R')
//         blank = moves.count('_')

//         return abs(L - R) + blank