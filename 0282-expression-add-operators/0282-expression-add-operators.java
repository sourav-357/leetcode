class Solution {
    public List<String> addOperators(String num, int target) {

        List<String> ans = new ArrayList<>();
        backtrack(num, target, 0, "", 0, 0, ans);
        return ans;
    }

    private void backtrack(String num, int target, int idx, String expr,long value,
                           long prev, List<String> ans) {

        if (idx == num.length()) {
            if (value == target)
                ans.add(expr);
            return;
        }

        for (int i = idx; i < num.length(); i++) {

            if (i > idx && num.charAt(idx) == '0')
                break;

            String currStr = num.substring(idx, i + 1);
            long curr = Long.parseLong(currStr);

            if (idx == 0) {
                backtrack(num, target, i + 1, currStr, curr, curr, ans);

            } else {

                backtrack(num, target, i + 1, expr + "+" + currStr, value + curr, curr, ans);
                backtrack(num, target, i + 1, expr + "-" + currStr, value - curr, -curr, ans);
                backtrack(num, target, i + 1, expr + "*" + currStr, value - prev + prev * curr, prev * curr, ans);
            }
        }
    }
}