// Last updated: 11/08/2026, 20:56:47
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < nums.length){
            // add all the elements
            sum += nums[right];
            // if sum >= target find the window length
            while(sum >= target){
                //keep track of minimum length of window
                //move left pointer until window is valid
                minLen = Math.min(minLen, right-left+1);
                // remove the left pointer element from the window and increment left pointer
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if(minLen == Integer.MAX_VALUE){
            return 0;
        }
        return minLen;
    }
}