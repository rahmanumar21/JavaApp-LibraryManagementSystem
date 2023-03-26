package com.library.management.services;

import com.library.management.model.Student;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Issue {

    // store book issued by student
    HashMap<Integer, String> issue = new HashMap<>();

    // user input object
    Scanner input = new Scanner(System.in).useDelimiter("\n");

    // book object
    Book b1 = new Book();

    // student object
    Student s1 = new Student();

    public Issue() {

        // add elements to student HashMap
        s1.add();

        // add elements to book HashMap
        b1.add();

    }

    // method to issue book
    void issueBook(int id) {

        System.out.println("Enter a book:");
        String bookName = input.next();

        // We can only issue the book that is in the library,
        // so we will first check if the book is in the library.
        // Here, the containsValue() checks if the entered
        // bookName is present inside the bookShelf HashMap.
        // If the book is present inside the bookShelf HashMap,
        // we need to remove the book from the bookShelf HashMap
        // and add it to the issue HashMap.
        if (b1.bookShelf.containsValue(bookName)) {

            // To remove the book from the book HashMap,
            // we need to get its id.
            int bookId = 0;

            // Here, the entrySet() method returns a set view of all the entries.
            //  - entry.getValue() - gets value from the entry
            //  - entry.getKey() - gets key from the entry
            // To use the entrySet method we must import java.util.Map.Entry.
            // Inside the if statement we check if the value from the entry is
            // the same as the bookName. And, for matching value, we get
            // the corresponding key and store it in bookId.
            for (Entry<Integer, String> entry : b1.bookShelf.entrySet()) {

                // get bookId from book name
                if (entry.getValue().equals(bookName)) {
                    bookId = entry.getKey();
                    break;
                }

            }

            // Then, we have removed the book from the book HashMap.
            b1.bookShelf.remove(bookId);

            // Then, we finally issue the book to the user.
            // To issue the book we put the id of the student
            // as the key and bookName as the value inside the issue hashmap.
            issue.put(id, bookName);

            // get student name from id
            String name = s1.students.get(id);

            // print name and issued book
            System.out.println("Part1: " + name);
            System.out.println("com.library.management.services.Book: " + bookName);
            System.out.println("com.library.management.services.Book issued. Congratulation");

        }

        else {
            System.out.println("com.library.management.services.Book doesn't exist");
            System.out.println("We have following books: ");
            System.out.println(b1.bookShelf);
        }

    }

    void returnBook(int id) {

        issue.put(101, "A Good com.library.management.services.Book");

        if (issue.containsKey(id)) {
            System.out.println("Enter a book to return:");
            String bookName = input.next();

            // get book id
            int bookId = 0;

            // iterate each entry of HashMap
            for (Entry<Integer, String> entry : b1.bookShelf.entrySet()) {

                // if give value is equal to value from entry
                // print the corresponding key
                if (entry.getValue().equals(bookName)) {
                    bookId = entry.getKey();
                    break;
                }
            }

            // check if book is issued
            if (issue.containsValue(bookName)) {

                // remove issue record from issue HashMap
                issue.remove(id);

                // add book back to bookShelf HashMap
                b1.bookShelf.put(bookId, bookName);

                // print name of student and book
                // get student name from id
                String name = s1.students.get(id);
                System.out.println("Part1: " + name);
                System.out.println("com.library.management.services.Book: " + bookName);
                System.out.println("com.library.management.services.Book returned");

            }

            else {
                System.out.println("com.library.management.services.Book is not issued.");
            }
        }
        else {
            System.out.println("You haven't issued any book");
        }
    }

    public void getPurpose(int id) {

        Issue i1 = new Issue();
        String purpose;

        System.out.println("Enter your purpose: return or issue");
        purpose = input.next();

        if (purpose.equals("issue")) {

            i1.issueBook(id);

        }
        else if (purpose.equals("return")) {

            i1.returnBook(id);

        }
    }
}
