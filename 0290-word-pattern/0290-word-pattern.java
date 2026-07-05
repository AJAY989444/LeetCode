class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length) {
            return false;
        }


        HashMap<Character,String> map = new HashMap<>();   

        for(int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(arr[i])) {
                return false;
            }

            if(map.containsValue(arr[i]) && !map.containsKey(pattern.charAt(i))) {
                return false;
            }

            else {
                map.put(pattern.charAt(i),arr[i]);
            }
        }

        return true;

    }
}