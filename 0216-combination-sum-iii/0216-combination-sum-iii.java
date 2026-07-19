class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, k, n, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(int index, int k, int n, List<List<Integer>> ans, List<Integer> curr) {

        if (n == 0 && k == curr.size()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < 10; i++) {
            if (n - i < 0) 
                break;

            curr.add(i);
            backtrack(i + 1, k, n - i, ans, curr);
            curr.remove(curr.size() - 1);
        }
    }
}