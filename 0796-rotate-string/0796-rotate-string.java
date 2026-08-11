class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        String temp = s+s ;
        for (int i = 1; i <= s.length(); i++) {
            if(goal.equals(temp.substring(i,i+s.length()))){
                return true ;
            }
        }
        return false ;
    }
}