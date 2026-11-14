class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min_sum = Integer.MAX_VALUE ;
        for(int i = l;i <= r;i++){
            int total = 0;
            for(int j = 0;j < i;j++){
                total += nums.get(j) ; 
            }

            if(total > 0){
                min_sum = Math.min(min_sum,total);
            }
            for(int right = i ;right < nums.size();right++){
                total = total + nums.get(right) - nums.get(right-i);

                if(total > 0){
                    min_sum = Math.min(min_sum , total);
                }
            }
        }
        return min_sum == Integer.MAX_VALUE ? -1 : min_sum ;
    }
}