class Solution {
    public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ll = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i]) + 1);
            } else {
                map.put(nums[i],1);
            }
        }

        for(int i = 0; i < nums.length; i++) { // Navigating on array Not map
            if(map.get(nums[i]) > nums.length / 3 && !ll.contains(nums[i])) {
                ll.add(nums[i]);
            }
        }
        return ll;
    }
}