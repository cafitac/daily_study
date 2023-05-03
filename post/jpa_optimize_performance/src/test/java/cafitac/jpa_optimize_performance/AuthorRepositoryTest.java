package cafitac.jpa_optimize_performance;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class AuthorRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    private Long startTime;
    private Long endTime;

    @BeforeEach
    void setUp() {
        System.out.println("setUP");
        startTime = System.nanoTime();
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
        endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS) + "s");
    }

    @DisplayName("전체 검색")
    @Test
    void findAll() {
        final List<Book> books = bookRepository.findAll();

        for (final Book book : books) {
            final String title = book.getTitle();
            final String name = book.getAuthor().getName();
        }
    }
}
