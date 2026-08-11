// Last updated: 11/08/2026, 14:15:56
import java.util.Arrays;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
}

class Solution {
    public int minValidStrings(String[] words, String target) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
        }
        
        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                char c = target.charAt(j);
                if (curr.children[c - 'a'] == null) break;
                
                curr = curr.children[c - 'a'];
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
            }
        }
        
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}