class Solution {
    public void sortColors(int[] nums) {
        int l=0, m=0, r=nums.length-1;
        while(m <= r){
            if(nums[m]==0){
                int temp = nums[l];
                nums[l] = nums[m];
                nums[m] = temp;
                l++;
                m++;
            }else if(nums[m] == 1){
                m++;
            }else{
                int temp = nums[r];
                nums[r] = nums[m];
                nums[m] = temp;
                r--;
            }
        }
    }
}