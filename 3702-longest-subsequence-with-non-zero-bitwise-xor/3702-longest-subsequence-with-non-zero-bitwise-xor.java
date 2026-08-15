class Solution {
    public int longestSubsequence(int[] nums) {
        int xortotal = 0 ;
        boolean nonzero = false ;
        for(int num : nums){
            if(num > 0) nonzero = true ;
            xortotal ^= num ;
        }
        if(xortotal != 0) return nums.length ;
        if(nonzero) return nums.length -1 ;
        return 0 ;
    }
}