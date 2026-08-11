// Last updated: 11/08/2026, 14:16:08
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