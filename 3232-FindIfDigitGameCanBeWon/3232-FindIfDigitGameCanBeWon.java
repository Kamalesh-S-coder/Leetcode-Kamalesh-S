// Last updated: 11/09/2026, 09:25:31
class Solution {
    public boolean canAliceWin(int[] nums) {
        long f=0,s=0;
        for(int i:nums){
            if(i<10){
                f+=i;
            }else{
                s+=i;
            }
        }
        return f!=s;
    }
}