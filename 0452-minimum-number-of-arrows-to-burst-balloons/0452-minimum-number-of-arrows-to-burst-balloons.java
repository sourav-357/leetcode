class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int end = points[0][1];
        int count = 1;

        for (int[] point : points) {
            if (point[0] > end) {
                count++;
                end = point[1];
            }
        }

        return count;
    }
}