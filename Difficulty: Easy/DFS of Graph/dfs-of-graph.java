class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];

        dfsHelper(0, adj, visited, ans);
        return ans;
    }
    
    public void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj,
                          boolean[] visited, ArrayList<Integer> ans) {
        
        visited[node] = true;
        ans.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, ans);
            }
        }
    }
}