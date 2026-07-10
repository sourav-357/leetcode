

class Number implements Comparable<Number> {
    int element;
    int freq;

    Number(int element, int freq) {
        this.element = element;
        this.freq = freq;
    }

    @Override
    public int compareTo(Number that) {
        // max heap
        return that.freq - this.freq;
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<Number> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Number number = new Number(entry.getKey(), entry.getValue());
            pq.offer(number);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Number number = pq.poll();
            ans[i] = number.element;
        }

        return ans;
    }
}