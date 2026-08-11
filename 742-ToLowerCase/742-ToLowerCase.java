// Last updated: 11/08/2026, 14:19:26
class Solution {
    public String toLowerCase(String s) {
       StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>=65 && s.charAt(i)<=90)
            {
                str.append((char)(s.charAt(i)+32));
            }
            else
            {
                str.append(s.charAt(i));
            }
        }
        return str.toString();  
    }
}