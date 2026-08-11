// Last updated: 11/08/2026, 20:56:19
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff < 0)
            return false;
        long width = (long) valueDiff + 1;
        Map<Long, Long> bucket = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            long id = num < 0 ? (num + 1) / width - 1 : num / width;

            if (bucket.containsKey(id) || (bucket.containsKey(id - 1) && num - bucket.get(id - 1) <= valueDiff)
                    || (bucket.containsKey(id + 1) && bucket.get(id + 1) - num <= valueDiff))
                return true;

            bucket.put(id, num);

            if (i >= indexDiff) {
                long oldIdx = nums[i - indexDiff] < 0 ? (nums[i - indexDiff] + 1) / width - 1
                        : nums[i - indexDiff] / width;
                bucket.remove(oldIdx);
            }
        }

        return false;
    }
}