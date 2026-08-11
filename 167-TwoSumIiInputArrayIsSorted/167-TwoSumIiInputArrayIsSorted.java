// Last updated: 11/08/2026, 20:58:08
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0, j = numbers.length - 1;
        while(i < j){
        if(numbers[i] + numbers[j] == target){
            ans[0] = i+1;
            ans[1] = j+1;
            return ans;
        }else if(numbers[i] + numbers[j] > target){
            j--;
        }else{
            i++;
        }
        }
        return new int[]{-1,-1};
    }
}