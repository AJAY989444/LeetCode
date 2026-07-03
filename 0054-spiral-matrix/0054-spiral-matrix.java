class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int minr = 0;
        int maxr = matrix.length - 1;
        int minc = 0;
        int maxc = matrix[0].length - 1;

        int total = matrix.length * matrix[0].length;
        int count = 0;

        while (count < total) {

            // Top row
            for (int j = minc; j <= maxc; j++) {
                ans.add(matrix[minr][j]);
                count++;
            }
            minr++;

            // Right column
            for (int i = minr; i <= maxr; i++) {
                ans.add(matrix[i][maxc]);
                count++;
            }
            maxc--;

            // Bottom row
        for (int j = maxc; j >= minc && count < total; j--) {
            ans.add(matrix[maxr][j]);
            count++;
            }
             maxr--;

            // Left column
        for (int i = maxr; i >= minr && count < total; i--) {
             ans.add(matrix[i][minc]);
              count++;
            }
               minc++;
        }

        return ans;
    }
}