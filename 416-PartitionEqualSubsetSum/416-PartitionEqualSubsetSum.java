// Last updated: 11/08/2026, 14:21:31
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        int n=nums.length;
        Boolean[][] dp=new Boolean[n][target+1];
        return func(nums,0,0,target,dp);
    }
    public static boolean func(int[] nums,int curr,int index,int target,Boolean[][] dp){
        if(curr==target){
            return true;
        }
        if(curr > target) return false;
        if(index>=nums.length){
            return false;
        }
         if(dp[index][curr]!=null){
            return dp[index][curr];
        }
        return dp[index][curr]= func(nums,curr+nums[index],index+1,target,dp) || func(nums,curr,index+1,target,dp);
    }
}