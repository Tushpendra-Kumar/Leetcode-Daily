var closestTarget = function(words, target, startIndex) {
    let n = words.length;
    let ans = Infinity;

    for (let i = 0; i < n; i++) {
        if (words[i] === target) {
            let dist = Math.abs(i - startIndex);
            let circularDist = n - dist;
            ans = Math.min(ans, dist, circularDist);
        }
    }

    return ans === Infinity ? -1 : ans;
};