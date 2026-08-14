class Solution {
    public int maximumLengthSubstring(String s) {
        int left=0;
        int ans = 0;
        int arr[]= new int[26];
        
        for(int right = 0; right < s.length();right++){
            int ch = s.charAt(right)-'a';
            arr[ch]++;
            while(arr[ch]>2){
                int ch2 = s.charAt(left)-'a';
                arr[ch2]--;
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}