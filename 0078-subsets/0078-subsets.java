class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(ans, curr, 0, nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> curr, int index, int[] nums) {
        ans.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(ans, curr, i+1, nums);
            curr.remove(curr.size() - 1);
        }
    }
}