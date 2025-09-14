package com.infosys.sms.app;

import com.infosys.sms.model.Student;
import com.infosys.sms.dsa.*;
import com.infosys.sms.algo.*;
import com.infosys.sms.exception.*;

import java.util.*;

public class StudentService {
    private CustomLinkedList<Student> studentList = new CustomLinkedList<>();
    private CustomHashTable<Integer, Student> studentMap = new CustomHashTable<>(50);
    private ScoreBST scoreTree = new ScoreBST();
    private CustomQueue<Student> helpdeskQueue = new CustomQueue<>();
    private CustomStack<String> undoStack = new CustomStack<>(5);

    

    public void addStudent(Student s) {
        studentList.add(s);
        studentMap.put(s.getId(), s);
        scoreTree.insert(s.getScore());
        undoStack.push("ADD:" + s.getId());
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int id) throws StudentNotFoundException {
        Student s = studentMap.get(id);
        if (s == null) throw new StudentNotFoundException("Student not found with ID: " + id);
        boolean removed = studentList.remove(stu -> stu.getId() == id);
        if (removed) {
            studentMap.remove(id);
            undoStack.push("REMOVE:" + id);
            System.out.println("Student removed.");
        }
    }

    public void displayAllStudents() {
        studentList.forEach(System.out::println);
    }

    public void searchStudentById(int id) throws StudentNotFoundException {
        Student[] arr = toArraySortedById();
        int index = BinarySearch.indexOf(arr, id);
        if (index == -1) throw new StudentNotFoundException("Student not found.");
        System.out.println(arr[index]);
    }

    public void sortByName() {
        Student[] arr = toArray();
        MergeSort.sortByName(arr);
        for (Student s : arr) System.out.println(s);
    }

    public void sortByScore() {
        Student[] arr = toArray();
        QuickSort.sortByScore(arr);
        for (Student s : arr) System.out.println(s);
    }

    public void scoreInsights() {
        System.out.println("Min Score: " + scoreTree.min());
        System.out.println("Max Score: " + scoreTree.max());
    }

    public void checkScoreExists(int score) {
        System.out.println("Score " + score + " exists: " + scoreTree.contains(score));
    }

    public void enqueueHelpdesk(int id) throws StudentNotFoundException {
        Student s = studentMap.get(id);
        if (s == null) throw new StudentNotFoundException("Student not found.");
        helpdeskQueue.enqueue(s);
        System.out.println("Student added to helpdesk queue.");
    }

    public void dequeueHelpdesk() throws EmptyDataStructureException {
        Student s = helpdeskQueue.dequeue();
        System.out.println("Serving: " + s);
    }

    public void undoLastOperation() throws EmptyDataStructureException, StudentNotFoundException {
        String op = undoStack.pop();
        String[] parts = op.split(":");
        String type = parts[0];
        int id = Integer.parseInt(parts[1]);

        if (type.equals("ADD")) {
            removeStudent(id);
            System.out.println("Undo ADD operation.");
        } else if (type.equals("REMOVE")) {
            Student s = new Student(id, "RestoredStudent", 50, "RestoredDept");
            addStudent(s);
            System.out.println("Undo REMOVE operation.");
        }
    }

    public void showReports() {
        System.out.println("=== All Students ===");
        displayAllStudents();

        System.out.println("\n=== Top 5 by Score ===");
        Student[] arr = toArray();
        QuickSort.sortByScore(arr);
        for (int i = arr.length - 1; i >= Math.max(0, arr.length - 5); i--) {
            System.out.println(arr[i]);
        }

        System.out.println("\n=== Score Insights ===");
        scoreInsights();

        System.out.println("\n=== Helpdesk Queue ===");
        helpdeskQueue.printQueue();

        System.out.println("\n=== Last 5 Operations ===");
        undoStack.printStack();
    }

    private Student[] toArray() {
        List<Student> temp = new ArrayList<>();
        studentList.forEach(temp::add);
        return temp.toArray(new Student[0]);
    }

    private Student[] toArraySortedById() {
        Student[] arr = toArray();
        Arrays.sort(arr, Comparator.comparingInt(Student::getId));
        return arr;
    }
}

