package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution118 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution118().generate(1);
        System.out.println(lists);
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int len = i + 1;
            for (int j = 0; j < len; j++) {
                if (j == 0 || j == len - 1) {
                    list.add(1);
                } else {
                    List<Integer> lastList = lists.get(i - 1);
                    int res = lastList.get(j - 1) + lastList.get(j);
                    list.add(res);
                }
            }
            lists.add(list);
        }
        return lists;
    }

}
