// Last updated: 11/09/2026, 09:29:50
import java.util.*;

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        Set<Integer> coords = new HashSet<>();
        for (int[] pos : positions) {
            coords.add(pos[0]);
            coords.add(pos[0] + pos[1]);
        }
        List<Integer> sorted = new ArrayList<>(coords);
        Collections.sort(sorted);
        Map<Integer, Integer> coordToIndex = new HashMap<>();
        for (int i = 0; i < sorted.size(); ++i) {
            coordToIndex.put(sorted.get(i), i);
        }

        int[] heights = new int[sorted.size()];
        List<Integer> ans = new ArrayList<>();
        int maxSoFar = 0;
        for (int[] pos : positions) {
            int start = coordToIndex.get(pos[0]);
            int end = coordToIndex.get(pos[0] + pos[1]);
            int base = 0;
            for (int i = start; i < end; ++i) {
                base = Math.max(base, heights[i]);
            }
            int newHeight = base + pos[1];
            for (int i = start; i < end; ++i) {
                heights[i] = newHeight;
            }
            maxSoFar = Math.max(maxSoFar, newHeight);
            ans.add(maxSoFar);
        }
        return ans;
    }
}