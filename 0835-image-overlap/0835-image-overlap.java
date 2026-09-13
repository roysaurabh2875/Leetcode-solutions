class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length ;
        List<int[]> l1 = new ArrayList<>();
        List<int[]> l2 = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(img1[i][j] == 1){
                    l1.add(new int[]{i,j});
                }
            }
        }
        for(int i= 0;i <n;i++){
            for(int j = 0;j <n;j++){
                if(img2[i][j] == 1){
                    l2.add(new int[]{i,j});
                }
            }
        }
        HashMap<String,Integer> overlap = new HashMap<>();
        int maxOverlap = 0;
        for(int p1[] : l1){
            for(int p2[] : l2){
                int dx = p2[0] - p1[0];
                int dy = p2[1] - p1[1];
                String key = dx +","+dy ;
                overlap.put(key,overlap.getOrDefault(key,0)+1);
                maxOverlap = Math.max(maxOverlap,overlap.get(key));
            }
        }
        return maxOverlap;
    }
}