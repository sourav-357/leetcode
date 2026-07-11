

class Number implements Comparable<Number> {
    int x;
    int y;
    int distance;

    Number (int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = x * x + y * y;
    }

    @Override
    public int compareTo(Number that) {
        // min heap
        return this.distance - that.distance;
    }
}


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Number> pq = new PriorityQueue<>();

        for (int[] point : points) {
            Number number = new Number(point[0], point[1]);
            pq.offer(number);
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Number number = pq.poll();
            ans[i][0] = number.x;
            ans[i][1] = number.y;
        }

        return ans;
    }
}