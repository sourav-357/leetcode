class Solution {
    int maxReach = 0;
    int curridx = 0;

    public boolean canJump(int[] nums) {
        
        if (curridx > maxReach)
            return false;
        if (maxReach >= nums.length - 1)
            return true;
        
        maxReach = Math.max(maxReach, curridx + nums[curridx]);
        curridx++;
        return canJump(nums);
    }
}