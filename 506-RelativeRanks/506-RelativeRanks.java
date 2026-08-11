// Last updated: 11/08/2026, 14:20:35
class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n=score.length;
        
        Queue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
          String[] ans= new String[n];

        for(int i: score)
        {
            pq.add(i);
        }

        int rank=1;

        Map<Integer, Integer> mp= new HashMap<>();

        while(!pq.isEmpty())
        {
            mp.put(pq.poll(), rank);
            rank++;
        }

        int ptr=0;

        for(int i=0; i<n; i++)
        {
            int r=mp.get(score[i]);

            if(r==1)
            {
                ans[ptr++]="Gold Medal";
            }
            else if(r==2)
            {
                ans[ptr++]="Silver Medal";
            }
            else if(r==3)
            {
                ans[ptr++]="Bronze Medal";
            }
            else
            {
                ans[ptr++]=Integer.toString(r);
            }
        }

      return ans;


    }
}