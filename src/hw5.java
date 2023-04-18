import java.util.*;
public class hw5 extends mergeSort{
    /**
     *
     * @param a an array of integers
     * @return boolean
     * method that takes an array as input and determines if the array contains only distinct
     * values. returns true if so, otherwise returns false.
     */
    public static boolean distinctKeys(int[] a) {
        Set<Integer> keySet = new HashSet<Integer>();
        for(int key: a) {
            if (keySet.contains(key)) {
                return false;
            }
            keySet.add(key);
        }
        return true;
    }
    /**
     *
     * @param arrayLength desired length of array output
     * @return
     * takes in int arrayLength as input and generates unique integers from range (1,1000000). returns an array
     * of unique integers with length arrayLength
     */
    public static int[] randomNumberArray(int arrayLength) {
        Set<Integer> set = new HashSet<Integer>();
        Random r = new Random(System.currentTimeMillis());
        for (int i =0; i<arrayLength + 10000; i++) {
            // add distinct values with range (1, 1,000,000) to set
            set.add(r.nextInt(1000000) +1);
        }
        // add distinct integers from set to array
        int[] arr = new int[arrayLength];
        int j = 0;
        for(int key : set) {
            // if index out of bounds, break out of loop
            if (j > arr.length -1) {
                break;
            }
            // store distinct numbers in array
            arr[j++] = key;
        }
        // re-set seed
        r.setSeed(System.currentTimeMillis());
        return arr;
    }

    public static void main(String[] args) {
        long startTime, endTime, insertionTime, mergeTime, quickTime, heapTime;
        long[] insertTimes = new long[10];
        long[] mergeTimes = new long[10];
        long[] quickTimes = new long[10];
        long[] heapTimes = new long[10];

        int[][] arrays = new int[10][];
        int j = 10000;
        for(int i=0; i<10; i++) {
            arrays[i] = randomNumberArray(j);
            j += 10000;
        }

        for (int a=0; a<arrays.length; a++) {

            int b[] = arrays[a].clone();
            int c[] = arrays[a].clone();
            int d[] = arrays[a].clone();
            int e[] = arrays[a].clone();

            // insertion sort
            startTime = System.currentTimeMillis();
            insertionSort insert_obj = new insertionSort();
            insert_obj.insertionSort(b);
            endTime = System.currentTimeMillis();
            insertionTime = endTime - startTime;


            // merge sort
            startTime = System.currentTimeMillis();
            mergeSort merge_obj = new mergeSort();
            merge_obj.mergeSort(c, 0, c.length - 1);
            endTime = System.currentTimeMillis();
            mergeTime = endTime - startTime;

            // quick sort
            startTime = System.currentTimeMillis();
            quickSort quick_obj = new quickSort();
            quick_obj.quickSort(d, 0, d.length -1);
            endTime = System.currentTimeMillis();
            quickTime = endTime - startTime;

            // heap sort
            startTime = System.currentTimeMillis();
            heapSort ob = new heapSort();
            ob.heapSort(e);
            endTime = System.currentTimeMillis();
            heapTime = endTime - startTime;

            insertTimes[a] = insertionTime;
            mergeTimes[a] = mergeTime;
            quickTimes[a] = quickTime;
            heapTimes[a] = heapTime;


        }
        System.out.println(Arrays.toString(insertTimes));
        System.out.println(Arrays.toString(mergeTimes));
        System.out.println(Arrays.toString(quickTimes));
        System.out.println(Arrays.toString(heapTimes));

    }
}
