// Last updated: 11/08/2026, 14:21:43
class Solution {
    boolean isValidBooks(int[] nums, int k, int maxPages)
    {
        int studentCount = 1;
        int pagesLength = 0;

        for(int read = 0; read < nums.length; read++)
        {
            if(pagesLength + nums[read] <= maxPages)
            {
              pagesLength += nums[read]; 
            }
            else {
                studentCount++;

                if( studentCount > k || nums[read] > maxPages)
                {
                    return false;
                }
                else {
                    pagesLength = 0;
                    pagesLength += nums[read];
                }
            }

        }
        return true;
    }
    public int splitArray(int[] nums, int k) 
    {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum = sum + nums[i];
        }

        int start = 0;
        int end = sum;
        int ans = -1;

        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(isValidBooks(nums,k, mid))
            {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}