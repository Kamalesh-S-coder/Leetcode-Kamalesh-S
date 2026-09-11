// Last updated: 11/09/2026, 09:25:52
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count=0;
        for(int i:hours)
        {
            if(i>=target)
            {
                count++;
            }
        }
        return count;
    }
}