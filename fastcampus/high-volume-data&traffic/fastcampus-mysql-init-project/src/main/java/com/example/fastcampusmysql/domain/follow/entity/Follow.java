package com.example.fastcampusmysql.domain.follow.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Follow {

    private final Long id;

    private final Long fromMemberId;

    private final Long toMemberId;

    private final LocalDateTime createdAt;

    @Builder
    public Follow(final Long id, final Long fromMemberId, final Long toMemberId,
        final LocalDateTime createdAt) {
        this.id = id;
        this.fromMemberId = Objects.requireNonNull(fromMemberId);
        this.toMemberId = Objects.requireNonNull(toMemberId);
        this.createdAt = createdAt == null ? LocalDateTime.now().withNano(0) : createdAt;
    }
}
