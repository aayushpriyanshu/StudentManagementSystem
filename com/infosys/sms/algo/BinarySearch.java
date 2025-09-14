package com.infosys.sms.algo;

import com.infosys.sms.model.Student;

public class BinarySearch {
    public static int indexOf(Student[] a, int id) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midId = a[mid].getId();
            if (midId == id) return mid;
            else if (midId < id) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
