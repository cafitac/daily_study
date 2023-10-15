package com.example.fastcampusmysql.domain.post.repository;

import com.example.fastcampusmysql.domain.post.entity.Timeline;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TimelineRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final String TABLE = "Timeline";
    private static final RowMapper<Timeline> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> Timeline
        .builder()
        .id(resultSet.getLong("id"))
        .memberId(resultSet.getLong("memberId"))
        .postId(resultSet.getLong("postId"))
        .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
        .build();

    public Timeline save(Timeline timeline) {
        if (timeline.getId() == null) {
            return insert(timeline);
        }
        throw new UnsupportedOperationException("Timeline은 갱신을 지원하지 않습니다.");
    }

    public void bulkInsert(List<Timeline> timelines) {
        var sql = String.format("""
             INSERT INTO %s (memberId, postId, createdAt)
             VALUES (:memberId, :postId, :createdAt)
            """, TABLE);

        final SqlParameterSource[] params = timelines
            .stream()
            .map(BeanPropertySqlParameterSource::new)
            .toArray(SqlParameterSource[]::new);
        namedParameterJdbcTemplate.batchUpdate(sql, params);
    }

    public List<Timeline> findAllByMemberIdAndOrderByDescId(Long memberId, int size) {
        var sql = String.format("""
            SELECT *
            FROM %s
            WHERE memberId = :memberId
            ORDER BY id desc
            LIMIT :size
            """, TABLE);

        var params = new MapSqlParameterSource()
            .addValue("memberId", memberId)
            .addValue("size", size);

        return namedParameterJdbcTemplate.query(sql, params, ROW_MAPPER);
    }

    public List<Timeline> findAllByLessThenIdMemberIdAndOrderByDescId(Long id, Long memberId,
        int size) {
        var sql = String.format("""
            SELECT *
            FROM %s
            WHERE memberId = :memberId and id < :id
            ORDER BY id desc
            LIMIT :size
            """, TABLE);

        var params = new MapSqlParameterSource()
            .addValue("memberId", memberId)
            .addValue("id", id)
            .addValue("size", size);

        return namedParameterJdbcTemplate.query(sql, params, ROW_MAPPER);
    }

    private Timeline insert(Timeline timeline) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(
            namedParameterJdbcTemplate.getJdbcTemplate())
            .withTableName(TABLE)
            .usingGeneratedKeyColumns("id");

        SqlParameterSource params = new BeanPropertySqlParameterSource(timeline);
        var id = simpleJdbcInsert.executeAndReturnKey(params).longValue();

        return Timeline.builder()
            .id(id)
            .memberId(timeline.getMemberId())
            .postId(timeline.getPostId())
            .createdAt(timeline.getCreatedAt())
            .build();
    }
}
