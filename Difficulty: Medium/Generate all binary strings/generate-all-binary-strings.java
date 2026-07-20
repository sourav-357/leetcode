class Solution {
    public ArrayList<String> binstr(int n) {
        
        ArrayList<String> ans = new ArrayList<>();
        backtrack(n, "", ans);
        return ans;
    }

    private void backtrack(int n, String curr, ArrayList<String> ans) {
        if (curr.length() == n) {
            ans.add(curr);
            return;
        }

        backtrack(n, curr + "0", ans);
        backtrack(n, curr + "1", ans);
    }
}