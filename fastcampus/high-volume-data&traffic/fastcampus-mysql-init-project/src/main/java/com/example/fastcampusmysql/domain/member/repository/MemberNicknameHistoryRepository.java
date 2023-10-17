package com.example.fastcampusmysql.domain.member.repository;

import com.example.fastcampusmysql.domain.member.entity.MemberNicknameHistory;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
public class MemberNicknameHistoryRepository {

    final private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public static final String TABLE = "MemberNicknameHistory";
    public static final RowMapper<MemberNicknameHistory> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> MemberNicknameHistory
        .builder()
        .id(resultSet.getLong("id"))
        .memberId(resultSet.getLong("memberId"))
        .nickname(resultSet.getString("nickname"))
        .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
        .build();

    public Optional<MemberNicknameHistory> findById(Long id) {
        var sql = String.format("SELECT * FROM %s WHERE id = :id", TABLE);
        var params = new MapSqlParameterSource().addValue("id", id);
        var memberNicknameHistory = namedParameterJdbcTemplate.queryForObject(sql, params,
            ROW_MAPPER);
        return Optional.of(memberNicknameHistory);
    }

    public List<MemberNicknameHistory> findAllByMemberId(Long memberId) {
        var sql = String.format("SELECT * FROM %s WHERE memberId = :memberId", TABLE);
        var params = new MapSqlParameterSource().addValue("memberId", memberId);
        return namedParameterJdbcTemplate.query(sql, params, ROW_MAPPER);
    }

    public MemberNicknameHistory save(MemberNicknameHistory history) {
        /*
            history id를 보고 갱신 또는 삽입을 정함
            반환값은 id를 담아서 반환한다.
         */
        if (history.getId() == null) {
            return insert(history);
        }
        throw new UnsupportedOperationException("MemberNicknameHistory는 갱신을 지원하지 않습니다.");
    }

    private MemberNicknameHistory insert(MemberNicknameHistory history) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(
            namedParameterJdbcTemplate.getJdbcTemplate())
            .withTableName(TABLE)
            .usingGeneratedKeyColumns("id");
        SqlParameterSource params = new BeanPropertySqlParameterSource(history);
        var id = simpleJdbcInsert.executeAndReturnKey(params).longValue();

        return MemberNicknameHistory.builder()
            .id(id)
            .memberId(history.getMemberId())
            .nickname(history.getNickname())
            .createdAt(history.getCreatedAt())
            .build();
    }
}
