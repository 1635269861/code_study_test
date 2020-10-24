package com.bjpowernode.nio;

/**
 * @李永琪
 * @create 2020-10-07 11:22
 */
public class InversePairsSolution {

    public int cnt;


    public int InversePairs(int [] array) {
        mergeSort(array,0,array.length - 1);
        return cnt;
    }

    public void mergeSort(int[] arr,int left,int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid + 1,right);
            mergeOne(arr,left,mid,right);
        }
    }

    public void mergeOne(int[] arr, int left, int mid,int right){
        int[] temp = new int[right - left + 1];
        int t = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                ++j;
                t++;
                cnt = (cnt + (mid - i + 1)) % 1000000007;
            }
        }
        while (i <= mid){
            temp[t] = arr[i];
            ++i;
            t++;
        }

        while (j <= right){
            temp[t] = arr[j];
            j++;
            t++;
        }

        int tempLeft = left;
        t = 0;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }

}
