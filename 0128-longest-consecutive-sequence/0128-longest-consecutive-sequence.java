class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i  = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]) && !set.contains(nums[i] - 1) ) {
                int count = 0;
                while(set.contains(nums[i])) {
                    count++;
                    set.remove(nums[i]);
                    nums[i]++;
                }

                ans = Math.max(ans,count);
            }
        }

        return ans;
    }
}