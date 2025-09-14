package com.infosys.sms.app;

import com.infosys.sms.model.Student;
import com.infosys.sms.exception.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        

        while (true) {
            System.out.println("\n===== Student Management & Analytics =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Student by ID (Binary Search)");
            System.out.println("5. Sort Students by Name (Merge Sort)");
            System.out.println("6. Sort Students by Score (Quick Sort)");
            System.out.println("7. Score Insights (BST)");
            System.out.println("8. Helpdesk: Enqueue Student");
            System.out.println("9. Helpdesk: Dequeue & Serve");
            System.out.println("10. Undo Last Operation (Stack)");
            System.out.println("11. Reports");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Score: ");
                        int score = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        service.addStudent(new Student(id, name, score, dept));
                        break;
                    case 2:
                        System.out.print("Enter ID to remove: ");
                        service.removeStudent(sc.nextInt());
                        break;
                    case 3:
                        service.displayAllStudents();
                        break;
                    case 4:
                        System.out.print("Enter ID to search: ");
                        service.searchStudentById(sc.nextInt());
                        break;
                    case 5:
                        service.sortByName();
                        break;
                    case 6:
                        service.sortByScore();
                        break;
                    case 7:
                        service.scoreInsights();
                        break;
                    case 8:
                        System.out.print("Enter ID to enqueue: ");
                        service.enqueueHelpdesk(sc.nextInt());
                        break;
                    case 9:
                        service.dequeueHelpdesk();
                        break;
                    case 10:
                        service.undoLastOperation();
                        break;
                    case 11:
                        service.showReports();
                        break;
                    case 12:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
