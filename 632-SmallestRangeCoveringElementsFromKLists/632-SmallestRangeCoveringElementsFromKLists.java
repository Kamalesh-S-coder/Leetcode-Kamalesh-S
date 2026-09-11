// Last updated: 11/09/2026, 09:30:24
class Solution {
    class Node {
        int value;
        int list;
        int index;

        Node(int value, int list, int index) {
            this.value = value;
            this.list = list;
            this.index = index;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> a.value - b.value);

        int max = Integer.MIN_VALUE;

        // for getting max
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            pq.add(new Node(value, i, 0));
            max = Math.max(max, value);
        }

        int bestStart = 0;
        int bestEnd = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Node minNode = pq.poll();
            int min = minNode.value;
            int list = minNode.list;
            int index = minNode.index;

            // CUpdate Range
            if (max - min < bestEnd - bestStart ||
                (max - min == bestEnd - bestStart && min < bestStart)) {

                bestStart = min;
                bestEnd = max;
            }

            // Being in the Size of the list
            if (index + 1 < nums.get(list).size()) {

                int nextValue = nums.get(list).get(index + 1);

                pq.add(new Node(nextValue, list, index + 1));

                max = Math.max(max, nextValue);

            } else {
                break;
            }
        }

        return new int[]{bestStart, bestEnd};
    }
}