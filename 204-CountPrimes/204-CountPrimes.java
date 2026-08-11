// Last updated: 11/08/2026, 20:56:58
class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        
        
        int[] notPrime = new int[n + 1];
        int count = n - 2;
        int prime = 2;
        
        
        while (prime * prime < n) {
            if (notPrime[prime] == 0)
                for (int num = prime + prime; num < n; num += prime)
                    if (notPrime[num] == 0) {
                        count--;
                        notPrime[num] = 1;
                    }
            
            
            prime++;
        }
        
        
        return count;
    }
}