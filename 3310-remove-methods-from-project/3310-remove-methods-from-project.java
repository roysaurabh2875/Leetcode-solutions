class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>() ;
        for(int i = 0 ; i < n;i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[] : invocations){
            graph.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>() ;
        st.push(k);
        visited[k] = true ;

        while(!st.isEmpty()){
            int ver = st.pop() ;
            for(int i : graph.get(ver)){
                if(!visited[i]){
                    visited[i] = true ;
                    st.push(i);
                }
            }
        }
        for(int edge[] : invocations){
            int u = edge[0];
            int v = edge[1];

            if(!visited[u] && visited[v]){
                List<Integer> ans = new ArrayList<>() ;
                for(int i = 0 ; i < n;i++){
                    ans.add(i);
                }
                return ans ;
            }
        }
        List<Integer> ans = new ArrayList<>() ;
        for(int i= 0 ; i < n ;i++){
            if(!visited[i]){
                ans.add(i);
            }
        }
        return ans ;
    }
}