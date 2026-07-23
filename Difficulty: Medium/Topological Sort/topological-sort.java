class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[V];
        
        for (int[] num : edges) {
            int u = num[0];
            int v = num[1];
            
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }    
        }
        
        return topo;
    }
}









