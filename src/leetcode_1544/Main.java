package leetcode_1544;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String makeGood(String s) {
        StringBuffer ret = new StringBuffer();
        int retIndex = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ret.length() > 0 && Character.toLowerCase(ret.charAt(retIndex)) == Character.toLowerCase(ch) && ret.charAt(retIndex) != ch) {
                ret.deleteCharAt(retIndex);
                retIndex--;
            } else {
                ret.append(ch);
                retIndex++;
            }
        }
        return ret.toString();
    }
}