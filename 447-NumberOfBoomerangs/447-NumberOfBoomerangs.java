// Last updated: 11/08/2026, 14:21:07
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap();
        int boomerangs = 0;
        for (int[] p1 : points) {
            for (int[] p2 : points)
                boomerangs += map.merge((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]), 1, Integer::sum) - 1;
            map.clear();
        }
        return boomerangs * 2;
    }
}