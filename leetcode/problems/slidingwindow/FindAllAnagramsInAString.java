package slidingwindow;

/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class FindAllAnagramsInAString {
    /*
    HashTable to check if two strings are anagram
    Time complexity - o(26*n) - o(n)
    Space complexity -o(26)*2 - o(26)
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] alphaS = new int[26];
        int[] alphaP = new int[26];
        int r=0;
        int l=0;

        if(s.length() < p.length())
            return result;

        for(char p1:p.toCharArray()){
            alphaP[p1 - 'a']++;
        }

        // window creation
        for( r=0; r<p.length()-1; r++){
            alphaS[s.charAt(r) - 'a']++;
        }

        while(r < s.length()){
            alphaS[s.charAt(r) - 'a']++;
            if(Arrays.equals(alphaS,alphaP))
                result.add(l);
            alphaS[s.charAt(l) - 'a']--;
            l++;
            r++;
        }

        return result;
    }
}
