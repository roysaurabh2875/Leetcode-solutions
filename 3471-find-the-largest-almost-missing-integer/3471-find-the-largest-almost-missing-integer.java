class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length ;
        for(int i = 0;i < n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(k == n){
            int largest = Integer.MIN_VALUE;
            for(int i =0;i<n;i++){
                largest = Math.max(largest,nums[i]);
            }
            return largest ;
        }
        if(k == 1){
            int largest = -1 ;
            for(int i = 0; i < n;i++){
                if(map.get(nums[i]) == 1 && nums[i] > largest){
                    largest = nums[i];
                }
            }
            return largest ;
        }
        n = n - 1;
        if(map.get(nums[0]) == 1 && map.get(nums[n])==1){
            return Math.max(nums[0],nums[n]);
        }
        if((map.get(nums[0]) > 1 && map.get(nums[n]) == 1) || (map.get(nums[0]) == 1)&&map.get(nums[n])>1){
            if(map.get(nums[0]) > 1) return nums[n];
            else return nums[0];
        }
        return -1 ;
    }
}