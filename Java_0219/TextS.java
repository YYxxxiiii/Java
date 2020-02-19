package Java_0219;

public class TextS {
//    public static int lengthOfLastWord(String s) {
//
//        if (s == null || s.length() == 0 || " ".equals(s)) {
//            return 0;
//        }
//
//        String[] sA = s.split(" ");
//        if (sA.length == 0) {
//            return 0;
//        }
//        return sA[sA.length - 1].length();
//    } //58
//
//
//    public static int length(String s) {
//        int end = s.length() - 1;
//        while (end >= 0 && s.charAt(end) == ' ') {
//            end--;
//        }
//        if (end < 0) {
//            return 0;
//        }
//        int start = end;
//        while (start >= 0 && s.charAt(start) != ' ') {
//            start--;
//        }
//        return end - start;
//    }//biaodashangde

    String str=new String("hello");
    char[]ch={'a','b'};
    public static void main(String args[]){
        TextS ex=new TextS();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);
    } public void change(String str,char ch[]){
        str="test ok";
        ch[0]='c';
    }
}
