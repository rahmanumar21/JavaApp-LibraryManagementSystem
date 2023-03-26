package com.library.management.services;

import java.util.HashMap;

public class Book {

    // bookshelf object
    HashMap<Integer, String> bookShelf = new HashMap<>();

    public void add() {

        // add to bookshelf
        bookShelf.put(11, "The Fault in our Stars");
        bookShelf.put(22, "A Good com.library.management.services.Book");

    }
}
