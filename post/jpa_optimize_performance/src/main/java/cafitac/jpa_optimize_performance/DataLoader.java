package cafitac.jpa_optimize_performance;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("default")
public class DataLoader implements InitializingBean {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public void afterPropertiesSet() throws Exception {
        final List<Author> authors = new ArrayList<>();
        final List<Book> books = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            log.info("Data initial index : {}", i);
            final Author author = new Author("author");
            authors.add(author);
            final Book book = new Book("title", author);
            books.add(book);
        }
        authorRepository.bulkSave(authors);
        bookRepository.bulkSave(books);
    }
}
