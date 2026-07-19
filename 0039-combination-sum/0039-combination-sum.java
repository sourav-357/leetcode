class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(int[] arr, int target, int sum,
                            List<List<Integer>> ans, List<Integer> curr, int index) {
        
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (sum + arr[i] > target) 
                continue;

            curr.add(arr[i]);
            backtrack(arr, target, sum + arr[i], ans, curr, i);
            curr.remove(curr.size() - 1);
        }
    }
}
