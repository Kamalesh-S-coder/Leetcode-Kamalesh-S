// Last updated: 11/08/2026, 14:16:39
class Solution {
    public int sumOfMultiples(int n) {
        return divisum(n, 3) + divisum(n, 5) + divisum(n, 7) + divisum(n, 105) - divisum(n, 15) - divisum(n, 21) - divisum(n, 35);
    }
    private int divisum(int n , int k){
        int m = n / k;
        return k * m * (m + 1) / 2;
    }
}
