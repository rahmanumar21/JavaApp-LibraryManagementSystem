package com.library.management.model;

import java.util.HashMap;
import java.util.Scanner;

public class Student {

    // Database object
    public HashMap<Integer, String> students = new HashMap<>();

    // Input object
    Scanner input = new Scanner(System.in).useDelimiter("\n");

    // fields
    private String name;
    private int id;

    // set and getter name
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // set and getter id
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    // students registered list
    public void add() {
        students.put(101, "Niall");
        students.put(102, "Anna");
    }

    // student register to the library
    public void addNewStudent() {

                System.out.println("Enter your name:");
                String name = input.next();
                System.out.println("Enter your id:");
                int id = input.nextInt();

                // enter to the database
                students.put(id, name);

    }




}
