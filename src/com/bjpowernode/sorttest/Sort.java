package com.bjpowernode.sorttest;

import sun.plugin2.os.windows.FLASHWINFO;

import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-09-17 12:49
 */
public class Sort {

    public static void main(String[] args) {
//        测试冒泡排序
        int[] arr = {3,9,-1,10,20};
//        System.out.println("排序前的数组：" + Arrays.toString(arr));
//        bubboSort(arr);
//        System.out.println("冒泡排序后的数组：" + Arrays.toString(arr));
        quickSort(arr,0,arr.length - 1);
        /*测试选择排序
        int[] arr = {101,34,119,1,-1,90,123};
        selectSort(arr);
        System.out.println("选择排序过后的数组：" + Arrays.toString(arr));
         */

        /*测试插入排序
        int[] arr = {101,34,119,1};
        insertSort(arr);
        System.out.println("经过插入排序之后：" + Arrays.toString(arr));
         */

        /*测试希尔排序
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
        System.out.println("经过希尔排序过后：" + Arrays.toString(arr));
         */

//        int[] arr = {3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321};
//        quickSort(arr,0,arr.length - 1);
//        System.out.println("经过快速排序：" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序：每一次把最大的数移动到最后面，比较两个相邻的数字的大小，如果符合条件进行交换
     * 冒泡排序的最好情况：数组的初始状态为正序的，一趟扫描久可以完成排序，冒泡下排序最好的时间复杂度为O（n）
     * 最坏情况：数组的初始状态为反序的，需要进行n - 1趟排序，每一趟都要进行 n - i次关键字的比较，最坏情况为O(n*n)
     * 冒泡排序的平均时间复杂度为O(n * n)
     * 如果两个数字相等，那么使用冒泡排序是不用进行数字交换的，因此冒泡排序是稳定的。
     * 内排序,空间复杂度为O(1)
     * @param arr
     */
    public static void bubboSort(int[] arr){

        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {

            //定义一个标记，如果该标记改变，说明排序不正确，仍需要继续排序，如果没有改变，说明当前排序已经排序好了，无需再进行排序
            for (int j = i + 1; j < arr.length - 1 - i; j++) {
                if(arr[i] > arr[j]){
                    flag = true;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
    }

    /**
     * 选择排序：首先在未排序的序列中挑选出最小的元素，放入到排序的序列中，接着再从剩下的未排序的序列中挑选出最小的元素，放入到排好序的第二位
     *  最好的情况：所有的元素已经排好序，无需进行交换，O(n * n)
     *  最坏情况：交换（n - 1）次，逆序交换n / 2次,O(n * n)
     *  内排序，空间复杂度为O（1）
     *  稳定性：不稳定。比如5 8 5 2 9，第一次选出来的是将2和5交换，而此时两个5 的相对位置就发生了变化，说明是不稳定的。
     *
     * @param arr
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            if(min != arr[i]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    /**
     * 插入排序：是指在待排序的元素中，假设前面（n - 1）个数是排好序的，现将第n个数据插入到前面已经排好序的序列中找到自己的位置
     * 最好情况：序列是有序的，是最优的情况，只需要当签数跟前一个数比较一下就可以了，总共需要N-1次，时间复杂度为：O(n)
     * 最坏情况：序列是逆序的，此时需要比较的次数为：1+2+3...+n-1，所以插入最坏情况的空间复杂度为O(n * n)
     * 平均时间复杂度：O(n * n)
     * 稳定性：不会改变两个相同数字的相对次序，是稳定的
     * 内排序，空间复杂度为：O(1)
     * 需要进行排序的次数为：n - 1
     * 应用场景：是一种最简单的排序方法，一般在输入规模大于1000的时候不建议用插入排序
     * @param arr
     */
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && (arr[j] < arr[j - 1]) ; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    /**
     * 希尔排序：希尔排序是把记录按下标的一定增量分组，对每组使用直接插入的方法进行排序；随着增量的逐渐减少，魅族包含的关键词越来越多
     *          当增量减为1时，算法就终止了.
     * 稳定性：不稳定。由于分组被打破,稳定性被破坏了
     * 最好情况：O(n log^2n)
     * 最坏情况：O(n log^2n)
     * 平均情况：O(nlogn)
     * 空间复杂度：O(1)
     * @param arr
     */
    public static void shellSort(int[] arr){
        int gap = arr.length;
        while (true){
            gap /= 2;
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j+=gap) {
                    int temp = arr[j];
                    int k = j - gap;
                    while (k >= 0 && arr[k] > temp){
                        arr[k + gap] = arr[k];
                        k -= gap;
                    }
                    arr[k + gap] = temp;
                }
            }
            if(gap == 1){
                break;
            }
        }
    }

    /**
     * 快速排序：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再对这两部分分别
     *          进行快速排序，整个排序可以递归进行。
     * 最好情况：每次划分的所选择的中间数敲好将当前序列几乎等分，经过log2n趟划分，便可得到长度为1的子表。这样整个算法的时间复杂度为O(nlog2n)
     * 最坏情况：每次选择的中间数时当前的最大或者最小数，这样长度为n的快速排序需要进行n趟排序，使得整个算法的时间复杂度为O(n*n)
     * 快速排序的时间平均复杂度为：O(nlog2n)。该方法被认为是目前最好的一种内部排序方法。
     * 不稳定
     * 空间复杂度O(log2n)
     * @param arr
     */
    public static void quickSort(int[] arr,int start,int end){
        int privot = arr[start];
        int i = start;
        int j = end;

        while (i < j){
            while (i < j && arr[i] < privot){
                i++;
            }
            while (i < j && arr[j] > privot){
                j--;
            }
            if(i < j && arr[j] == arr[i]){
                i++;
            }else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if(i - 1 > start){
            quickSort(arr,start,i-1);
        }
        if(j + 1 < end){
            quickSort(arr,j+1,end);
        }
        System.out.println(Arrays.toString(arr));
    }

}
