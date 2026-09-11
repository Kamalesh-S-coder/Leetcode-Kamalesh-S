// Last updated: 11/09/2026, 09:28:52
class Solution {
	// public Solution(int[] w): O(N * Log(N)) time (put operation into TreeMap) where N is length of w, O(N) space (one entry for each number)
	// public int pickIndex(): O(Log(N)) time for floor lookup
    
    private Random r = new Random();
    TreeMap<Integer, Integer> map;
    int totalWeight = 0;

    public Solution(int[] w) {
        map = new TreeMap<>();
        
        // Sum up the weights (incremental sum)
        // We insert the numbers with the current weight sum into the TreeMap, so we get a "weighted distribution" among the keys
        
        // e.g. to visualize "distribution":
        // Weights      [1,     4,      2,    3] end up in the TreeMap as
        // TreeMap:    | - | - - - - | - - | - - -    [0, sumWeight - 1] (we leave the right side "open")
		// Keys:       0   1         5     7
		// Values:       0      1       2      3
		// Incr. Sum:    0     1-4     5-6    7-9
		
        // The greater/"longer" one range is the higher the probability for that range to be chosen randomly
        
        int sumWeight = 0;
        for(int i = 0; i < w.length; i++) {
            map.put(sumWeight, i);
            sumWeight += w[i];
        }
        
        // We save the total weight which is the range of the TreeMap keys (see above)
        totalWeight = sumWeight;
    }
    
    public int pickIndex() {
        // We pick an index within the range of the key values which equals to [0, totalWeight - 1]
        // and floor it to the next key
		
		// e.g.
		// TreeMap:    | - | - - - - | - - | - - - 
		//                       ^ Random pick
		// TreeMap:    | - | - - - - | - - | - - - 
		//                 ^ We floor to this key and get the value
        return map.floorEntry(r.nextInt(totalWeight)).getValue();
    }
    
}