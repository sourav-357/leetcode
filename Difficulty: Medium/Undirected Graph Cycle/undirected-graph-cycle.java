class Solution {

    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                Queue<Pair> queue = new LinkedList<>();

                queue.offer(new Pair(i, -1));
                visited[i] = true;

                while (!queue.isEmpty()) {

                    Pair current = queue.poll();

                    int node = current.node;
                    int parent = current.parent;

                    for (int neighbor : adj.get(node)) {

                        if (!visited[neighbor]) {

                            visited[neighbor] = true;
                            queue.offer(new Pair(neighbor, node));

                        } else if (neighbor != parent) {

                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}