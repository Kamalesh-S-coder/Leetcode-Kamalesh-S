// Last updated: 11/09/2026, 09:32:53
class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        String first  = "qwertyuiop";
        String second = "asdfghjkl";
        String third  = "zxcvbnm";

        for (String word : words) {
            if (isinrow(word, first) || isinrow(word, second) || isinrow(word, third)) {
                list.add(word);
            }
        }

        return list.toArray(new String[0]); // cleaner than manual array copy
    }

    private boolean isinrow(String s, String row) {
        for (char c : s.toCharArray()) {
            if (row.indexOf(Character.toLowerCase(c)) == -1) return false;
        }
        return true;
    }
}