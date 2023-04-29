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

    private static final int BATCH_SIZE = 1000;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void bulkSave(List<Book> books) {
        if (books.isEmpty()) {
            return;
        }
        batchInsert(BATCH_SIZE, books);
    }

    private void batchInsert(int batchSize, List<Book> books) {
        jdbcTemplate.batchUpdate(
                " INSERT INTO book (author_id, title) VALUES (?, ?);",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        log.debug("Save Sentence Index : " + i);
                        final Book book = books.get(i);
                        ps.setLong(1, book.getAuthor().getId());
                        ps.setString(2, book.getTitle());
                    }

                    @Override
                    public int getBatchSize() {
                        return books.size();
                    }
                }
        );
    }
}
