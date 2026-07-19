class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(used, ans, new ArrayList<>(), nums);
        return ans;
    }

    private void backtrack(boolean[] used, List<List<Integer>> ans, List<Integer> curr, int[] nums) {

        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if (used[i]) 
                continue;

            curr.add(nums[i]);
            used[i] = true;

            backtrack(used, ans, curr, nums);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}