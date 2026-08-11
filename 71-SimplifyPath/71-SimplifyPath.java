// Last updated: 11/08/2026, 21:00:22
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        
        for(String ele : arr){
            if(ele.equals("") || ele.equals(".")){
                continue;
            }
            else if(ele.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(ele);
            }
        }
        
        // FIX: If the stack is empty, the path is the root directory "/"
        if (st.isEmpty()) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String ele : st){
            sb.append("/");
            sb.append(ele);
        }
        return sb.toString();
    }
}