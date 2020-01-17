package Java_0117;

class Solution {
    public String toLowerCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result += ch;
        }
        return result;
    }
}

