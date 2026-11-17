class Solution {

    public int minimumChanges(String s, int k) {

        int n = s.length();
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getCost(s, i, j);
            }
        }

        int INF = (int)1e9;

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int p = 0; p <= k; p++) {
                dp[i][p] = INF;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int p = 1; p <= k; p++) {

                for (int t = p - 1; t < i; t++) {

                    if (cost[t][i - 1] == 0 && i - t == 1)
                        continue; 

                    dp[i][p] = Math.min(
                        dp[i][p],
                        dp[t][p - 1] + cost[t][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }

     int getCost(String s, int l, int r) {

        int len = r - l + 1;
        int ans = Integer.MAX_VALUE;

        for (int d = 1; d < len; d++) {

            if (len % d != 0)
                continue;

            int changes = 0;

            for (int rem = 0; rem < d; rem++) {

                ArrayList<Integer> pos = new ArrayList<>();

                for (int p = rem; p < len; p += d) {
                    pos.add(l + p);
                }

                int left = 0;
                int right = pos.size() - 1;

                while (left < right) {

                    if (s.charAt(pos.get(left))
                            != s.charAt(pos.get(right))) {
                        changes++;
                    }

                    left++;
                    right--;
                }
            }

            ans = Math.min(ans, changes);
        }

        return ans;
    }
}