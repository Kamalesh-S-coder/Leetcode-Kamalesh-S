// Last updated: 11/08/2026, 14:21:00
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int n= 0;
        long end = Long.MIN_VALUE;
        for(int[] baloon:points){
            if(baloon[0]<=end){
                continue;
            }
            else{
                n++;
                end = baloon[1];
            }
        }
        return n;
    }
}