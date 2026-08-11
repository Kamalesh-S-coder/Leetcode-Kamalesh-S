// Last updated: 11/08/2026, 20:54:11
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] ans = new int[k];
        int j=0;

        //Calculating freq of each element
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        //adding pair - {freq, element} into the heap
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minheap.add(new int[]{entry.getValue(), entry.getKey()});

            if(minheap.size() > k){
                minheap.poll();
            }
        }
        //adding remaing elements from heap which have highest freq to ans array
        while(!minheap.isEmpty()){
            int pair[] = minheap.poll();
            ans[j] = pair[1];
            j++;
        }
        return ans;
        
    }
}