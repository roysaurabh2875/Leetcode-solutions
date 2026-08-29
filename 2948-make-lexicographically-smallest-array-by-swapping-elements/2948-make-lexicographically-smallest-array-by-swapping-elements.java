class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length ;
        Integer[] ind = new Integer[n];
        for(int i = 0;i < n;i++){
            ind[i] = i ;
        }
        Arrays.sort(ind , (i,j) -> Integer.compare(nums[i],nums[j]));
        int ans [] = new int[n];
        int i = 0;

        while(i < n){
            int j = i +1 ;
            while(j < n && nums[ind[j]] - nums[ind[j-1]] <= limit){
                j++ ;
            }
            Integer[] group = Arrays.copyOfRange(ind,i,j);
            Arrays.sort(group);
            for(int k = i;k < j;k++){
                ans[group[k-i]] = nums[ind[k]];
            }
            i = j ;
        }
        return ans ;
    }
}