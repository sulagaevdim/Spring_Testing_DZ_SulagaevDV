package ru.sulagaev.spring_testing_dz_sulagaevdv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sulagaev.spring_testing_dz_sulagaevdv.models.Book;
import ru.sulagaev.spring_testing_dz_sulagaevdv.repository.BookRepository;
import ru.sulagaev.spring_testing_dz_sulagaevdv.services.BookService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class BookServiseTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService service;

    private final Book book = new Book(1L, "Computer_Networks", "Olifer");

    @Test
    public void testGetAllBooks() {
        List<Book> books = Arrays.asList(
                book, new Book(2L, "War_&_World", "Tolstoy")
        );

        Mockito.when(repository.findAll()).thenReturn(books);

        List<Book> result = service.findAll();

        assertEquals(2, result.size());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }
    @Test
    public void testGetBookById() {
        repository.save(book);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(book));

        Book result = service.findById(1L).orElseThrow();

        assertNotNull(result);
        assertEquals(book.getId(), result.getId());
        assertEquals(book.getTitle(), result.getTitle());
        assertEquals(book.getAuthor(), result.getAuthor());

        Mockito.verify(repository, Mockito.times(1)).findById(1L);
    }
    @Test
    public void testSaveBook(){
        Book savedBook = new Book(1L, "Computer_Networks", "Olifer");
        Mockito.when(repository.save(book)).thenReturn(savedBook);

        Book result = service.save(book);

        assertNotNull(result);
        assertEquals(savedBook.getId(), result.getId());
        assertEquals(savedBook.getTitle(), result.getTitle());
        assertEquals(savedBook.getAuthor(), result.getAuthor());
        Mockito.verify(repository, Mockito.times(1)).save(book);
    }
    @Test
    public void testDeleteBook(){
        repository.save(book);
        Long id = book.getId();

        service.deleteById(id);

        Mockito.verify(repository, Mockito.times(1)).deleteById(id);
    }
}
