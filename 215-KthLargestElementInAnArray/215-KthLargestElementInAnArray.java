// Last updated: 11/08/2026, 20:56:38
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele:nums){

        
            if(pq.size() <k){
                pq.add(ele);
            }
            else if(ele>pq.peek()){
                pq.poll();
                pq.add(ele);
            }
        }
       return pq.peek();
    }
}