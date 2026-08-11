// Last updated: 11/08/2026, 20:55:54
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqA = new int[26];
        int[] freqB = new int[26];
        for(char c: s.toCharArray())
            freqA[c-97]++;
        for(char c:t.toCharArray())
            freqB[c-97]++;
        return Arrays.equals(freqA,freqB);    
    }
}