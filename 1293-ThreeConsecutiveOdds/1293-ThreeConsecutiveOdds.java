// Last updated: 11/08/2026, 14:17:56
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
    int odds = 0;
    for (int i = 0; i < arr.length && odds < 3; i++) {
        odds = (arr[i] % 2 == 1) ? odds + 1 : 0;
    }
    return odds == 3;
    }   
}