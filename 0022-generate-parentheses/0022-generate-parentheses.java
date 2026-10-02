class Solution {
    List<String> res ;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        helper(n,n,new StringBuilder());
        return res ;
    }
    void helper(int left,int right,StringBuilder curr){
        if(left == 0 && right ==0){
            res.add(curr.toString());
        }
        if(left > 0){
            curr.append('(');
            helper(left -1,right,curr);
            curr.deleteCharAt(curr.length()-1);
        }
        if(right > 0 && right > left){
            curr.append(')');
            helper(left,right-1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}