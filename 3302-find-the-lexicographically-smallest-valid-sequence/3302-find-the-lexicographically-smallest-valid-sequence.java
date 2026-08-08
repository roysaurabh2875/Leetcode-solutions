class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int suf[] = new int[m];
        Arrays.fill(suf,n);

        int i = n-1;
        int j = m-1 ;
        while(i >= 0 && j >=0){
            if(word1.charAt(i) == word2.charAt(j)){
                suf[j] = i ;
                j-- ;
            }
            i-- ;
        }
        int ans[] = new int[m] ;
        i = 0 ; 
        j = 0 ;
        boolean mismatch = false ;
        while(i<n && j < m){
            if(word1.charAt(i) == word2.charAt(j)){
                ans[j] = i ;
                i++ ;
                j++ ;
            }else{
                if(!mismatch){
                    boolean canusemis = (j == m-1) ||(suf[j+1] != n && suf[j+1] > i) ;
                    if(canusemis){
                        ans[j] = i ;
                        mismatch = true ;
                        i++;
                        j++ ;
                    }else{
                        i++;
                    }
                }else{
                    i++;
                }
            }
        }
        if(j != m){
            return new int[0];
        }
        return ans  ;
    }
}