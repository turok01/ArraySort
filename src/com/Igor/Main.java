package com.Igor;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static void bubbleArraySort(ArrayList<Integer> arrayToSort){
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
    static void bulbArraySort(ArrayList<Integer> arrayToSort){
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
    static void shakeArraySort(ArrayList<Integer> arrayToSort) {
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
    static void combArraySort(ArrayList<Integer> arrayToSort){
        int temp;
        float shrink = 1.247f;
        int gap = arrayToSort.size();
        boolean sorted = false;
        while(!sorted){
            gap /= shrink;
            if (gap<1) {
                gap = 1;
                sorted = true;
            }
            for(int j = 0; j<arrayToSort.size()-gap; j++){
                if(arrayToSort.get(j)>arrayToSort.get(j+gap)){
                    temp = arrayToSort.get(j);
                    arrayToSort.set(j,arrayToSort.get(j+gap));
                    arrayToSort.set(j+gap,temp);
                    sorted = false;
                }
            }
        }
    }
    static void combIntSort(int[] arrayToSort){
        int temp;
        float shrink = 1.247f;
        int gap = arrayToSort.length;
        boolean sorted = false;
        while(!sorted){
            gap /= shrink;
            if (gap<1) {
                gap = 1;
                sorted = true;
            }
            for(int j = 0; j<arrayToSort.length-gap; j++){
                if(arrayToSort[j]>arrayToSort[j+gap]){
                    temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j+gap];
                    arrayToSort[j+gap] = temp;
                    sorted = false;
                }
            }
        }
    }
    static void combIntegerSort(Integer[] arrayToSort){
        Integer temp;
        float shrink = 1.247f;
        int gap = arrayToSort.length;
        boolean sorted = false;
        while(!sorted){
            gap /= shrink;
            if (gap<1) {
                gap = 1;
                sorted = true;
            }
            for(int j = 0; j<arrayToSort.length-gap; j++){
                if(arrayToSort[j]>arrayToSort[j+gap]){
                    temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j+gap];
                    arrayToSort[j+gap] = temp;
                    sorted = false;
                }
            }
        }
    }
    static void mergeArraySort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        int mid = (left + right) / 2;
        mergeArraySort(array, left, mid);
        mergeArraySort(array,mid+1, right);
        merge(array, left, mid, right);
    }
    static void merge(int[] array, int left, int mid, int right){
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        int[] leftArray = new int[lengthLeft];
        int[] rightArray = new int[lengthRight];

        for (int i = 0; i < lengthLeft; i++){
            leftArray[i] = array[i + left];
        }
        for (int i = 0; i < lengthRight; i++){
            rightArray[i] = array[mid + i + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = left; i < right + 1; i++){
            //if left and right part of array both have items
            if(leftIndex < lengthLeft && rightIndex < lengthRight){
                if(leftArray[leftIndex] < rightArray[rightIndex]){
                    array[i] = leftArray[leftIndex++];
                }
                else{
                    array[i] = rightArray[rightIndex++];
                }
            }
            else
                //copy what's left in left xor right part of array
                if (leftIndex < lengthLeft)
                    array[i] = leftArray[leftIndex++];
                else
                    if (rightIndex < lengthRight)
                        array[i] = rightArray[rightIndex++];
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
        System.out.println("b - bubble; u - bulb while not true sorted; h - shake; c - comb; m - merge int;");
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
                bubbleArraySort(arraySorting);
                break;
            case "u":
            case "U":
                bulbArraySort(arraySorting);
                break;
            case "h":
            case "H":
                shakeArraySort(arraySorting);
                break;
            case "c":
            case "C":
                combArraySort(arraySorting);
                break;
            case "m":
            case "M":
                int[] arrayMergeInt = new int[arraySize];
                for(int i=0;i<arrayToSort.size();i++)
                    arrayMergeInt[i]=arrayToSort.get(i);
                time = System.currentTimeMillis();
                mergeArraySort(arrayMergeInt,0,arrayMergeInt.length-1);
                break;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time is " + (endTime - time));
        //Testing collections.sort sorting
        ArrayList<Integer> arraySorting2 = new ArrayList<Integer>(arrayToSort);
        time = System.currentTimeMillis();
        arraySorting2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });
        endTime = System.currentTimeMillis();
        System.out.println("Time .sort is " + (endTime - time));
        //Test comb sort of primitive int

        int[] arrayInt = new int[arraySize];
        for(int i=0;i<arrayToSort.size();i++)
            arrayInt[i]=arrayToSort.get(i);
        time = System.currentTimeMillis();
        combIntSort(arrayInt);
        endTime = System.currentTimeMillis();
        System.out.println("Time comb sort of primitive int is " + (endTime - time));

        int[] arrayIntDotSort = new int[arraySize];
        for(int i=0;i<arrayToSort.size();i++)
            arrayIntDotSort[i]=arrayToSort.get(i);
        time = System.currentTimeMillis();
        Arrays.sort(arrayIntDotSort);
        endTime = System.currentTimeMillis();
        System.out.println("Time .sort of primitive int is " + (endTime - time));

        /*for(int i:arrayInt)
            System.out.print(i + " ");

         */

        //Object[] arrayInteger = new Integer[arraySize];
        //arrayInteger = arrayToSort.toArray();
        Integer[] arrayInteger = new Integer[arraySize];
        arrayInteger = arrayToSort.toArray(arrayInteger);
        time = System.currentTimeMillis();
        combIntegerSort(arrayInteger);
        endTime = System.currentTimeMillis();
        System.out.println("Time comb sort of Integer is " + (endTime - time));


        /*for(int i:arraySorting)
            System.out.print(i + " ");
         */

        //arrayToSort.forEach(System.out::print);
        //arrayToSort.forEach(value -> System.out.print(value + " "));

    }
}
