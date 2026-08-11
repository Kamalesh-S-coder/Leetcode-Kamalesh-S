// Last updated: 11/08/2026, 14:15:58
class Solution {
    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        int[] maxMatch = new int[n];
        
        for (String word : words) {
            String s = word + "#" + target;
            int[] z = computeZ(s);
            int m = word.length();
            
            for (int i = 0; i < n; i++) {
                maxMatch[i] = Math.max(maxMatch[i], z[m + 1 + i]);
            }
        }
        
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        
        for (int i = 0; i < n; i++) {
            if (i > farthest) return -1;
            
            farthest = Math.max(farthest, i + maxMatch[i]);
            
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                if (currentEnd >= n) return jumps;
            }
        }
        
        return -1;
    }
    
    private int[] computeZ(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
