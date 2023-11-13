package com.example.fastcampusmysql.domain.post.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
public class PostLike {

    private final Long id;

    private final Long memberId;

    private final Long postId;

    private final LocalDateTime createdAt;

    @Builder
    public PostLike(final Long id, final Long memberId, final Long postId,
        final LocalDateTime createdAt) {
        this.id = id;
        this.memberId = Objects.requireNonNull(memberId);
        this.postId = Objects.requireNonNull(postId);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }
}
