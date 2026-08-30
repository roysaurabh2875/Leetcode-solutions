class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length ;
        int lar = Integer.MIN_VALUE ;
        int larind = -1 ;
        int sma = Integer.MAX_VALUE ;
        int smaind = -1 ;
        for(int i= 0;i<n;i++){
            if(nums[i] > lar){
                lar = nums[i];
                larind = i ;
            }
            if(nums[i] < sma){
                sma = nums[i];
                smaind = i ;
            }
        }
        int left = Math.min(larind , smaind);
        int right = Math.max(larind,smaind);
        return Math.min(Math.min(right+1,n-left),left+1+(n-right));
    }
}