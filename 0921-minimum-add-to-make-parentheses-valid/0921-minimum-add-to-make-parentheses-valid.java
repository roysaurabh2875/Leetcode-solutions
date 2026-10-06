class Solution {
    public int minAddToMakeValid(String s) {
        int openChar = 0;
        int minAddsReq = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                openChar++;
            }else{
                if(openChar > 0){
                    openChar--;
                }else{
                    minAddsReq++;
                }
            }
        }
        return minAddsReq + openChar ;
    }
}