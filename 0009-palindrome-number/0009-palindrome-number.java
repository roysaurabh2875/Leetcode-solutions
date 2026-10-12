class Solution {
    public boolean isPalindrome(int x) {
        
        String numinstr = Integer.toString(x);
        String reverse ="";
        for(int i = numinstr.length()-1;i>=0;i--){
            reverse += numinstr.charAt(i);
            
        }
        return reverse.equals(numinstr);
    }
}