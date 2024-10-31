package ru.sulagaev.spring_testing_dz_sulagaevdv.observer.impl;

import ru.sulagaev.spring_testing_dz_sulagaevdv.models.Book;
import ru.sulagaev.spring_testing_dz_sulagaevdv.observer.BookObserver;

public class ConsoleObserver implements BookObserver {
    @Override
    public void add(Book book) {
        System.out.println("Book created: " + book.toString());
    }
}