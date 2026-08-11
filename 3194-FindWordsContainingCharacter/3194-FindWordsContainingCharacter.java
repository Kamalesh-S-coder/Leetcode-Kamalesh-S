// Last updated: 11/08/2026, 14:16:26
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        int index = 0;
        for (String word : words) {
            if (word.indexOf(x) != -1) {
                res.add(index);
            }
            index++;
        }
        return res;
    }
}
