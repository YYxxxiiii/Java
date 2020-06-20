package java_0620;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void fun(int[] arr,int[] left,int[] right){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length ; i++){
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty() && arr[i] == arr[stack.peek()]){
                left[i] = left[stack.peek()];
            }else {
                left[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            right[stack.pop()] = -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        fun(arr,left,right);
        for (int i = 0; i < n; i++) {
            System.out.println(left[i] + " " + right[i]);
        }
    }
}




//import java.util.*;
//public class Main{
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = sc.nextInt();
//        }
//        int[] L = new int[n];
//        int[] R = new int[n];
//        getResult(arr, L, R);
//        for (int i = 0; i < n; i++){
//            System.out.println(L[i] +" " +R[i]);
//        }
//    }
//    private static void getResult(int[] arr, int[] L, int[] R){
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < arr.length ; i++){
//            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
//                R[stack.pop()] = i;
//            }
//            if (!stack.isEmpty() && arr[i] == arr[stack.peek()]){
//                L[i] = L[stack.peek()];
//            }else {
//                L[i] = stack.isEmpty() ? -1 : stack.peek();
//            }
//            stack.push(i);
//        }
//        while (!stack.isEmpty()){
//            R[stack.pop()] = -1;
//        }
//    }
//}