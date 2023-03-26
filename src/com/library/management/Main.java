package com.library.management;

import com.library.management.model.Student;
import com.library.management.services.Issue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Issue issue = new Issue();
        Student s1 = new Student();
        // add student to students HashMap
        s1.add();

        // get id
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter you id: ");
        int id = input.nextInt();

        // check if student is registered
        if (s1.students.containsKey(id)) {
            issue.getPurpose(id);
        }

        // ask if student want to register
        else {
            System.out.println("Be a member? yes or no");
            String answer = input.next();

            if (answer.equals("yes")) {
                s1.addNewStudent();
                System.out.println("You are registered.");
                issue.getPurpose(id);
            }
            else {
                System.out.println("Okay, bye");
            }
        }

    }
}
