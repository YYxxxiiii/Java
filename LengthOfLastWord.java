package leetcode;


public class LengthOfLastWord {
    public int lengthOfLastWord1(String s) {
        String[] str = s.split(" ");
        if (str.length == 0) {
            return 0;
        }
        return str[str.length - 1].length();
    }

    /**
     * 下面这个没有用API
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if(count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}
