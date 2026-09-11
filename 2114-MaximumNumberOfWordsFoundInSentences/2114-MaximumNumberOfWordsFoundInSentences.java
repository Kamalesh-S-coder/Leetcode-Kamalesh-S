// Last updated: 11/09/2026, 09:26:13
import java.util.*;
class Solution {
    public int mostWordsFound(String[] sen) {
        int max = 0;
        for(String s :sen)
            max = Math.max(max, new StringTokenizer(s).countTokens());

        return max;
    }
}