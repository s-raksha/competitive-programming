package string;

/*
https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInteger {

    /*
    Time complexity o(n)
    space complexity o(7);
     */
    public int romanToInt(String s) {
        int result = 0, num = 0, prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case ('I'):
                    num = 1;
                    break;
                case ('V'):
                    num = 5;
                    break;
                case ('X'):
                    num = 10;
                    break;
                case ('L'):
                    num = 50;
                    break;
                case ('C'):
                    num = 100;
                    break;
                case ('D'):
                    num = 500;
                    break;
                case ('M'):
                    num = 1000;
                    break;
            }
            if (num < prev)
                result -= num;
            else
                result += num;

            prev = num;
        }
        return result;
    }

    /*
    Time complexity o(n)
    space complexity o(7);
    HashMap
     */
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int i = 0;
        for (i = s.length() - 1; i >= 1; i--) {
            if ((s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i - 1) == 'I') {
                result += romanMap.get(s.charAt(i)) - 1;
                i--;
            } else if ((s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i - 1) == 'X') {
                result += romanMap.get(s.charAt(i)) - 10;
                i--;
            } else if ((s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i - 1) == 'C') {
                result += romanMap.get(s.charAt(i)) - 100;
                i--;
            } else
                result += romanMap.get(s.charAt(i));
        }

        if (i == 0)
            result += romanMap.get(s.charAt(i));

        return result;
    }

    /*
    Time complexity o(n)
    space complexity o(7);
    HashMap
     */

    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int i = 0;
        for (i = 0; i < s.length() - 1; i++) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                result += (romanMap.get(s.charAt(i + 1)) - romanMap.get(s.charAt(i)));
                i++;
            } else
                result += (romanMap.get(s.charAt(i)));
        }

        if (i == s.length() - 1)
            result += (romanMap.get(s.charAt(i)));

        return result;
    }

    /*
    Time complexity o(n)
    space complexity o(7);
     */
    public int romanToInt(String s) {
        int result = 0, num = 0, prev = 1001;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ('I'):
                    num = 1;
                    break;
                case ('V'):
                    num = 5;
                    break;
                case ('X'):
                    num = 10;
                    break;
                case ('L'):
                    num = 50;
                    break;
                case ('C'):
                    num = 100;
                    break;
                case ('D'):
                    num = 500;
                    break;
                case ('M'):
                    num = 1000;
                    break;
            }
            if (num > prev)
                result += (num - 2 * prev);
            else
                result += num;

            prev = num;
        }
        return result;
    }

}
