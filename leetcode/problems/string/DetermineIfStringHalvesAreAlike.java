package string;

public class DetermineIfStringHalvesAreAlike {
    /*
    Auxiliary memory o(10)
    Time complexity o(n)
    Two pointer
     */
    public boolean halvesAreAlike(String s) {
        Set<Character> set = Set.of('a','e','i','o','u','A','E','I','O','U');
        int i=0;
        int j=s.length()-1;
        int leftOwel=0;
        int rightOwel=0;
        while(i < j){
            if(set.contains(s.charAt(i)))
                leftOwel++;
            if(set.contains(s.charAt(j)))
                rightOwel++;

            i++;
            j--;
        }

        return leftOwel==rightOwel;
    }
}
