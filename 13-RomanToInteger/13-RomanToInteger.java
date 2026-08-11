// Last updated: 11/08/2026, 21:02:26
class Solution {
    int value(char c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }
    public int romanToInt(String s) {
        int res=0;
        char next;
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(i+1<s.length()){
                next = s.charAt(i+1);
                if(value(c)>=value(next))
                    res+=value(c);
                else{
                    res+=value(next)-value(c);
                    i++;
                }
            
            }else{
                res+=value(c);
            }
        }
        return res;
    }
}
// class Solution {
//     int value(char c){
//         switch(c){
//             case 'I':return 1;
//             case 'V' : return 5;
//             case 'X' : return 10;
//             case 'L' : return 50;
//             case 'C' : return 100;
//             case 'D' : return 500;
//             case 'M' : return 1000;
//         }
//         return 0;
//     }
//     public int romanToInt(String s) {
//         int res = 0;
//         for(int i=0;i<s.length();i++){
//             char c = s.charAt(i);
//             if(i+1<s.length()){
//                 char next = s.charAt(i+1);
//                 if(value(c)>=value(next))
//                     res+=value(c);
//                 else {
//                     res += value(next)-value(c);
//                     i++;
//                 }    
//             } 
//             else{
//                 res+=value(c);
//             }   
//         }
//         return res;
      
//     }
// }