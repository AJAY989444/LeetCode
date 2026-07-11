class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            String key = Anagram(arr[i]);
            if(!map.containsKey(key)) {
                map.put(key,new ArrayList<>());
            } 
            map.get(key).add(arr[i]);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    public static String Anagram(String str) {
        int[] freq = new int[26];
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < freq.length; i++) {
            sb.append(freq[i] + " ");
        }

        return sb.toString();
    }
}