package note.slidingwindow;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /*
    Time complexity o(n)
    Space complexity o(n)
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count=0;
        int maxLength=0;
        int start=-1;

        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i)) && start < map.get(s.charAt(i))){
                if(maxLength < count)
                    maxLength = count;
                count = i-map.get(s.charAt(i));
                start = map.get(s.charAt(i));
                map.put(s.charAt(i),i);
            }else{
                count++;
                map.put(s.charAt(i),i);
            }
        }
        if(count > maxLength)
            maxLength = count;

        return maxLength;
    }
}
