class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        for (int i : nums) {
            num.add(i);
        }
        backtrack(num, new ArrayList<>(), new boolean[num.size()], out);
        return out;
    }

    void backtrack(List<Integer> num, List<Integer> curr, boolean used[], List<List<Integer>> result) {
        if (curr.size() == num.size()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < num.size(); i++) {
            if (used[i])
                continue;
            used[i] = true;
            curr.add(num.get(i));
            backtrack(num, curr, used, result);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}