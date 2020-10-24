package leetcode;

import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-10-18 14:07
 */
public class Solution5 {

    public static void main(String[] args) {
        int[] arr1 = {0,0};
        int[] arr2 = {0,0};
        double res = findMedianSortedArrays(arr1, arr2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            nums[index] = nums1[i];
            index++;
        }

        for (int i = 0; i < nums2.length; i++) {
            nums[index] = nums2[i];
            index++;
        }

        Arrays.sort(nums);

        if(nums.length % 2 == 0){
            int mid = nums.length / 2;
            double result = (nums[mid] + nums[mid - 1]) / 2.0;
            return result;
        }else{
            int  mid = nums.length / 2;
            double result = nums[mid];
            return result;
        }
    }

}
