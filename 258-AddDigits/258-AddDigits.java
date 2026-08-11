// Last updated: 11/08/2026, 20:55:52
class Solution {
    public int addDigits(int num){
        if(num==0) return 0;
        else if(num%9==0) return 9;
        else return num%9;
        
    }
} 