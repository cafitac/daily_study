package cafitac.jpa_optimize_performance;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CustomBookRepositoryImpl implements CustomBookRepository {

    private static final int BATCH_SIZE = 100;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void bulkSave(List<Book> books) {
        if (books.isEmpty()) {
            return;
        }
        batchInsert(books);
    }

    private void batchInsert(List<Book> books) {
        jdbcTemplate.batchUpdate(
            " INSERT INTO book (author_id, title) VALUES (?, ?);",
            books,
            BATCH_SIZE,
            (final PreparedStatement ps, final Book book) -> {
                ps.setLong(1, book.getAuthor().getId());
                ps.setString(2, book.getTitle());
            });
    }
}
