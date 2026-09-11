// Last updated: 11/09/2026, 09:25:35
class Solution {
    public int countKeyChanges(String s) {
        s=s.toLowerCase();
        int change=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                change++;
            }
        }
        return change;
    }
}