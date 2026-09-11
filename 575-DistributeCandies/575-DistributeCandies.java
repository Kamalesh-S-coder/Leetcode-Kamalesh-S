// Last updated: 11/09/2026, 09:31:33
class Solution {
    public int distributeCandies(int[] candyType) 
    {
     int n = candyType.length;
     int mini = Integer.MIN_VALUE;
     HashSet<Integer> set = new HashSet<>();
     for(int num : candyType)
     {
        set.add(num);
     }  
     int uniqueType = set.size();

     mini = Math.min(uniqueType, n/2);

    return mini; 
    }
}