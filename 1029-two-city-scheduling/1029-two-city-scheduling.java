class Solution {

    class Person implements Comparable<Person> {
        int costA;
        int costB;
        int diff;

        Person(int a, int b) {
            costA = a;
            costB = b;
            diff = a - b;
        }

        @Override
        public int compareTo(Person other) {
            return this.diff - other.diff;
        }
    }

    public int twoCitySchedCost(int[][] costs) {

        PriorityQueue<Person> pq = new PriorityQueue<>();

        for (int i = 0; i < costs.length; i++) {
            Person people = new Person(costs[i][0], costs[i][1]);
            pq.offer(people);
        }

        int total = 0;

        for (int i = 0; i < costs.length / 2; i++) {
            total += pq.poll().costA;
        }

        for (int i = costs.length / 2; i < costs.length; i++) {
            total += pq.poll().costB;
        }

        return total;
    }
}