// Last updated: 11/08/2026, 14:19:17
class Solution {

    public boolean backspaceCompare(String s, String t)
    {
        return build(s).equals(build(t));
    }

    public String build(String str)
    {
        StringBuilder sb = new StringBuilder();
        int skip = 0;

        for(int i = str.length() - 1; i >= 0; i--)
        {
            if(str.charAt(i) == '#')
            {
                skip++;
            }
            else if(skip > 0)
            {
                skip--;
            }
            else
            {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}