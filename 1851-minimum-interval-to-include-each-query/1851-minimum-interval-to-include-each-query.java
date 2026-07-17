class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int m = intervals.length;
        int n = queries.length;

        int[][] store = new int[n][2];
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        for(int i=0;i<n;i++){
            store[i][0] = queries[i];
            store[i][1] = i;
        }

        Arrays.sort(store,(a,b) -> a[0] - b[0]);

        int[] ans = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int i =0;
        for(int[] q : store) {
            int val = q[0];
            int idx = q[1];

            while(i < m && intervals[i][0] <= val) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                int len = intervals[i][1] - intervals[i][0] + 1;

                pq.offer(new int[]{len,right});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < val) {
                pq.poll();
            }

            if(pq.isEmpty()) {
                ans[idx] = -1;
            }

            else{
                ans[idx] = pq.peek()[0];
            }
        }
        return ans;
    }
}