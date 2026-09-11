// Last updated: 11/09/2026, 09:33:12
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res=new HashSet<List<Integer>>();
        List<Integer> sequence=new ArrayList<>();
        helperBacktrack(nums,0,sequence,res);
        return new ArrayList<>(res);
    }
    private void helperBacktrack(int[] nums,int index,List<Integer> sequence,Set<List<Integer>> res){
            if(sequence.size()>=2){ // if the length of the current subsequence is at-least 2 then add it to res
                res.add(new ArrayList<>(sequence));
            }

        for (int i = index; i < nums.length; i++) {//start from index
            //if the sequence remains increasing after appending nums[i]
            if (sequence.isEmpty() || sequence.get(sequence.size() - 1) <= nums[i]) {
                //append nums[i] to the sequence
                sequence.add(nums[i]);
                //call recursively for i+1
                helperBacktrack(nums, i + 1, sequence, res);
                //delete nums[i] from the end of the sequence
                sequence.remove(sequence.size() - 1);
            }
        }
    }
}