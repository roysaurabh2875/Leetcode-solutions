class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        String half = findNextHalf(halfFreq, target, n, middle);

        if (half == null) {
            return "";
        }

        return makePalindrome(half, middle, n);
    }

    private String findNextHalf(int[] freq, String target, int n, int middle) {
        int halfLen = n / 2;
        String targetHalf = target.substring(0, halfLen);

        String equal = buildExact(freq, targetHalf);

        if (equal != null) {
            String palindrome = makePalindrome(equal, middle, n);

            if (palindrome.compareTo(target) > 0) {
                return equal;
            }
        }

        return buildNextGreater(freq, targetHalf);
    }

    private String buildExact(int[] freq, String targetHalf) {
        int[] remaining = freq.clone();

        for (int i = 0; i < targetHalf.length(); i++) {
            int c = targetHalf.charAt(i) - 'a';

            if (remaining[c] == 0) {
                return null;
            }

            remaining[c]--;
        }

        return targetHalf;
    }

    private String buildNextGreater(int[] freq, String targetHalf) {
        int len = targetHalf.length();

        for (int pos = len - 1; pos >= 0; pos--) {
            int[] remaining = freq.clone();
            boolean valid = true;

            for (int i = 0; i < pos; i++) {
                int c = targetHalf.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    valid = false;
                    break;
                }

                remaining[c]--;
            }

            if (!valid) {
                continue;
            }

            int current = targetHalf.charAt(pos) - 'a';

            for (int c = current + 1; c < 26; c++) {
                if (remaining[c] == 0) {
                    continue;
                }

                remaining[c]--;

                StringBuilder ans = new StringBuilder();

                for (int i = 0; i < pos; i++) {
                    ans.append(targetHalf.charAt(i));
                }

                ans.append((char) ('a' + c));

                for (int i = 0; i < 26; i++) {
                    while (remaining[i] > 0) {
                        ans.append((char) ('a' + i));
                        remaining[i]--;
                    }
                }

                return ans.toString();
            }
        }

        return null;
    }

    private String makePalindrome(String half, int middle, int n) {
        StringBuilder ans = new StringBuilder();

        ans.append(half);

        if (n % 2 == 1) {
            ans.append((char) ('a' + middle));
        }

        ans.append(new StringBuilder(half).reverse());

        return ans.toString();
    }
}