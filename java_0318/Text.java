package java_0318;

public class Text{
    public static void main(String[] args){
//        String str = "name=zhangsan&age=18";
//        String[] ret = str.split("&");
//        for (String tmp : ret) {
//            String[] token = tmp.split("=");
//            if (token.length != 2) {  //为了刨除格式错误的情况,比如 name=1=2 这种
//                continue;
//            }
//            System.out.println(token[0] + ":" + token[1]);
//        }

//        String str = "hEllo";
//        String ret = str.substring(0,1).toUpperCase()+str.substring(1).toLowerCase();
//        System.out.println(ret);

//        StringBuffer stringBuffer = new StringBuffer("abcd");
//        stringBuffer.reverse();
//        System.out.println(stringBuffer);

        StringBuffer stringBuffer = new StringBuffer("abcd");
        stringBuffer.insert(2,"e");
        System.out.println(stringBuffer);
    }
}

