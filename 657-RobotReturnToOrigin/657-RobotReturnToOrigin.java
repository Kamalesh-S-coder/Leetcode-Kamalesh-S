// Last updated: 11/08/2026, 14:19:33
class Solution {
    public boolean judgeCircle(String moves) {
        int u=0,d=0,l=0,r=0;
        for(char c:moves.toCharArray()){
            if(c=='U')u++;
            else if(c=='D')d++;
            else if(c=='L')l++;
            else r++;
        }
        // int val=Math.abs(u-d)-Math.abs(l-r);
        return (l-r)==0&&(u-d)==0;
    }
}
