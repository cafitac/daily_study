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
public class CustomAuthorRepositoryImpl implements CustomAuthorRepository {

    private static final int BATCH_SIZE = 1000;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void bulkSave(List<Author> authors) {
        if (authors.isEmpty()) {
            return;
        }
        batchInsert(BATCH_SIZE, authors);
    }

    private void batchInsert(int batchSize, List<Author> authors) {
        jdbcTemplate.batchUpdate(
                " INSERT INTO author (name) VALUES (?);",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        log.debug("Save Sentence Index : " + i);
                        final Author author = authors.get(i);
                        ps.setString(1, author.getName());
                    }

                    @Override
                    public int getBatchSize() {
                        return authors.size();
                    }
                }
        );
    }
}
