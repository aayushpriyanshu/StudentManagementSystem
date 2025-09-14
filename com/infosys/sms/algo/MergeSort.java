package com.infosys.sms.algo;

import com.infosys.sms.model.Student;

public class MergeSort {
    public static void sortByName(Student[] arr) {
        if (arr == null || arr.length < 2) return;
        Student[] tmp = new Student[arr.length];
        sort(arr, tmp, 0, arr.length - 1);
    }

    private static void sort(Student[] a, Student[] t, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        sort(a, t, l, m);
        sort(a, t, m + 1, r);
        merge(a, t, l, m, r);
    }

    private static void merge(Student[] a, Student[] t, int l, int m, int r) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (a[i].getName().compareToIgnoreCase(a[j].getName()) <= 0) t[k++] = a[i++];
            else t[k++] = a[j++];
        }
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        for (int xl = l; xl <= r; xl++) a[xl] = t[xl];
    }
}
