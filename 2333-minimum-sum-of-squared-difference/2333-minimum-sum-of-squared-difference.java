class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length ;
        int diff [] = new int[n];
        long k = (long) k1 + k2 ;
        int maxDiff = 0;
        long sum = 0;

        for(int  i = 0;i < n;i++){
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i] ;
            maxDiff = Math.max(maxDiff , diff[i]);
        }

        if(sum <= k) return 0;

        int l = 0, r = maxDiff ;
        while(l < r){
            int mid = l + (r - l)/2 ;
            long oper = 0;

            for(int d : diff){
                if(d > mid){
                    oper += d - mid ;
                }
            }
            if(oper <= k){
                r = mid ;
            }else{
                l = mid + 1; 
            }
        }
        int thre = l ;
        long rem = k ;

        for(int d: diff){
            if(d > thre){
                rem -= d - thre ;
            }
        }

        long res = 0;
        for(int d : diff){
            d = Math.min(d,thre);
            if(d == thre && rem > 0){
                d-- ;
                rem--;
            }
            res += (long) d*d ;
        }
        return res ;
    }
}