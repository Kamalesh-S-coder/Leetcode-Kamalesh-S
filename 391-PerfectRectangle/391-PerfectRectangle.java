// Last updated: 11/08/2026, 14:22:03
import java.util.*;
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int n=rectangles.length;
        var startx=new HashMap<Integer,List<List<Integer>>>();
        var endx=new HashMap<Integer,List<List<Integer>>>();
        var starty=new HashMap<Integer,List<List<Integer>>>();
        var endy=new HashMap<Integer,List<List<Integer>>>();
        var distinctx=new TreeSet<Integer>();
        var distincty=new TreeSet<Integer>();

        for(var r:rectangles)
        {
            distinctx.add(r[0]); distinctx.add(r[2]);
            distincty.add(r[1]); distincty.add(r[3]);

            startx.computeIfAbsent(r[0],__->new ArrayList<>()).add(List.of(r[1],r[3]));
            endx.computeIfAbsent(r[2],__->new ArrayList<>()).add(List.of(r[1],r[3]));
            starty.computeIfAbsent(r[1],__->new ArrayList<>()).add(List.of(r[0],r[2]));
            endy.computeIfAbsent(r[3],__->new ArrayList<>()).add(List.of(r[0],r[2]));
        }

        var yranges=new TreeSet<List<Integer>>((x,y)->{
            if(x.get(0).equals(y.get(0)))return Integer.compare(x.get(1),y.get(1));
            return Integer.compare(x.get(0),y.get(0));
        });
        for(int x:distinctx)
        {
            if(x==distinctx.last())break;
            for(var endrange:endx.getOrDefault(x,new ArrayList<>())){
                yranges.remove(endrange);
            }
            for(var startrange:startx.getOrDefault(x,new ArrayList<>())){
                if(yranges.contains(startrange))return false;
                yranges.add(startrange);
            }

            int cury=distincty.first();
            for(var range:yranges)
            {
                if(range.get(0)!=cury)return false;
                cury=range.get(1);
            }
            if(cury!=distincty.last())return false;
        }

        var xranges=new TreeSet<List<Integer>>((x,y)->{
            if(x.get(0).equals(y.get(0)))return Integer.compare(x.get(1),y.get(1));
            return Integer.compare(x.get(0),y.get(0));
        });
        for(int y:distincty)
        {
            if(y==distincty.last())break;
            for(var endrange:endy.getOrDefault(y,new ArrayList<>())){
                xranges.remove(endrange);
            }
            for(var startrange:starty.getOrDefault(y,new ArrayList<>())){
                if(xranges.contains(startrange))return false;
                xranges.add(startrange);
            }

            int curx=distinctx.first();
            for(var range:xranges)
            {
                if(range.get(0)!=curx)return false;
                curx=range.get(1);
            }
            if(curx!=distinctx.last())return false;
        }

        return true;
    }
}