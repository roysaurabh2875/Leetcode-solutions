/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null||head.next.next == null) return new int[]{-1,-1};
        List<Integer> cp = new ArrayList<>() ;
        int ind = 1 ;
        ListNode prev = head ;
        ListNode curr = head.next ;
        while(curr != null && curr.next!= null){
            int nextval = curr.next.val ;
            if((curr.val > prev.val && curr.val > nextval)||
                (curr.val < prev.val && curr.val < nextval)){
                    cp.add(ind);
                }
                prev = curr ;
                curr = curr.next ;
                ind++ ;
        }
        if(cp.size() < 2)return new int[]{-1,-1};
        int minDist = Integer.MAX_VALUE ;
        for(int i = 1;i < cp.size();i++){
            minDist = Math.min(minDist,cp.get(i)-cp.get(i-1));
        }
        int maxDist = cp.get(cp.size()-1)-cp.get(0);
        return new int[]{minDist,maxDist};
    }
}