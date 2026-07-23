class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u); // because graph is bi-directional
        }

        boolean[] visited = new boolean[n];

        return dfs(source, destination, adj, visited);
    }

    private boolean dfs(int node, int destination,
                        ArrayList<ArrayList<Integer>> adj,
                        boolean[] visited) {

        if (node == destination) {
            return true;
        }

        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, destination, adj, visited)) {
                    return true;
                }

            }
        }

        return false;
    }
}