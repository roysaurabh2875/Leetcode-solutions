class Solution {
    public String restoreString(String s, int[] indices) {
        char []out = new char[s.length()];
        for(int i = 0 ; i < indices.length;i++){
            out[indices[i]] = s.charAt(i);
        }
        return new String(out);
    }
}