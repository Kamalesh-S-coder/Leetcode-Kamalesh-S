// Last updated: 11/09/2026, 09:31:50
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap();
        
        int count = 0;
        for (List<Integer> row : wall) {
            int currentEdge = 0;
            for (int i = 0; i < row.size() - 1; i++) { //row.size() -1 since we do not want to consider borders. 
                int currentBrickLength = row.get(i);
                currentEdge += currentBrickLength; 
                map.put(currentEdge, map.getOrDefault(currentEdge, 0) + 1);
                count = Math.max(count, map.get(currentEdge));
            }
        }
        
        return wall.size() - count;
    }
}
