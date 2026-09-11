// Last updated: 11/09/2026, 09:32:22
class Solution {
    int count=0;
    public int countArrangement(int n) {
        int num[] = new int[n+1];
        helper(num,1,n);
        return count;
    }

    public void helper(int num[], int val, int n){
        if(val>n){
            count++;
            return;
        }

        for(int i=1;i<=n;i++){
            if(num[i]==0 && (i%val==0 || val%i==0)){
                num[i]=1;
                helper(num,val+1,n);
                num[i]=0;
            }
        }
    }
}