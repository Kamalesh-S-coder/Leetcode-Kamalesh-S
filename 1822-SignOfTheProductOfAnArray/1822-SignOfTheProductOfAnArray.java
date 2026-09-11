// Last updated: 11/09/2026, 09:26:29
class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;
        for(int num:nums){
            if(num==0){
                return 0;
            }else if(num<0){
                sign = sign * -1;
            }else{
                sign = sign *1;
            }
        }
        return sign;
    }
}