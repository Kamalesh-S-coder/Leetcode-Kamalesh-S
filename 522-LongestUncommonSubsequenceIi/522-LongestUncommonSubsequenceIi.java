// Last updated: 11/09/2026, 09:32:33
class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int len = -1;
        HashSet<String> set = new HashSet<>();
        for(int i =0;i<n;i++){
            String str = strs[i];

            if(!set.contains(str)){
                boolean possibilities = true;
                for(int j=0;j<n;j++)
                {
                    if(i == j) continue;
                    String temp = strs[j];
                    if(str.equals(temp)) {
                        set.add(str);
                        set.add(temp);
                        possibilities = false;
                        break;
                    }
                    int len1 = str.length();
                    int len2 = temp.length();
                    int p =0;int q=0;
                    while(p < len1 && q < len2){
                        if(str.charAt(p) == temp.charAt(q)){
                            p++;
                            q++;
                        }else q++;
                    }
                    if(p == len1) possibilities = false;
                }
                if(possibilities) len = Math.max(len, str.length());
            }
        }

        return len;
    }
}