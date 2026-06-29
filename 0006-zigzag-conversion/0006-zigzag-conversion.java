class Solution {
    public String convert(String s, int numRows) {
        String[] ans = new String[numRows];

        for(int i = 0; i < ans.length; i++) {
            ans[i] = "";
        }

        int i = 0;
        while(i < s.length()) {
            // Up to down loop

            for(int idx = 0; idx < numRows && i < s.length() ; idx++) {
                ans[idx] += s.charAt(i++); 
            } 

            // down to diagonal UP

            for(int idx = numRows - 2; idx > 0 && i < s.length(); idx--)  {
                ans[idx] += s.charAt(i++); 
            }
        }

        String res = "";
        for(String str : ans) {
            res += str;
        }

        return res;
    }
}