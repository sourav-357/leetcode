

class Item implements Comparable<Item> {
    int value;
    int weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
    
    @Override
    public int compareTo(Item that) {
        // maxheap
        return Double.compare(that.ratio, this.ratio);
    }
}

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        
        PriorityQueue<Item> pq = new PriorityQueue<>();
        double price = 0;
        
        for (int i = 0; i < val.length; i++) {
            Item item = new Item(val[i], wt[i]);
            pq.offer(item);
        }
        
        while (!pq.isEmpty() && capacity >= pq.peek().weight) {
            Item item = pq.poll();
            price += item.value;
            capacity -= item.weight;
        }
        
        if (pq.isEmpty())
            return price;
            
        Item item = pq.poll();
        price += item.ratio * capacity;
        
        return price;
    }
}