class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, arr, k, n, 0, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(int index, int[] arr, int k, int n, int sum, 
                            List<List<Integer>> ans, List<Integer> curr) {
        
        if (sum == n && curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = index; i < arr.length; i++) {
            if (curr.size() + 1 > k) break;
            if (sum + arr[i] > n) break;

            curr.add(arr[i]);
            backtrack(i + 1, arr, k, n, sum + arr[i], ans, curr);
            curr.remove(curr.size() - 1);
        }
    }
}