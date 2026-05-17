class Solution {

    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int index, boolean[] visited) {

        // Out of bounds
        if (index < 0 || index >= arr.length) {
            return false;
        }

        // Already visited
        if (visited[index]) {
            return false;
        }

        // Found zero
        if (arr[index] == 0) {
            return true;
        }

        // Mark visited
        visited[index] = true;

        // Jump forward
        boolean forward = dfs(arr, index + arr[index], visited);

        // Jump backward
        boolean backward = dfs(arr, index - arr[index], visited);

        return forward || backward;
    }
}