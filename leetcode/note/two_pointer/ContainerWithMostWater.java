package two_pointer;

class ContainerWithMostWater {
    /*
    Two pointer
    Time complexity o(n)
    Space complexity o(1)
     */
    public int maxArea(int[] height) {
        int maxArea=0;
        int left = 0;
        int right = height.length-1;

        while(left < right){
            maxArea = Math.max(Math.min(height[left],height[right])*(right-left),maxArea);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}