package LA2Q1;

import java.util.Arrays;
import java.util.Vector;

public class AugustsTestingSortingMethods {

   public static <T extends Comparable <? super T>>long selectionSort (T [] a){
       long startTime = System.nanoTime();
       //move boundary
        for(int i=0; i<a.length-1;i++){
            //find min element
            int min = i;
            for(int j = i+1; j<a.length; j++){
                if(a[j].compareTo(a[min])<0){//change < sign here
                    min = j;
                }
            }
            //swap min element with element
            T temp = a[min];
            a[min] = a[i];
            a[i]=temp;
        }
        return (System.nanoTime() - startTime);
    }
    public static < T extends Comparable <? super T >> long bubbleSort(T[] a){
        long startTime = System.nanoTime();
        for(int i =1;i<a.length;i++){
            for(int z=0;z<a.length - i; z++){//time complexity O(n2)`
                //swap a[j+1] and a[j]
                if(a[z].compareTo(a[z+1])>0){
                    T temp =a[z];
                    a[z]=a[z+1];
                    a[z+1]=temp;
                }
            }
        }
        return (System.nanoTime()-startTime);
    }
    public static < T extends Comparable <? super T >> long insertionSort(T[] a){
        long startTime = System.nanoTime();
        for(int i =1;i<a.length;++i){
            T key = a[i];
            int j = i-1;
            while(j>=0&&a[j].compareTo(key)>0){//compare name originally at i to all j's to check where it sorts
                //swap elements
                a[j+1] = a[j];
                j=j-1;
            }
            a[j+1]=key;
        }
        return (System.nanoTime()-startTime);
    }
    public static <T extends Comparable<? super T>> long mergeSort(T[] S){
        long startTime = System.nanoTime();
        int mid = S.length/2;//find middle point
        if(S.length<2) return 0;//base case, stop recursion when array length cant be divided
        //divide
        T[] S1 = Arrays.copyOfRange(S, 0 , mid);//recursion, split into two more leafs
        T[] S2 = Arrays.copyOfRange(S, mid, S.length);
        //conquer
        mergeSort(S1);
        mergeSort(S2);

        int i=0, j =0;
        while(i+j<S.length){
            if(j == S2.length || (i<S1.length && S1[i].compareTo(S2[j]) <0)){//sort the smaller parts
                S[i+j] = S1[i++];
            }else{
                S[i+j] = S2[j++];
            }
        }
        return (System.nanoTime() - startTime);
    }

    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b) {
       long startTime = System.nanoTime();

       if(a<b){
            int pi=partition(s,a,b);//create pivot
           //sort elements separately as long as the array can be split
            quickSort(s,a,pi-1);
            quickSort(s,pi+1,b);
        }
       return (System.nanoTime()-startTime);
    }
//    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b){
//        long startTime = System.nanoTime();
//        //check base case, if base case hit then sorting is finished
//        if(a>=b){
//            return (System.nanoTime()-startTime);
//        }
//        //
//        T p = s[b];//pivot point
//        int l=a;//left pointer
//        int r=b;//right pointer
//        while(l<=r) {
//            while (l <= r && s[l].compareTo(p) > 0) {//find element larger than pivot
//                l = l + 1;
//            }
//            while (l <= r && s[r].compareTo(p) < 0) {//find element smaller than pivot
//                r = r - 1;
//            }
//            if(l<r){ //swap
//                T temp = s[l];
//                s[l]=s[r];
//                s[r]=temp;
//                l=l+1;
//                r=r-1;
//            }
//        }
//        T temp = s[l];//change pivot location to final location
//        s[l]=s[b];
//        s[b]=temp;
//        quickSort(s,a,l-1);//recursion call
//        quickSort(s,l+1,b);//recursion call
//        return (System.nanoTime() - startTime); //idk why its here, has to return something.
//    }

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        long startTime = System.nanoTime();
        //create 10 buckets
        Vector<Integer>[] bucket = new Vector[10];
        //create a vector for every bucket to store numbers
        for (int i = 0; i < 10; i++) {
            bucket[i] = new Vector<>();
        }
        for (int i = 0; i < maxDigits; i++) {
            //Clear buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }

            for(int in = first; in<=last; in++){
                Integer digit = findDigit(a[in],i);//divide number and put into correct bucket
                bucket[digit].add(a[in]);
            }
            int index = 0;
            //rearrange array to most recent sort iteration
            for(int m=0;m<10;m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        return (System.nanoTime()-startTime);
    }
    public static Integer findDigit(int number, int i){
       int target = 0;
       for(int k=0;k<=i;k++){//divide the number
           target = number%10;
           number = number/10;
        }
       return target;
    }
    static <T extends Comparable> int partition(T[] a, int l, int h){
       T pivot = a[h];//create pivot at last element
       int i =(l-1);
       for(int j=l;j<=h-1;j++){
           //if the current element is smaller than the pivot
           if(a[j].compareTo(pivot)<0){
               i++;swap(a,i,j);//increment index of smaller element and swap putting smaller elements to the right of pivot
           }
       }
       swap(a,i+1,h);
       return(i+1);
    }
    //Swap values for quick sort.
    static void swap(Object [] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
//    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){
//       long startTime = System.nanoTime();
//       Vector<Integer>[] bucket = new Vector[10];
//       for(int i = 0; i<10;i++){
//           bucket[i]= new Vector<>();
//       }
//       for(int i = 0;i<maxDigits;i++){
//           for(int j=0;j<10;j++){
//               bucket[j].removeAllElements();
//           }
//           for(int in = first; in<=last; in++){
//               int target =0;
//               for(int k =0; k<=i;k++){
//                   target = a[in]%10;
//                   a[in] = a[in]/10;
//               }
//               bucket[target].add(a[in]);
//           }
//           int index = 0;
//           for(int m=0 ;m<10;m++){
//               for(int n=0;n<bucket[m].size();n++){
//                   a[index++] = bucket[m].get(n);
//               }
//           }
//       }
//       return (System.nanoTime()-startTime);
//    }
}
