class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long mn = Math.min(need1,need2);
        long mx = Math.max(need1,need2);

        long seperate = (long)cost1 * need1 +(long) cost2 * need2 ;
        long overlap =(long) mn * costBoth + (long)(need1 - mn) * cost1 + (long)(need2 - mn) * cost2 ;
        long all = (long)mx * costBoth ;

        return Math.min(seperate , Math.min(overlap,all));
    }
}