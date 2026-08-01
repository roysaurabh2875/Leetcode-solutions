class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length ;
        Integer arr[][] = new Integer[n][n];// for memorization 
        return dfs(nums,0,n-1,arr) >= 0 ;
    }
    int dfs(int nums[],int left,int right,Integer arr[][]){
        if(left == right) 
        return nums[left] ;
        if(arr[left][right] != null)
        return arr[left][right] ;

        int pleft = nums[left] - dfs(nums,left+1,right , arr);
        int pright = nums[right] - dfs(nums , left,right-1,arr);

        arr[left][right] = Math.max(pleft,pright);
        return arr[left][right] ;  
    }
}