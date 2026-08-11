// Last updated: 11/08/2026, 21:00:06
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        sub(nums, new ArrayList<>(), 0, res);
        return res;
    }
    private void sub(int[] nums, List<Integer> ans, int i, List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList<>(ans)); // Collected ONLY at leaf nodes
            return;
        }
        ans.add(nums[i]);       // 1. Pick
        sub(nums, ans, i + 1, res);
        ans.remove(ans.size() - 1); // Backtrack
        sub(nums, ans, i + 1, res); // 2. Non-Pick
    }
}
