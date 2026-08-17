class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        // Arrays.sort(strs);
        // String s1 = strs[0];
        // String s2 = strs[strs.length -1];
        // int i = 0;
        // while(i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)){
        //     i++;
        // }
        // return s1.substring(0,i);

        //vertical scanning appproach 
        for(int i = 0;i < strs[0].length();i++){
            char ch = strs[0].charAt(i);

            for(int j = 1;j < strs.length ;j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}