class Solution {
    static final int MOD = 1_000_000_007;

    long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public int numberOfSets(int n, int k) {

        long[] fact = new long[n+k+1];
        long[] invFact = new long[n+k+1];
        fact[0] = 1;
        for (int i = 1; i <= n+k; i++) fact[i] = (fact[i-1] * i) % MOD;
        invFact[n+k] = modPow(fact[n+k], MOD-2);
        for (int i = n+k-1; i >= 0; i--) invFact[i] = (invFact[i+1] * (i+1)) % MOD;

        int N = n + k - 1;
        int R = 2 * k;
        if (R > N) return 0;
        long ans = fact[N] * invFact[R] % MOD * invFact[N-R] % MOD;
        return (int) ans;
    }
}
