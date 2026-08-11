// Last updated: 11/08/2026, 14:19:20
class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        
        for(int ele:nums){
            if(pq.size()<k){
                pq.add(ele);
            }
            else if(ele>pq.peek()){
                pq.poll();
                pq.add(ele);
            }
        }    
    }
    
    public int add(int val) {
        if(pq.size() <k){
            pq.add(val);
        }
        else if(val>pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */