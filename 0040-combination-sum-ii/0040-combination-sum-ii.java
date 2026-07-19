class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

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
            if (i > index && arr[i] == arr[i-1])
                continue;
                
            if (sum + arr[i] > target) 
                continue;

            curr.add(arr[i]);
            backtrack(i + 1, arr, target, sum + arr[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}