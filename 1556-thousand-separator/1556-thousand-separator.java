class Solution {
    public String thousandSeparator(int n) {
        if(n < 1000) return String.valueOf(n);

        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = s.length()-1 ; i >= 0;i--){
            sb.append(s.charAt(i));
            count++ ;
            if(count == 3 && i != 0){
                sb.append('.');
                count = 0;
            }
        }
        return sb.reverse().toString();
    }
}