class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> dictinary = new HashMap<>();
        for(List<String> kv : knowledge){
            dictinary.put(kv.get(0),kv.get(1));
        }
        boolean addKey = false ;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                addKey = true ;
            }else if(c == ')'){
                if(dictinary.containsKey(key.toString())){
                    res.append(dictinary.get(key.toString()));
                }else{
                    res.append('?');
                }
                addKey = false ;
                key.setLength(0);
            }else if(addKey){
                key.append(c);
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}