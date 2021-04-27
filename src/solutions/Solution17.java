package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution17 {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        HashMap<Character, String> map = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        StringBuilder output = new StringBuilder();
        backtrace(0, digits, ans, map, output);
        return ans;
    }

    private void backtrace(int cur, String digits, List<String> ans, HashMap<Character, String> map, StringBuilder output) {
        if (cur == digits.length()) {
            ans.add(output.toString());
            return;
        }
        char num = digits.charAt(cur);
        String s = map.get(num);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            output.append(c);
            backtrace(cur + 1, digits, ans, map, output);
            output.deleteCharAt(cur);
        }
    }
}
