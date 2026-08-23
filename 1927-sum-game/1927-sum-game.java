class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int lsum  = 0;
        int rsum = 0;
        int lq = 0;
        int rq = 0;
        for(int i = 0;i< n/2;i++){
            char c = num.charAt(i);
            if(c == '?'){
                lq++;
            }else{
                lsum += c - '0';
            }
        }
        for(int i = n/2;i<n;i++){
            char c = num.charAt(i);
            if(c == '?'){
                rq++;
            }else{
                rsum += c - '0';
            }
        }  
        int sumdiff = lsum - rsum ;
        int qdiff = lq - rq;
        if(qdiff % 2 != 0){
            return true ;
        }  
        return sumdiff != -(qdiff/2)*9;
    }
}