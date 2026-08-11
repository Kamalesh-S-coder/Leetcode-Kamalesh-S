// Last updated: 11/08/2026, 14:18:55
class Solution {
    public int maxTurbulenceSize(int[] A) {
    int best = 0, clen = 0;

    for(int i = 0; i < A.length; i++) {
        if(i >= 2 && ((A[i-2] > A[i-1] && A[i-1] < A[i]) ||
                      (A[i-2] < A[i-1] && A[i-1] > A[i])) ) {
            // If the last three elements are turbulent, increment run length by 1.
            clen++;
        } else if(i >= 1 && A[i-1] != A[i]) {
            // The last three elements are not turbulent, so we'll reset the run length.
            // If the previous and current elements are not equal, the new run length is 2.
            clen = 2;
        } else {
            // Otherwise, the new run length is 1.
            clen = 1;
        }
        best = Math.max(best, clen);
    }
    return best;    
}
}