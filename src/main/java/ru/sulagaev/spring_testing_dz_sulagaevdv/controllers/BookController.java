package ru.sulagaev.spring_testing_dz_sulagaevdv.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sulagaev.spring_testing_dz_sulagaevdv.models.Book;
import ru.sulagaev.spring_testing_dz_sulagaevdv.services.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Optional<Book> optionalBook = bookService.findById(id);
        return optionalBook.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping("/{id}")
        public Book update(@RequestBody Book book,
                           @PathVariable Long id){
        book.setId(id);
        return bookService.save(book);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
