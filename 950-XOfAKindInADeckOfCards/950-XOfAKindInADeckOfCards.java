// Last updated: 11/08/2026, 14:19:10
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<deck.length;i++){
            map.put(deck[i], map.getOrDefault(deck[i],0)+1);
        }
        
        int ans=0;
        
        for(int key: map.keySet()){
            
            ans = gcd(ans, map.get(key));
        }
    
        return ans>=2 ? true : false;
        

    }
    
    public int gcd(int a, int b){
        if(b==0){
            return a ;
        }
        return gcd(b, a%b);
    }
}
