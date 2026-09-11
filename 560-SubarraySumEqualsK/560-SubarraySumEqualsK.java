// Last updated: 11/09/2026, 09:31:46
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        
        int curr = 0;
        int ans = 0;
        
        for (int num : nums) {
            curr += num;
            int rem = curr - k;
            ans += mp.getOrDefault(rem, 0);
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);
        }
        return ans;
    }
    
}