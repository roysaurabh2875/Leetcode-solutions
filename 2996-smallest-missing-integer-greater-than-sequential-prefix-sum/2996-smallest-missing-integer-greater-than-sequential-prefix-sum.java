class Solution {
    public int missingInteger(int[] nums) {
        int sum = 0 ;
        HashSet<Integer> cont = new HashSet<>() ;
        for(int num :nums){
            cont.add(num);
        }
        int i = 1;
        while(i < nums.length && nums[i] == nums[i-1]+1 ){
            sum += nums[i-1];
            i++ ;
        }
        sum += nums[i-1];
        
        while(cont.contains(sum)){
            sum++ ;
        }
        return sum ;
    }
}