class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> reservedmap = new HashMap<>() ;

        for(int seat[] : reservedSeats){
            int row = seat[0] , col = seat[1] ;
            reservedmap.computeIfAbsent(row,k -> new HashSet<>()).add(col);
        }
        int result = 0;

        for(Map.Entry<Integer,Set<Integer>> entry : reservedmap.entrySet()){
            Set<Integer> reserved = entry.getValue() ;

            boolean blockA = !(reserved.contains(2) || reserved.contains(3) || reserved.contains(4)|| reserved.contains(5));
            boolean blockB = !(reserved.contains(4) || reserved.contains(5) || reserved.contains(6)|| reserved.contains(7));
            boolean blockC = !(reserved.contains(6) || reserved.contains(7) || reserved.contains(8)|| reserved.contains(9));

            if(blockA && blockC){
                result += 2 ;
            }else if(blockA || blockB || blockC){
                result += 1;
            }
        }
        result += (n - reservedmap.size()) * 2;
        return result ;
    }
}