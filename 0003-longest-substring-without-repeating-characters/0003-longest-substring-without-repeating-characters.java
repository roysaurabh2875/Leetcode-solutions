class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int ans = 0;
            for(int i = 0;i < s.length();i++){
            StringBuilder sb = new StringBuilder() ;
            sb.append(s.charAt(i));
            int j = i+1;
            while(j < s.length() && sb.indexOf(String.valueOf(s.charAt(j))) == -1){
                sb.append(s.charAt(j));
                j++;
            }
            ans = Math.max(ans,sb.length());

        }
        return ans ;
    }
}