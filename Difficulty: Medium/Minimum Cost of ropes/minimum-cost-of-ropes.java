class Solution {
    public static int minCost(int[] arr) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : arr) {
            minHeap.offer(rope);
        }

        int cost = 0;

        while (minHeap.size() > 1) {
            
            int first = minHeap.poll();
            int second = minHeap.poll();

            int sum = first + second;
            cost += sum;

            minHeap.offer(sum);
        }

        return cost;
    }
}