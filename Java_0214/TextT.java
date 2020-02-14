package Java_0214;

public class TextT {
    //    public static void main(String args[]) {
//        int i = 7;
//        do {
//            System.out.println(--i);
//            --i;
//        } while (i != 0);
//        System.out.println(i);
//    }
    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getValue(2));
    }
}

//    if (magazine.length() < ransomNote.length()){
//        return false;
//    }
//    int caps[] = new int[26];
//        for (char c : ransomNote.toCharArray()) {
//        int index = magazine.indexOf(c, caps[c - 'a']);
//        if (index == -1){
//            return false;
//        }
//        caps[c - 97] = index + 1;
//    }
//        return true;
//}



//    int theNum = x;
//        if(x == 0){
//                return true;
//                }
//                if(x < 0 || (x % 10 ) == 0){
//        return false;
//        }
//        int temp = 0;
//        while(x > 0){
//        temp = temp * 10 + (x % 10);
//        x /= 10;
//        }
//        return theNum == temp ? true : false;
