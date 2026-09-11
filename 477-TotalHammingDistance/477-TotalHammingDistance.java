// Last updated: 11/09/2026, 09:33:26
class Solution {
    public int totalHammingDistance(int[] nums) {
    
    int cntOne[]=new int[31];
    int n=nums.length;

//calculating total set bits at particular index 
    for(int i=0;i<n;i++){ 
        int idx=0;
        while(nums[i]>0){ 
            if((nums[i]&1)!=0){ 
                ++cntOne[idx];
            }
            idx++;
            nums[i]>>=1;
        }
    }


// at last the total number of set bits will be multiplies with the length of nums - total set bits at particular index , so that we can get number of set bits at that index
    int tot=0;

    for(int i=0;i<31;i++){ 
        tot+=((n-cntOne[i])*cntOne[i]);
    }

    return tot;

    }
}