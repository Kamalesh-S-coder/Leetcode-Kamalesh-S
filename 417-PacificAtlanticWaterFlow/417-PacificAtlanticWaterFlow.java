// Last updated: 11/08/2026, 14:21:26
class Solution {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void bfs(int[][] heights, Queue<int[]> q, boolean[][] isVis){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x1 = curr[0];
            int y1 = curr[1];
            isVis[x1][y1] = true;

            for(int[] d : dir){
                int x2 = x1 + d[0];
                int y2 = y1 + d[1];
                if(x2>=0 && x2<heights.length && y2>=0 && y2<heights[0].length){
                    if(!isVis[x2][y2] && heights[x2][y2]>=heights[x1][y1]){
                        q.offer(new int[]{x2, y2});
                    }
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        // For pacific ocean
        boolean[][] isVis1 = new boolean[m][n];
        Queue<int[]> q1 = new LinkedList<>();

        // For atlantic ocean
        boolean[][] isVis2 = new boolean[m][n];
        Queue<int[]> q2 = new LinkedList<>();

        for(int i=0; i<m; i++){
            q1.offer(new int[]{i, 0});
            q2.offer(new int[]{i, n-1});
        }
        for(int j=0; j<n; j++){
            q1.offer(new int[]{0, j});
            q2.offer(new int[]{m-1, j});
        }


        bfs(heights, q1, isVis1); // bfs for pacific ocean
        bfs(heights, q2, isVis2); // bfs for atlantic ocean

        // now check for overlapping
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isVis1[i][j] && isVis2[i][j]){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    res.add(ans);
                }
            }
        }

        return res;
    }
}