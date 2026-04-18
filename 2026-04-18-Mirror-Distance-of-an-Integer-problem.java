class Solution {
    public int mirrorDistance(int n) {
        int reversed = reverse(n);
        return Math.abs(n - reversed);
    }

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
}

// 2. javascript : 

// var mirrorDistance = function(n) {

//     // Step 1: number reverse karna
//     let original = n;
//     let rev = 0;

//     while (n > 0) {
//         let digit = n % 10;              // last digit nikala
//         rev = rev * 10 + digit;          // reverse me add kiya
//         n = Math.floor(n / 10);          // number chhota kiya
//     }

//     // Step 2: absolute difference return karo
//     return Math.abs(original - rev);
// };

// 3. python :

// class Solution:
//     def mirrorDistance(self, n: int) -> int:
        
//         original = n
//         rev = 0

//         # reverse number
//         while n > 0:
//             digit = n % 10
//             rev = rev * 10 + digit
//             n //= 10

//         # return absolute difference
//         return abs(original - rev)