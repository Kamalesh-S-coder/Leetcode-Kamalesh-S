// Last updated: 11/09/2026, 09:28:58
class Solution {

    int len,n;
    Map <Integer, Integer>  map; 
    Random r;
    public Solution(int n, int[] blacklist) {
        // map blacklist into the cells  {n - blacklist.length : n}, call random(0:n - blacklist.length) and if we land on blacklist return the mapping instead
        len = blacklist.length;
        this.n = n; 
        map = new HashMap();
        for (int i = 0; i < len ; i++) map.put(blacklist[i] , n - len + i);
        for (int i = 0; i < len ; i++) map.put(blacklist[i] , find(map.get(blacklist[i]))); // remove chains optimization
        r = new Random();
    }

    private int find(int x){ 
        if (!map.containsKey(x) || map.get(x) <= x) return x;
        return find(map.get(x));
    }
    
    public int pick() {
        int rand = r.nextInt(n - len);
        while (map.containsKey(rand)) rand = map.get(rand);
        return rand;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */