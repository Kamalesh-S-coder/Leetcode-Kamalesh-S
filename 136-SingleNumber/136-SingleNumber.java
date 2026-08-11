// Last updated: 11/08/2026, 20:58:44
class Solution {
    public int singleNumber(int[] nums) {
    int result = 0;
    for(int i : nums) {
        result ^= i;
    }
    return result;
}
}