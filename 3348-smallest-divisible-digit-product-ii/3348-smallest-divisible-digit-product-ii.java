import java.util.*;

class Solution {

    /*
     * Prime-factor contribution of each digit.
     *
     * Index:
     * 0 -> factor 2
     * 1 -> factor 3
     * 2 -> factor 5
     * 3 -> factor 7
     */
    static final int[][] F = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {

        // ==========================================
        // 1. Factorize t
        // ==========================================

        int[] need = new int[4];

        int[] primes = {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {

            while (t % primes[i] == 0) {

                need[i]++;
                t /= primes[i];
            }
        }

        /*
         * If t still has a factor, that factor is not
         * 2, 3, 5 or 7.
         *
         * No digit 1-9 can provide that factor.
         */
        if (t != 1) {
            return "-1";
        }

        int n = num.length();

        // ==========================================
        // 2. Check whether num itself is valid
        // ==========================================

        int[] total = new int[4];

        boolean hasZero = false;

        for (int i = 0; i < n; i++) {

            int d = num.charAt(i) - '0';

            if (d == 0) {
                hasZero = true;
                break;
            }

            add(total, F[d]);
        }

        if (!hasZero && valid(total, need)) {
            return num;
        }

        // ==========================================
        // 3. Prefix factor information
        //
        // prefix[i] = factors in num[0 ... i-1]
        // ==========================================

        int[][] prefix = new int[n + 1][4];

        boolean zeroSeen = false;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < 4; j++) {
                prefix[i + 1][j] = prefix[i][j];
            }

            int d = num.charAt(i) - '0';

            if (d == 0) {

                zeroSeen = true;

            } else if (!zeroSeen) {

                add(prefix[i + 1], F[d]);
            }
        }

        /*
         * Position of the first zero.
         *
         * Any unchanged prefix containing zero is invalid.
         */
        int firstZero = num.indexOf('0');

        // ==========================================
        // 4. Try to make same-length answer
        //
        // Start from rightmost position.
        // ==========================================

        for (int i = n - 1; i >= 0; i--) {

            /*
             * If a zero occurs before i, then
             * num[0 ... i-1] already contains zero.
             *
             * Therefore this position cannot be used.
             */
            if (firstZero != -1 && firstZero < i) {
                continue;
            }

            int current = num.charAt(i) - '0';

            /*
             * Try the smallest possible digit greater
             * than current.
             */
            for (int d = current + 1; d <= 9; d++) {

                int[] have = prefix[i].clone();

                // Add the new digit
                add(have, F[d]);

                /*
                 * Number of positions remaining after
                 * the changed digit.
                 */
                int remaining = n - i - 1;

                /*
                 * Find factors still required.
                 */
                int[] missing = new int[4];

                for (int j = 0; j < 4; j++) {

                    missing[j] =
                        Math.max(
                            0,
                            need[j] - have[j]
                        );
                }

                /*
                 * Minimum number of digits needed
                 * for the missing factors.
                 */
                int required =
                    minimumRequiredDigits(missing);

                /*
                 * If we have enough remaining positions,
                 * this candidate works.
                 */
                if (required <= remaining) {

                    String suffix =
                        buildSmallestSuffix(
                            remaining,
                            missing
                        );

                    return num.substring(0, i)
                            + d
                            + suffix;
                }
            }
        }

        // ==========================================
        // 5. Same-length answer doesn't exist
        //
        // Need a number with more digits.
        // ==========================================

        int minimumLength =
            minimumRequiredDigits(need);

        /*
         * We need at least n+1 digits because the answer
         * must be greater than num.
         *
         * But if the factors themselves require more
         * than n+1 digits, use that larger length.
         */
        int answerLength =
            Math.max(
                n + 1,
                minimumLength
            );

        return buildSmallestSuffix(
            answerLength,
            need
        );
    }

    // ==============================================
    // Calculate minimum number of digits required
    // for given factors of 2,3,5,7
    // ==============================================

    static int minimumRequiredDigits(int[] need) {

        int c2 = need[0];
        int c3 = need[1];
        int c5 = need[2];
        int c7 = need[3];

        int count = 0;

        /*
         * 5 can only be represented by digit 5.
         */
        count += c5;

        /*
         * 7 can only be represented by digit 7.
         */
        count += c7;

        /*
         * 8 = 2^3
         */
        count += c2 / 3;
        c2 %= 3;

        /*
         * 9 = 3^2
         */
        count += c3 / 2;
        c3 %= 2;

        /*
         * 6 = 2 * 3
         */
        if (c2 > 0 && c3 > 0) {

            count++;

            c2--;
            c3--;
        }

        /*
         * 4 = 2^2
         */
        count += c2 / 2;
        c2 %= 2;

        /*
         * Remaining 2
         */
        count += c2;

        /*
         * Remaining 3
         */
        count += c3;

        return count;
    }

    // ==============================================
    // Build smallest suffix
    // ==============================================

    static String buildSmallestSuffix(
            int length,
            int[] need) {

        int c2 = need[0];
        int c3 = need[1];
        int c5 = need[2];
        int c7 = need[3];

        List<Integer> digits =
            new ArrayList<>();

        /*
         * 5
         */
        while (c5 > 0) {

            digits.add(5);
            c5--;
        }

        /*
         * 7
         */
        while (c7 > 0) {

            digits.add(7);
            c7--;
        }

        /*
         * 8 = 2^3
         */
        while (c2 >= 3) {

            digits.add(8);
            c2 -= 3;
        }

        /*
         * 9 = 3^2
         */
        while (c3 >= 2) {

            digits.add(9);
            c3 -= 2;
        }

        /*
         * 6 = 2 * 3
         */
        while (c2 > 0 && c3 > 0) {

            digits.add(6);

            c2--;
            c3--;
        }

        /*
         * 4 = 2^2
         */
        while (c2 >= 2) {

            digits.add(4);

            c2 -= 2;
        }

        /*
         * Remaining 2
         */
        while (c2 > 0) {

            digits.add(2);

            c2--;
        }

        /*
         * Remaining 3
         */
        while (c3 > 0) {

            digits.add(3);

            c3--;
        }

        /*
         * Safety check.
         */
        if (digits.size() > length) {
            return null;
        }

        /*
         * Remaining positions can contain 1.
         *
         * Product of 1 does not change anything.
         */
        while (digits.size() < length) {

            digits.add(1);
        }

        /*
         * Sort digits to make the number smallest.
         */
        Collections.sort(digits);

        StringBuilder sb =
            new StringBuilder(length);

        for (int d : digits) {

            sb.append(d);
        }

        return sb.toString();
    }

    // ==============================================
    // Add prime factors
    // ==============================================

    static void add(int[] a, int[] b) {

        for (int i = 0; i < 4; i++) {

            a[i] += b[i];
        }
    }

    // ==============================================
    // Check whether factors are sufficient
    // ==============================================

    static boolean valid(
            int[] have,
            int[] need) {

        for (int i = 0; i < 4; i++) {

            if (have[i] < need[i]) {
                return false;
            }
        }

        return true;
    }
}