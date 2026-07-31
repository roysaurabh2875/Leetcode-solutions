class Solution {
    public int minimumPushes(String word) {

        Map<Character, Integer> fre = new HashMap<>();
        for (char c : word.toCharArray()) {
            fre.put(c, fre.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(fre.entrySet());
        sortedList.sort((a, b) -> {
            int cmp = b.getValue().compareTo(a.getValue());
            return (cmp != 0) ? cmp : Character.compare(a.getKey(), b.getKey());
        });
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : sortedList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        int n = sortedMap.size() ;
        int ans = 0 ;
        int i = 0 ;
        for(Map.Entry<Character,Integer> entry : sortedMap.entrySet()){
            ans += ( i / 8 + 1) * entry.getValue();
            i++ ;
        }
        return ans ;
    }
}