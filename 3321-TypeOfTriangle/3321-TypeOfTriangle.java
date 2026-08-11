// Last updated: 11/08/2026, 14:16:12
class Solution {
    public String triangleType(int[] nums) {
    Arrays.sort(nums);
    if(nums[0] + nums[1] <= nums[2]) return "none";
    if(nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
    if(nums[0] == nums[1] || nums[1] == nums[2]) return "isosceles";
    return "scalene";
}

}