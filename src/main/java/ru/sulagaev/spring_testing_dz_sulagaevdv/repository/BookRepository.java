package ru.sulagaev.spring_testing_dz_sulagaevdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sulagaev.spring_testing_dz_sulagaevdv.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
