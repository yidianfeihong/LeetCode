package solutions;

public class Solution5 {


    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome1("baab"));
    }


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dpi = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dpi[i][i] = true;
        }
        int start = 0;
        int maxLen = 1;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dpi[i][j] = true;
                    } else {
                        dpi[i][j] = dpi[i + 1][j - 1];
                    }
                } else {
                    dpi[i][j] = false;
                }
                if (dpi[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

}
