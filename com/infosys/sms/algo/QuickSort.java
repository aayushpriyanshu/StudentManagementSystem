package com.infosys.sms.algo;

import com.infosys.sms.model.Student;

public class QuickSort {
    public static void sortByScore(Student[] a) {
        qs(a, 0, a.length - 1);
    }

    private static void qs(Student[] a, int l, int r) {
        if (l >= r) return;
        int i = l, j = r, p = a[(l + r) / 2].getScore();
        while (i <= j) {
            while (a[i].getScore() < p) i++;
            while (a[j].getScore() > p) j--;
            if (i <= j) {
                Student t = a[i]; a[i] = a[j]; a[j] = t;
                i++; j--;
            }
        }
        if (l < j) qs(a, l, j);
        if (i < r) qs(a, i, r);
    }
}
