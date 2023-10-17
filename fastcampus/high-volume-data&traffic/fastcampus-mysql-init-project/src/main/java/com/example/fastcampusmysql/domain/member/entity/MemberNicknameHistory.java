package com.example.fastcampusmysql.domain.member.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class MemberNicknameHistory {

    private final Long id;

    private final Long memberId;

    private final String nickname;

    private final LocalDateTime createdAt;

    @Builder
    public MemberNicknameHistory(final Long id, final Long memberId, final String nickname,
        final LocalDateTime createdAt) {
        this.id = id;
        this.memberId = Objects.requireNonNull(memberId);
        this.nickname = Objects.requireNonNull(nickname);
        this.createdAt = createdAt == null ? LocalDateTime.now().withNano(0) : createdAt;
    }
}
