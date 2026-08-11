// Last updated: 11/08/2026, 20:56:32
class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combi(1,k,n,new ArrayList<>(),0);
        return list;
    }
    public void combi(int val,int k,int n,List<Integer> curr,int sum){
        if(sum==n && curr.size()==k){
            list.add(new ArrayList<>(curr));
            return;
        }
        if(val >9 || sum>n || curr.size()>k){
            return;
        }
        curr.add(val);
        combi(val+1,k,n,curr,sum+val);
        curr.remove(curr.size()-1);
        combi(val+1,k,n,curr,sum);
    }
}