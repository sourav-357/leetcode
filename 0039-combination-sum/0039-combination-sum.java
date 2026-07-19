class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int index, int[] arr, int target, int sum, 
                            List<Integer> curr, List<List<Integer>> res) {
        
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (sum + arr[i] > target) continue;

            curr.add(arr[i]);
            backtrack(i, arr, target, sum + arr[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}