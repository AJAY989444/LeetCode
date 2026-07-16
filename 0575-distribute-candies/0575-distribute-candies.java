class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < candyType.length; i++) {
            if(!set.contains(candyType[i])) {
                set.add(candyType[i]);
            }
        }

        int total = candyType.length / 2;
        int ans = 0;
        for(int key : set) {
            total = total - 1;
            ans = ans + 1;
            if(total <= 0) {
                return ans;
            }
        }
        return ans;
    }
}