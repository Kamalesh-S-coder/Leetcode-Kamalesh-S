// Last updated: 11/09/2026, 09:33:30
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int j=0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<houses.length;i++){
            while(j<heaters.length-1 && Math.abs(houses[i]-heaters[j+1])<=Math.abs(houses[i]-heaters[j])) j++;
            max=Math.max(max,Math.abs(houses[i]-heaters[j]));
        }
        return max;
    }
}