package com.Igor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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
    static void BulbArraySort(ArrayList<Integer> arrayToSort){
        int temp;
        boolean sorted = false;

        while(!sorted){
            sorted = true;
            for(int j = 0; j<arrayToSort.size()-1; j++){
                if(arrayToSort.get(j)>arrayToSort.get(j+1)){
                    temp = arrayToSort.get(j);
                    arrayToSort.set(j,arrayToSort.get(j+1));
                    arrayToSort.set(j+1,temp);
                    sorted = false;
                }
            }
        }

    }
    static void ShakeArraySort(ArrayList<Integer> arrayToSort) {
        int temp;
        boolean sorted = false;
        int i = 0;
        while(!sorted) {
            sorted = true;
            for (int j = 0; j < arrayToSort.size() - i - 1; j++) {
                if (arrayToSort.get(j) > arrayToSort.get(j + 1)) {
                    temp = arrayToSort.get(j);
                    arrayToSort.set(j, arrayToSort.get(j + 1));
                    arrayToSort.set(j + 1, temp);
                    sorted = false;
                }
            }
            for (int j = arrayToSort.size() - i - 2; j > 0; j--) {
                if (arrayToSort.get(j) < arrayToSort.get(j - 1)) {
                    temp = arrayToSort.get(j);
                    arrayToSort.set(j, arrayToSort.get(j - 1));
                    arrayToSort.set(j - 1, temp);
                    sorted = false;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
	// write your code here
        int arraySize;
        ArrayList<Integer> arrayToSort, arraySorting;
        Scanner scan = new Scanner(System.in);
        //While()
        System.out.println("Input size of array:");
        arraySize = Integer.parseInt(scan.nextLine());
        System.out.println("Select type of array sorting:");
        System.out.println("b - bubble; u - bulb while not true sorted; h - shake;");
        String sort = scan.nextLine();
        /*System.out.println("Input array:");
        String [] input = scan.nextLine().split(" ");
        for(String s:input)
            arrayToSort.add(Integer.parseInt(s));

         */
        Random r = new Random();
        arrayToSort  = new ArrayList<Integer>(arraySize);
        for (int i=0; i<arraySize;i++) {
            arrayToSort.add(r.nextInt(10000));
        }
        scan.close();
        arraySorting = new ArrayList<Integer>(arrayToSort);

        long time = System.currentTimeMillis();
        switch (sort){
            case "b":
            case "B":
                BubbleArraySort(arraySorting);
                break;
            case "u":
            case "U":
                BulbArraySort(arraySorting);
                break;
            case "h":
            case "H":
                ShakeArraySort(arraySorting);
                break;

        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time is " + (endTime - time));


        /*for(int i:arraySorting)
            System.out.print(i + " ");
         */

        //arrayToSort.forEach(System.out::print);
        //arrayToSort.forEach(value -> System.out.print(value + " "));

    }
}
