class Solution {
    public String[] findRelativeRanks(int[] score) {
        int max = max(score);
        int[] map = new int[max + 1];

        for(int i = 0; i < score.length; i++) {
            map[score[i]] = i + 1; // To avoid confusion between zeroth idx and 0 value 
        }

        String[] ans = new String[score.length];
        int rank = 1;

        for(int i = max; i >= 0; i--) {
            if(map[i] != 0) {

                int originalIdx = map[i] - 1; 

                if(rank == 1) {
                    ans[originalIdx] = "Gold Medal";
                } else if(rank == 2) {
                    ans[originalIdx] = "Silver Medal";
                } else if(rank == 3) {
                    ans[originalIdx] = "Bronze Medal";
                }else {
                    ans[originalIdx] = Integer.toString(rank);
                }

                rank++;
            }

            if(rank > score.length) {
                break;
            }
        }
        return ans;

    }

    int max(int[] arr) {
        int maxval = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            maxval = Math.max(maxval,arr[i]);
        }
        return maxval;
    }
}