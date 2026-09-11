// Last updated: 11/09/2026, 09:26:09
class Solution {
    public boolean check(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String s:words){
            if(check(s))
            return s;
        }
         return  "";
    } 
    
}