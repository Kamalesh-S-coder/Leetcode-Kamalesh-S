// Last updated: 11/08/2026, 14:17:13
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer>  st = new Stack<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i= sandwiches.length-1;i>=0;i--){
            st.push(sandwiches[i]);
        }
        for(int stud:students){
            q.add(stud);
        }
        int t=0;
        while(!q.isEmpty() && !st.isEmpty() && t<st.size()){
            if(q.peek() ==st.peek()){
                st.pop();
                q.poll();
                t=0;
            }
            else{
                t++;
                q.add(q.poll());
            }
        }
        return q.size();
    }
}