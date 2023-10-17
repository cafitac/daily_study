package com.example.fastcampusmysql.domain.member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.fastcampusmysql.domain.member.entity.MemberNicknameHistory;
import com.example.fastcampusmysql.domain.member.repository.MemberNicknameHistoryRepository;
import java.util.stream.LongStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberNicknameHistoryRepositoryTest {

    @Autowired
    private MemberNicknameHistoryRepository memberNicknameHistoryRepository;

    @Test
    void findById() {
        var memberNicknameHistory = MemberNicknameHistory.builder()
            .memberId(1L)
            .nickname("nickname")
            .build();
        var savedMemberNicknameHistory = memberNicknameHistoryRepository.save(
            memberNicknameHistory);

        var findMemberNicknameHistory = memberNicknameHistoryRepository.findById(
            savedMemberNicknameHistory.getId()).orElseThrow();

        assertThat(findMemberNicknameHistory).isEqualTo(savedMemberNicknameHistory);
    }

    @Test
    void findAllByMemberId() {
        LongStream.range(1, 3)
            .forEach(i -> {
                var memberNicknameHistory = MemberNicknameHistory.builder()
                    .memberId(i)
                    .nickname("nickname")
                    .build();
                memberNicknameHistoryRepository.save(memberNicknameHistory);
            });
    }

    @Test
    void saveInsert() {
        var memberNicknameHistory = MemberNicknameHistory.builder()
            .memberId(1L)
            .nickname("nickname")
            .build();
        var savedMemberNicknameHistory = memberNicknameHistoryRepository.save(
            memberNicknameHistory);

        var findMemberNicknameHistory = memberNicknameHistoryRepository.findById(
            savedMemberNicknameHistory.getId()).orElseThrow();

        assertThat(findMemberNicknameHistory).isEqualTo(savedMemberNicknameHistory);
    }

    @Test
    void saveUpdateUnsupported() {
        var memberNicknameHistory = MemberNicknameHistory.builder()
            .id(1L)
            .memberId(1L)
            .nickname("nickname")
            .build();

        assertThatThrownBy(() -> {
            memberNicknameHistoryRepository.save(memberNicknameHistory);
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
