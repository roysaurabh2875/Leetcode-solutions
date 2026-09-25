
class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = build(expression);
        List<String> list = new ArrayList<>(result);
        Collections.sort(list);
        return list;
    }

    private Set<String> build(String s) {
        Set<String> parts = new HashSet<>();
        Set<String> curr = new HashSet<>();
        curr.add("");

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '{') {
                int j = i, depth = 0;
                while (j < s.length()) {
                    if (s.charAt(j) == '{') depth++;
                    else if (s.charAt(j) == '}') depth--;
                    if (depth == 0) break;
                    j++;
                }
                Set<String> options = build(s.substring(i + 1, j));
                Set<String> next = new HashSet<>();
                for (String a : curr) {
                    for (String b : options) {
                        next.add(a + b);
                    }
                }
                curr = next;
                i = j + 1;
            } else if (s.charAt(i) == ',') {
                parts.addAll(curr);
                curr = new HashSet<>();
                curr.add("");
                i++;
            } else {
                Set<String> next = new HashSet<>();
                for (String a : curr) {
                    next.add(a + s.charAt(i));
                }
                curr = next;
                i++;
            }
        }
        parts.addAll(curr);
        return parts;
    }
}
