// Last updated: 11/09/2026, 09:26:00
class Solution {
    public int sumOfMultiples(int n) {
        return divisum(n, 3) + divisum(n, 5) + divisum(n, 7) + divisum(n, 105) - divisum(n, 15) - divisum(n, 21) - divisum(n, 35);
    }
    private int divisum(int n , int k){
        int m = n / k;
        return k * m * (m + 1) / 2;
    }
}
