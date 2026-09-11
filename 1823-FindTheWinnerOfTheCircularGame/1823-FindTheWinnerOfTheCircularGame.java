// Last updated: 11/09/2026, 09:26:28
// class Solution {
//     public int findTheWinner(int n, int k) {
//         Queue<Integer> q=new LinkedList<>();
//         for(int i=1;i<n;i++){
//             q.add(i);
//         }
//         while(q.size()!=1){
//             for(int i=0;i<k-1;i++){
//                 q.add(q.pop());
//             }
//             q.pop();
//         }
//         return q.peek();
//     }
// }
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }
            q.poll();
        }

        return q.peek();
    }
}