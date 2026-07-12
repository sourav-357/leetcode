class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {

            List<Integer> remaining = new ArrayList<>();

            int cycle = n + 1;
            int workDone = 0;

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int current = maxHeap.poll();

                if (current > 1) {
                    remaining.add(current - 1);
                }

                workDone++;
                cycle--;
            }

            for (int f : remaining) {
                maxHeap.offer(f);
            }

            if (maxHeap.isEmpty()) {
                time += workDone;
            } else {
                time += n + 1;
            }
        }

        return time;
    }
}