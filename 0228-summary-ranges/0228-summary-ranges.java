class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>() ;
        int i = 0;
        while(i < nums.length){
            int j = i ;
            while(j < nums.length-1 && nums[j]+1 == nums[j+1]){
                j++ ;
            }
            if( j == i){
                res.add(nums[i]+"");
                i++;
            }
            else{
                res.add(nums[i]+"->"+nums[j]);
                i = j+1 ;
            }
        }
        return res ;
    }
}