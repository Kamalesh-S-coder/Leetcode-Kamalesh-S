// Last updated: 11/08/2026, 14:21:45
class Solution {
    public int trapRainWater(int[][] heightMap) {
        /*
        ---------------------------------------
        EX: 1 (BFS Approach)
        ---------------------------------------
        1,4,3,1,3,2
        3,2,1,3,2,4
        2,3,3,2,3,1

        Find if cell has all 4 neighbors
        
        -> A = 2
        1,4,3,1,3,2
        3,A,1,3,2,4
        2,3,3,2,3,1

        Checking 4 Neighbors nA = {2}{4,3,3,1}
        There is a neighbor (in all directions) less than 2 ie 1, so we need to find just next height
        
        -> B = 1
        1,4,3,1,3,2
        3,2,B,3,2,4
        2,3,3,2,3,1

        Checking 4 Neighbors nB = {1}{2,3,3,3}

        There is no neighbor (in all directions) less than 1

        Combining A&B neighbors{1,2}{4,3,3,3,3,3}

        Next highest = 3

        Sum = (3-2) + (3-1) = 3

        -> C = 3
        1,4,3,1,3,2
        3,2,1,C,2,4
        2,3,3,2,3,1

        Checking 4 Neighbors nC = {3}{1,1,2,2}
        There is no neighbor less than 3
        No neighbor is > 3
        So we skip

        -> D = 2
        1,4,3,1,3,2
        3,2,1,3,D,4
        2,3,3,2,3,1

        Checking 4 Neighbors nD = {2}{3,3,3,4}
        There is no neighbor less than 2
        nextHeight = 3


        --> So Sum = Sum + (3-2) = 3 + 1 = 4
        */

        int m = heightMap.length, n = heightMap[0].length;
        
        int[][] vols = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vols[i][j] = heightMap[i][j];
            }
        }

        boolean upt = true;
        boolean init = true;
        while (upt) {
            upt = false;
            
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int val = Math.max(heightMap[i][j], 
                                       Math.min(vols[i - 1][j], vols[i][j - 1]));
                    if (init || vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
            init = false;

            for (int i = m - 2; i >= 1; i--) {
                for (int j = n - 2; j >= 1; j--) {
                    int val = Math.max(heightMap[i][j], 
                                       Math.min(vols[i + 1][j], vols[i][j + 1]));
                    if (vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (vols[i][j] > heightMap[i][j])
                    res += vols[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}