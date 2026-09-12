import java.util.*;

class Solution {

    static class Interval {
        int left, right, weight, index;
        Interval(int left, int right, int weight, int index) {
            this.left = left;
            this.right = right;
            this.weight = weight;
            this.index = index;
        }
    }
    static class Pair {
        long weight;
        List<Integer> indices;
        Pair(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                    intervals.get(i).get(0),intervals.get(i).get(1),intervals.get(i).get(2),i);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a.right != b.right) {
                return Integer.compare(a.right, b.right);
            }
            return Integer.compare(a.index, b.index);
        });
        int[] rights = new int[n];
        for (int i = 0; i < n; i++) {
            rights[i] = arr[i].right;
        }
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = findPrevious(rights,i,arr[i].left);
        }
        Pair[][] dp = new Pair[n][5];
        for (int i = 0; i < n; i++) {
            dp[i][0] = new Pair(0,new ArrayList<>());
            for (int k = 1; k <= 4; k++) {
                Pair skip;
                if (i > 0) {
                    skip = dp[i - 1][k];
                } else {
                    skip = new Pair(0,new ArrayList<>());
                }
                Pair previous;
                if (prev[i] >= 0) {
                    previous = dp[prev[i]][k - 1];
                } else {
                    previous = new Pair(0,new ArrayList<>());
                }
                long newWeight = previous.weight + arr[i].weight;
                List<Integer> newIndices = new ArrayList<>(previous.indices);
                newIndices.add(arr[i].index);
                Collections.sort(newIndices);
                Pair take = new Pair(newWeight, newIndices);
                dp[i][k] = better(skip, take);
            }
        }
        Pair answer = dp[n - 1][4];
        return answer.indices.stream().mapToInt(Integer::intValue).toArray();
    }
    private int findPrevious(int[] rights,int limit,int left) {
        int low = 0;
        int high = limit - 1;
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (rights[mid] < left) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
    static Pair better(Pair a, Pair b) {

        if (a == null) return b;
        if (b == null) return a;
        if (a.weight != b.weight) {
            return a.weight > b.weight ? a : b;
        }
        int n = Math.min(a.indices.size(),b.indices.size());
        for (int i = 0; i < n; i++) {
            int x = a.indices.get(i);
            int y = b.indices.get(i);
            if (x != y) {
                return x < y ? a : b;
            }
        }
        return a.indices.size() <= b.indices.size()? a: b;
    }
}