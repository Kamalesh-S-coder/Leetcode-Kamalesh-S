// Last updated: 11/08/2026, 20:56:02
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && dq.getLast() < nums[i]) dq.pollLast();
            dq.addLast(nums[i]);
            if (i >= k && nums[i - k] == dq.getFirst()) dq.pollFirst();
            if (i >= k - 1) result.add(dq.getFirst());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}