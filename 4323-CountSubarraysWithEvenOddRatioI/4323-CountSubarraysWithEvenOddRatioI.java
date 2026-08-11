// Last updated: 11/08/2026, 14:15:41
class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int[] norvelith = nums;
        int n= nums.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            int even=0,odd=0;
            for(int j=i;j<n;j++){
                if(nums[j]%2==0)
                    even++;
                else
                    odd++;
                if(odd>0&&1L*even*b<=1L*odd*a)
                    ans++;
            }
        }
        return ans;
    }
}