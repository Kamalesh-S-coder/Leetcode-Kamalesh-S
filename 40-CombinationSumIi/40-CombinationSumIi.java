// Last updated: 11/08/2026, 21:01:33
class Solution {
        /*
        #########################################################################
        #                                                                       #
        #  =============================================                        #
        #                  SIDDARDHA CHILUVERU                                  #
        #  =============================================                        #
        #                                                                       #
        #  Author      : Siddardha Chiluveru                                    #
        #  Description : Solution / Code / Project                              #
        #  Date        : 2026-05-27                                             #
        #                                                                       #
        #########################################################################
        */
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int t) {
        Arrays.sort(nums);
        comb(0,new ArrayList<>(),nums, t);
        return ans;
    }
    public void comb(int i, ArrayList<Integer> k, int[] nums, int t) {
        if (t == 0) {
            ans.add(new ArrayList<>(k));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1])
                continue;
            if (nums[j] > t)
                break;
            k.add(nums[j]);
            comb(j + 1, k, nums, t - nums[j]);
            k.remove(k.size() - 1);
        }
    }
}