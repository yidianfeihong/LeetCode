package Solutions;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution171 {

    public static void main(String[] args) {

        System.out.println(new Solution171().titleToNumber("BA"));
    }

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int k = 1;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) + 1 - 'A') * k;
            k = k * 26;
        }
        return res;
    }

}
