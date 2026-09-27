class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> openParenthesis = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(char currChar : s.toCharArray()){
            if(currChar == '('){
                openParenthesis.push(res.length());
            }else if(currChar == ')'){
                int start = openParenthesis.pop() ;
                reverse(res,start,res.length()-1);
            }else{
                res.append(currChar);
            }
        }
        return res.toString();
    }
    void reverse(StringBuilder sb,int start,int end){
        while(start< end){
            char temp = sb.charAt(start);
            sb.setCharAt(start++,sb.charAt(end));
            sb.setCharAt(end--,temp);
        }
    }
}