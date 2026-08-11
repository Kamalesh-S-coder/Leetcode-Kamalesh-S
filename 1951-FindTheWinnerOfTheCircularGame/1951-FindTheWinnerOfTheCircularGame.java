// Last updated: 11/08/2026, 14:17:05
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