class Interval {
    int start;
    int end;
    int length;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.length = end - start + 1;
    }
}

class Query implements Comparable<Query> {
    int value;
    int index;

    Query(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Query other) {
        return Integer.compare(this.value, other.value);
    }
}

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Interval[] arr = new Interval[intervals.length];
        Query[] q = new Query[queries.length];

        for (int i = 0; i < intervals.length; i++) {
            arr[i] = new Interval(intervals[i][0], intervals[i][1]);
        }

        for (int i = 0; i < queries.length; i++) {
            q[i] = new Query(queries[i], i);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.start, b.start));
        Arrays.sort(q);

        PriorityQueue<Interval> pq = new PriorityQueue<>(
            (a, b) -> {
                int cmp = Integer.compare(a.length, b.length);
                if (cmp != 0) return cmp;
                return Integer.compare(a.end, b.end);
            }
        );

        int[] ans = new int[queries.length];
        int i = 0;

        for (Query query : q) {

            // Add all intervals whose start <= query
            while (i < arr.length && arr[i].start <= query.value) {
                pq.offer(arr[i]);
                i++;
            }

            // Remove intervals that cannot contain the query
            while (!pq.isEmpty() && pq.peek().end < query.value) {
                pq.poll();
            }

            ans[query.index] = pq.isEmpty() ? -1 : pq.peek().length;
        }

        return ans;
    }
}