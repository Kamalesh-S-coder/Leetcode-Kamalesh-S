// Last updated: 11/08/2026, 20:56:28
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s= new HashSet<>();
        for(int ele:nums){
            if(s.add(ele))
                continue;
            else
                return true;
        } 
        return false;
    }
}