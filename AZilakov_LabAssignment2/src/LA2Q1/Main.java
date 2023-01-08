package LA2Q1;
import java.util.Random;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        header(2,1);
        long startTime;// = System.nanoTime();
        long endTime;// = System.nanoTime();
        int sz = 5;
        Integer [] arr = new Integer[sz];
        Integer [] copyArr = new Integer[sz];
        //populate array
        for(int i=0; i<arr.length;i++){
            arr[i] = (int)((Math.random() * 80) + 13);
        }
        System.arraycopy(arr,0,copyArr,0,sz);//create copy array
        List<Integer> listArr = Arrays.asList(arr);
        //Sort and print both arrays and the time it takes for collections to sort them
        System.out.println("The unsorted list: " + listArr);
        startTime = System.nanoTime();
        Collections.sort(listArr);
        endTime=System.nanoTime();
        System.out.println("Collections' Sorting Time: "+(endTime-startTime));
        System.out.println("The sorted list array: " + listArr);
        //listArr = Arrays.asList(copyArr);//reset list

        AugustsTestingSortingMethods sort = new AugustsTestingSortingMethods();//create sorting object

        //call each sort method and then reset the array
        System.out.println("It took selection sort: " + sort.selectionSort(arr));
        System.out.println("selection sort sorted array: "+Arrays.asList(arr));

        System.arraycopy(copyArr,0,arr,0,sz);


        System.out.println("It took bubble sort: " + sort.bubbleSort(arr));
        System.out.println("Bubble sort sorted array: "+Arrays.asList(arr));

        System.arraycopy(copyArr,0,arr,0,sz);

        System.out.println("It took Insertion sort: " + sort.insertionSort(arr));
        System.out.println("Insertion sort sorted array: "+Arrays.asList(arr));

        System.arraycopy(copyArr,0,arr,0,sz);

        System.out.println("It took merge sort: " + sort.mergeSort(arr));
        System.out.println("Merge sort sorted array: "+Arrays.asList(arr));

        System.arraycopy(copyArr,0,arr,0,sz);

        System.out.println("It took quick sort: " + sort.quickSort(arr,0,sz-1));
        System.out.println("quick sort sorted array: "+Arrays.asList(arr));

        System.arraycopy(copyArr,0,arr,0,sz);

        System.out.println("It took bucket sort: " + sort.bucketSort(arr,0,sz-1,sz));
        System.out.println("bucket sort sorted array: "+Arrays.asList(arr));

        System.arraycopy(copyArr,0,arr,0,sz);
        footer(2,1);

    }
    public static void footer(int x, int q){//footer
        System.out.printf("%15s%n","=========================================================");
        System.out.println("Completion of Lab Assignment " + x + ", "+q+" is successful!\nSigning off - Augusts.");
        System.out.printf("%15s%n","=========================================================");
    }
    public static void header(int x, int q){//header
        System.out.printf("%15s%n","=========================================================");
        System.out.println("Lab Exercise " + x+ " "+q);
        System.out.println("Prepared By: Augusts Zilakovs" +
                "\nStudent Number: 251223010" +
                "\nGoal of this Exercise: Implement various sorting algorithms and implement insertion sort to a real life problem. ");
        System.out.printf("%15s%n","=========================================================");
    }
}
