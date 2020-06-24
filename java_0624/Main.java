package java_0624;

import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int stuNum = scanner.nextInt();
            int ascOrDesc = scanner.nextInt();
            LinkedList<String>[] numAndNameList = new LinkedList[101];
            for(int i = 0 ; i < stuNum; i++){
                String name = scanner.next();
                int scoreNum = scanner.nextInt();
                if (numAndNameList[scoreNum] == null) {
                    numAndNameList[scoreNum] = new LinkedList<>();
                }
                numAndNameList[scoreNum].addLast(name);
            }
            if (ascOrDesc == 1) {
                for (int i = 0; i <= 100; i++) {
                    if (numAndNameList[i] != null) {
                        while (!numAndNameList[i].isEmpty()) {
                            System.out.println(numAndNameList[i].pollFirst() + " " + i);
                        }
                    }
                }
            } else {
                for (int i = 100; i >= 0; i--) {
                    if (numAndNameList[i] != null) {
                        while (!numAndNameList[i].isEmpty()) {
                            System.out.println(numAndNameList[i].pollFirst() + " " + i);
                        }
                    }
                }
            }
        }
    }
}
