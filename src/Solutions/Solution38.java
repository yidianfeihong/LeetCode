package Solutions;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution38 {

    public static void main(String[] args) {

        System.out.println(new Solution38().translate("1211"));


    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return translate(countAndSay(n - 1));
        }
    }

    String getCount(int n) {
        String[] strings = new String[31];
        strings[1] = "1";
        for (int i = 2; i <= n; i++) {
            String ts = strings[i - 1], rs = "";
            char tc = ts.charAt(0);
            int cnt = 0;
            for (char c : ts.toCharArray()) {
                if (c == tc) {
                    cnt++;
                } else {
                    rs = rs + cnt + tc;
                    tc = c;
                    cnt = 1;
                }
            }
            rs = rs + cnt + tc;
            strings[i] = rs;
        }
        return strings[n];
    }

    String translate(String str) {
        StringBuilder sb = new StringBuilder();
        char cus = str.charAt(0);
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == cus) {
                count++;
            } else {
                sb.append(count + "" + cus);
                cus = c;
                count = 1;
            }
        }
        sb.append(count + "" + cus);
        return sb.toString();
    }
}
