// Last updated: 11/09/2026, 09:25:33
class Solution {
    public String triangleType(int[] nums) {
    Arrays.sort(nums);
    if(nums[0] + nums[1] <= nums[2]) return "none";
    if(nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
    if(nums[0] == nums[1] || nums[1] == nums[2]) return "isosceles";
    return "scalene";
}

}