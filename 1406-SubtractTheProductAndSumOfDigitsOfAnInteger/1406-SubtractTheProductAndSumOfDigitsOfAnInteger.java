// Last updated: 11/08/2026, 14:17:30
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