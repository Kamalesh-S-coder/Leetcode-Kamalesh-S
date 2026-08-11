// Last updated: 11/08/2026, 14:20:49
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, count = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else if (g[i] > s[j]) {
                j++;
            } else {
                i++;
            }
        }

        return count;
    }
}
