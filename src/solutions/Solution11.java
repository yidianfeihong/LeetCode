package solutions;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution11 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, area);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

}
