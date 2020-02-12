package com.Igor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static void BubbleArraySort(ArrayList<Integer> arrayToSort){
        int temp;
        for(int i = 0; i<arrayToSort.size()-1; i++){
            for(int j=0; j<arrayToSort.size()-i-1;j++){
                if(arrayToSort.get(j)>arrayToSort.get(j+1)){
                    temp = arrayToSort.get(j);
                    arrayToSort.set(j,arrayToSort.get(j+1));
                    arrayToSort.set(j+1,temp);
                }
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
        ArrayList<Integer> arrayToSort = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Select type of array sorting:");
        System.out.println("b - bubble;");
        System.out.println("Input array:");
        String sort = scan.nextLine();

        String [] input = scan.nextLine().split(" ");
        for(String s:input)
            arrayToSort.add(Integer.parseInt(s));
        scan.close();
        switch (sort){
            case "b":
            case "B":
                BubbleArraySort(arrayToSort);
                break;

        }


        for(int i:arrayToSort)
            System.out.print(i + " ");
        //arrayToSort.forEach(System.out::print);
        //arrayToSort.forEach(value -> System.out.print(value + " "));

    }
}
