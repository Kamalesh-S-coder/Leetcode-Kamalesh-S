// Last updated: 11/09/2026, 09:29:29
class Solution {
    int ans=0;
    int [] dr={-1,1,0,0};
    int[] dc={0,0,-1,1};
    int m;
    int n;
    public int containVirus(int[][] isIn) {

        this.m=isIn.length;
        this.n=isIn[0].length;
        while(true){
            boolean [][] visited=new boolean[m][n];
            List<Set<Integer>> components=new ArrayList<>();
            List<Set<Integer>> threats=new ArrayList<>();
            List<Integer> walls=new ArrayList<>();
            for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        if(!visited[i][j]&& isIn[i][j]==1){
                            Set<Integer> set=new HashSet<>();
                            
                            dfs(i,j,visited,isIn,set);// collect the components
                            components.add(set);
                            walls.add(Walls(set,isIn));// get number of walls need to block them
                            Set<Integer> aff=futureAffect(set,isIn);//get the area they would affect in future
                            threats.add(aff);
                        }
                    }
                }
                if(components.size()==0) break;// no components are there (all blocked)
                int ind=-1;
                int count=0;

                for(int i=0;i<threats.size();i++){
                    Set<Integer> threat=threats.get(i);
                    if(count<threat.size()){
                        count=threat.size();
                        ind=i;
                    }

                }  
                if(count==0) break; // the surroundings of the blocked area (area which has more threats)has no unaffected area (all are affected or blocked)
                
                ans+=walls.get(ind);// add the walls of the area which will affect more

                for(int area:components.get(ind)){
                int nr=area/n;
                int nc=area%n;
                    isIn[nr][nc]=-1; 
                }// block the area which affects more with -1 so we wont use this component again

                for(int i=0;i<threats.size();i++){
                    if(i==ind) continue;
                    Set<Integer> threat=threats.get(i);
                    for(int area:threat){
                        int nr=area/n;
                        int nc=area%n;
                        isIn[nr][nc]=1; 
                    }
                }// make the virus spread 
                
        
        }
       

    return ans;

        
    }

    public int Walls(Set<Integer> set,int[][] isIn){
       int w=0;

       for(int cell:set){
          int r=cell/n;
          int c=cell%n;
           for(int i=0;i<4;i++){
              int nr=r+dr[i];
              int nc=c+dc[i];

              if(nr>=0&&nr<m&&nc>=0&&nc<n&&isIn[nr][nc]==0){
                w++;
              }
           }
       } 
       return w;
    }

    public Set<Integer> futureAffect(Set<Integer> set,int[][] isIn){
    
     Set<Integer> affect=new HashSet<>();
       for(int cell:set){
          int r=cell/n;
          int c=cell%n;
           for(int i=0;i<4;i++){
              int nr=r+dr[i];
              int nc=c+dc[i];

              if(nr>=0&&nr<m&&nc>=0&&nc<n&&isIn[nr][nc]==0){
                 affect.add(nr*n+nc);
              }
           }
       } 
       return affect;
    }

    public void dfs(int i,int j, boolean [][] visited,int[][] isIn, Set<Integer> set){
            visited[i][j]=true;
            set.add(i*n+j);
             for(int r=0;r<4;r++){
                int nr=i+dr[r];
                int nc=j+dc[r];
                if(nr>=0&&nr<m&&nc>=0&&nc<n&&!visited[nr][nc]&&isIn[nr][nc]==1){
                    dfs(nr,nc,visited,isIn,set);
                }
             }        
    }

    
}