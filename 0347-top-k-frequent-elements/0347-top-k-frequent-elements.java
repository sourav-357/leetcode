class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                res.add(new int[]{nums[i-1], count});
                count = 1;
            } else {
                count++;
            }
        }
        res.add(new int[]{nums[nums.length - 1], count});

        res.sort((a,b) -> b[1] - a[1]);

        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = res.get(i)[0];
        }
        return ans;
    }
}