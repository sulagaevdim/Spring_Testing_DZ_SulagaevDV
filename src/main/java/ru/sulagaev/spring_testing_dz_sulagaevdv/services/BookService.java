package ru.sulagaev.spring_testing_dz_sulagaevdv.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sulagaev.spring_testing_dz_sulagaevdv.models.Book;
import ru.sulagaev.spring_testing_dz_sulagaevdv.observer.BookObserver;
import ru.sulagaev.spring_testing_dz_sulagaevdv.observer.impl.ConsoleObserver;
import ru.sulagaev.spring_testing_dz_sulagaevdv.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    public final BookRepository bookRepository;
    public BookObserver observer = new ConsoleObserver();

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }

    public Book save(Book book){
        observer.add(book);
        return bookRepository.save(book);
    }
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

}
