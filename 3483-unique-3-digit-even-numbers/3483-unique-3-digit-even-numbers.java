class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length ;
        int arr[] = new int[1000];
        for(int d:digits){
            arr[d]++;
        }
        int count = 0;
        for(int num = 100; num <= 999 ;num++){
            if(num % 2 != 0) continue;
            int need[] = new int[10] ;
            int x = num ;
            need[x%10]++;
            x/= 10 ;
            need[x%10]++;
            x/=10;
            need[x]++;
            boolean possible = true ;
            for(int d = 0;d <= 9;d++){
                if(need[d] > arr[d]){
                    possible = false ;
                    break ;
                }
            }
            if(possible)count++;
        }
        return count ;
    }
}