/**
 * @param {number[]} robot
 * @param {number[][]} factory
 * @return {number}
 */
var minimumTotalDistance = function(robot, factory) {
    robot.sort((a,b) => a-b);
    factory.sort((a,b) => a[0] -b[0]);

    // expand factories :
    let slots = [];
    for (let [pos, limit] of factory){
        for (let i = 0; i < limit; i++){
            slots.push(pos);
        }
    }

    let n = robot. length;
    let m = slots.length;

    let dp = Array.from({length:n+1}, () =>
    Array(m+1).fill(Infinity)
    );

    //base case
    for (let j = 0; j<=m; j++) dp[0][j] =0;

    for (let i = 1; i<=n; i++) {
        for (let j=1; j<=m; j++){

            // skip
            dp[i][j]= dp [i][j-1];

            //take
            let cost = Math.abs(robot[i-1]-slots[j-1]);
            dp[i][j] = Math.min(
                dp[i][j],
                dp[i-1][j-1]+ cost
            );
        }
    }
    return dp[n][m];
};

// thanku so much..!!