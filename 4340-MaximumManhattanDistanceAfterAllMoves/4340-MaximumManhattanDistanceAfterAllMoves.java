// Last updated: 11/08/2026, 14:15:39
class Solution {
    public int maxDistance(String moves) {
        int u = 0, d = 0, l = 0, r = 0, wild = 0;
        
        for (char c : moves.toCharArray()) {
            if (c == 'U') u++;
            else if (c == 'D') d++;
            else if (c == 'L') l++;
            else if (c == 'R') r++;
            else wild++;
        }
        
        return Math.abs(u - d) + Math.abs(r - l) + wild;
    }
}
