class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        int open = 0;
        int min = 0;
        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            if(c != '(' && c != ')') continue ;

            if(c == '(') open++;
            else open-- ;
            if(open < 0){
                min += Math.abs(open);
                open = 0;
            }
        }
        min += open ;
        Set<String> res = new HashSet<>();
        helper(0,min,0,s,new StringBuilder(),res);

        return new ArrayList<>(res);
    }
    public void helper(int idx,int min,int open, String s,StringBuilder sb, Set<String> res){
        if(open < 0) return ;
        if(idx == s.length()){
            if(open != 0 || min >0) return ;
            res.add(sb.toString());
            return ;
        }
        char c = s.charAt(idx);
        int add = 0;
        if(c == '(') add = 1 ;
        else if (c == ')') add = -1 ;
        sb.append(c);
        helper(idx + 1,min,open+add,s,sb,res);
        sb.deleteCharAt(sb.length()-1);
        if(c != '(' && c != ')') return ;
        if(min != 0) helper(idx + 1,min-1,open,s,sb,res);
    }
}