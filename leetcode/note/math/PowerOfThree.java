package math;
/*
https://leetcode.com/problems/power-of-three/description/
 */
public class PowerOfThree {

    /*
    Recursion
    Time complexity O(n)
    Space complexity O(n) stack
     */
    public boolean isPowerOfThree(int n) {
        if(n==0)
            return false;
        if(n==1)
            return true;
        if(n%3 != 0)
            return false;
        return isPowerOfThree(n/3);
    }

    /*
    using loop
    Time complexity O(n)
    Space complexity O(1)
     */
    public boolean isPowerOfThree(int n) {
        if (n==0)
            return false;
        while(n%3 == 0){
            n = n/3;
        }
        return n==1;
    }

    /*
    Math log function
    Time complexity O(1)
    space complexity O(1)
     */
    public boolean isPowerOfThree(int n) {
        if(n==0)
            return false;
        return (Math.log10(n) / Math.log10(3))%1 == 0 ;
    }

    /*
    3^19 1162261467 - is the largest possible integer
    time complexity 0(1)
    space complexity 0(1)
     */
    public boolean isPowerOfThree(int n) {
        return n>0 && 1162261467%n == 0;
    }
}
