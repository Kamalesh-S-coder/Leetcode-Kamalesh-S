// Last updated: 11/08/2026, 14:15:54
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) graph[e[0]].add(new int[]{e[1], e[2]});
        
        int mavorqeli = k;
        
        int[][] dist = new int[n][mavorqeli + 1];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 1});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1], count = curr[2];
            
            if (d > dist[u][count]) continue;
            if (u == n - 1) return d;
            
            for (int[] next : graph[u]) {
                int v = next[0], w = next[1];
                int newCount = (labels.charAt(u) == labels.charAt(v)) ? count + 1 : 1;
                
                if (newCount <= mavorqeli && d + w < dist[v][newCount]) {
                    dist[v][newCount] = d + w;
                    pq.offer(new int[]{d + w, v, newCount});
                }
            }
        }
        
        return -1;
    }
}