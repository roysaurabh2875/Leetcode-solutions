class Solution {
    class Node{
        int leftChar ;
        int rightChar ;
        int prefix ;
        int suffix ;
        int best ;
        int len ;
        Node(){}
        Node(char c){
            leftChar = rightChar = c ;
            prefix = suffix = best = 1 ;
            len = 1 ;
        }
    }
    Node tree[] ;
    char [] arr ;
    
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        arr = s.toCharArray() ;
        tree = new Node[4*n];

        build(1,0,n-1);

        int q = queryIndices.length ;
        int [] ans = new int[q] ;
        for(int i =0;i < q;i++){
            int index = queryIndices[i] ;
            char ch = queryCharacters.charAt(i);
            arr[index] = ch ;
            update(1,0,n-1,index,ch);
            ans[i] = tree[1].best ;
        }
        return ans ;
    }
    void build(int node,int l,int r){
        if(l == r){
            tree[node] = new Node(arr[l]);
            return ;
        }
        int mid = l + (r-l)/2 ;
        build(node*2,l,mid);
        build(node*2+1,mid+1,r);
        tree[node] = merge(tree[node*2],tree[node*2+1]);
    }
    void update(int node,int l,int r,int index,char ch){
        if(l == r){
            tree[node] = new Node(ch);
            return ;
        }
        int mid = l+(r-l)/2;
        if(index <= mid){
            update(node*2,l,mid,index,ch);
        }else{
            update(node*2+1,mid+1,r,index,ch);
        }
        tree[node] = merge(tree[node*2],tree[node*2+1]);
    }
    Node merge(Node l,Node r){
        Node res = new Node();

        res.len = l.len + r.len ;
        res.leftChar = l.leftChar ;
        res.rightChar = r.rightChar ;

        res.prefix = l.prefix ;
        res.suffix = r.suffix ;

        res.best = Math.max(l.best,r.best);
        if(l.rightChar == r.leftChar){
            res.best = Math.max(res.best,l.suffix+r.prefix);
            if(l.prefix == l.len){
                res.prefix = l.len + r.prefix ;
            }
            if(r.suffix == r.len){
                res.suffix = r.len + l.suffix ;
            }
        }
        return res ;
    }
}