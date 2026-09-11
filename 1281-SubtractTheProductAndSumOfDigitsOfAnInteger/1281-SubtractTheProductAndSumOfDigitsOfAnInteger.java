// Last updated: 11/09/2026, 09:26:55
class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0 , product=1;
        while(n>0){
            int digit=n%10;
            product*=digit;
            sum+=digit;
            n/=10;
        }
        return product-sum;
    }
}