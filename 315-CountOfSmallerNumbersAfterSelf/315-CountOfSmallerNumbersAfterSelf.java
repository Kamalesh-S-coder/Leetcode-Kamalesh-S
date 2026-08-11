// Last updated: 11/08/2026, 20:54:57
class Solution {
    private class FenwickTree{
        int N, cnt[];
        FenwickTree(int n){
            N = n + 1;
            cnt = new int[N];
        }

        void add(int i){
            for(i++; i<N; i+=(i& -i))
                cnt[i]++;
        }

        int find(int i){
            int ans = 0;
            for(i++; i>0; i-=(i& -i))
                ans += cnt[i];
            return ans;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>(
            Collections.nCopies(nums.length, 0)
        );
        
        int shift = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i: nums){
            shift = i < shift ? i : shift;
            max = i > max ? i : max;
        }
        
        FenwickTree fT = new FenwickTree(max - shift + 1);
        for(int i=nums.length-1; i>=0; i--){
            ans.set(i, fT.find(nums[i] - shift));
            fT.add(nums[i] - shift + 1);
        }

        return ans;
    }
}