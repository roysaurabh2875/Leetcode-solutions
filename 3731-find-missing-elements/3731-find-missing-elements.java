class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>  li = new ArrayList<>() ;
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        HashSet<Integer> set = new HashSet<>() ;
        for(int i = 0 ;i<nums.length ;i++){
            set.add(nums[i]);
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        System.out.print(min+" "+max);
        for(int i = min ;i < max;i++){
            if(!set.contains(i)){
                li.add(i);
            }
        }
        return li ;
    }
}