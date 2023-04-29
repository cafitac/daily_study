package cafitac.jpa_optimize_performance;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class AuthorRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    private Long startTime;
    private Long endTime;

    @BeforeEach
    void setUp() {
        startTime = System.nanoTime();
    }

    @AfterEach
    void tearDown() {
        endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }

    @DisplayName("전체 검색")
    @Test
    void findAll() {
        final List<Book> books = bookRepository.findAll();
        System.out.println(books.stream().count());

        for (final Book book : books) {
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor().getName());
        }
    }
}
