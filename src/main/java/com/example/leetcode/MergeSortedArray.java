package com.example.leetcode;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        for (int i=0; i < m; i++) {
            if (nums2.length == 0) {
                return;
            }
            if (nums1[i] >= nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
            }
            for (int x = 0; x < n - 1 ; x++) {
                if (nums2[x] > nums2[x+1]) {
                    int temp2 = nums2[x];
                    nums2[x] = nums2[x+1];
                    nums2[x+1] = temp2;
                } else {
                    break;
                }
            }
        }
        int j = 0;
        for (int i = m; i < m+n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        for (int num : nums1) {
            System.out.println(num);
        }
    }
}
