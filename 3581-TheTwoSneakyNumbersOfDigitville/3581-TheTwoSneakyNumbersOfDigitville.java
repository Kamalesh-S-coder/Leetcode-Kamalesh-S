// Last updated: 11/08/2026, 14:15:55
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int[] result = new int[2];
        int count = 0;
        
        for (int num : nums) {
            if (seen.contains(num)) {
                result[count++] = num;
                if (count == 2) break;
            } else {
                seen.add(num);
            }
        }
        
        return result;
    }
}