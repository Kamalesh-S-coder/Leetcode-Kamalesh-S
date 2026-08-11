// Last updated: 11/08/2026, 20:54:29
class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        int i = 0;
        long miss = 1;
        while(miss <= n) {
            if(i < nums.length && nums[i] <= miss)
                miss += nums[i++];
            else {
                miss += miss;
                patches++;
            }
        }
        return patches;
    }
}