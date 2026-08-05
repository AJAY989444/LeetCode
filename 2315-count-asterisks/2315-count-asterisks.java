class Solution {
    public int countAsterisks(String s) {
        int bars = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '|') {
                bars++;
            } else if (c == '*' && bars % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}