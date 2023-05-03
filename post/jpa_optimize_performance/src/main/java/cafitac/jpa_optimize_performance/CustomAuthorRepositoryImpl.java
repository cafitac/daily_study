package cafitac.jpa_optimize_performance;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CustomAuthorRepositoryImpl implements CustomAuthorRepository {

    private static final int BATCH_SIZE = 100;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void bulkSave(List<Author> authors) {
        if (authors.isEmpty()) {
            return;
        }
        batchInsert(authors);
    }

    private void batchInsert(List<Author> authors) {
        jdbcTemplate.batchUpdate(
            " INSERT INTO author (name) VALUES (?);",
            authors,
            BATCH_SIZE,
            (final PreparedStatement ps, final Author author) -> {
                ps.setString(1, author.getName());
            });
        for (int i = 0; i < authors.size(); i++) {
            authors.get(i).setId((long) i + 1);
        }
    }
}
