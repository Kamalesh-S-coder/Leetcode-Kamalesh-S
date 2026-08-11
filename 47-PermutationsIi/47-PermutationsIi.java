// Last updated: 11/08/2026, 21:01:15
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        Set<List<Integer>> set=new HashSet<>();
        backTrack(nums,0,set);
        return new ArrayList<>(set);
    }

    private void backTrack(int nums[],int idx,Set<List<Integer>> set)
    {
        if(idx==nums.length)
        {
            List<Integer> list=new ArrayList<>();
            for(int i:nums)
            {
                list.add(i);
            }

            set.add(list);
        }

        for(int i=idx;i<nums.length;i++)
        {
            swap(nums,idx,i);
            backTrack(nums,idx+1,set);
            swap(nums,idx,i);
        }
    }

    private void swap(int nums[],int a,int b)
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
