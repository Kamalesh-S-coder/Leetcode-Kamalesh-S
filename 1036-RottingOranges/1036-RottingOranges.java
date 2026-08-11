// Last updated: 11/08/2026, 14:18:52
class Solution {
    class Pair
       { int row;
       int col;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
       }
    public int orangesRotting(int[][] grid) {
       int n=grid.length;//row
       int m=grid[0].length;//column
       Queue<Pair>q=new LinkedList<>();
       int fresh=0;
       for(int i=0;i<n;i++)
       {
        for(int j=0;j<m;j++)
        {
            if(grid[i][j]==2)
            {
                q.offer(new Pair(i,j));
            }
            if(grid[i][j]==1)
            {
                fresh ++;
            }
        }
       }
       if(fresh==0)
       {
        return 0;
       }
       int time=0;
       int dr[]={-1,1,0,0};
       int dc[]={0,0,-1,1};
       while(!q.isEmpty())
       {
            int size=q.size();
            boolean rotten=false; 
            for(int i=0;i<size;i++)
            {
                Pair curr=q.poll();
                //caluation of connected cells 
                for(int j=0;j<4;j++)
                {
                    int nr=dr[j]+curr.row;
                    int nc=dc[j]+curr.col;
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;
                        fresh--;
                        q.offer(new Pair(nr,nc));
                        rotten =true;
                    }
                }
            }
            if(rotten)
            {
                time++;
            }
       }
       if(fresh==0)
       {
        return time;
       }
       else{
        return -1;
       }
    }
}