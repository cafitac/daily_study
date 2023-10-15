package com.example.fastcampusmysql.domain.post.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {

    private final Long id;

    private final Long memberId;

    private final String contents;

    private final LocalDate createdDate;

    private Long likeCount;

    private Long version;

    private final LocalDateTime createdAt;

    @Builder
    public Post(final Long id, final Long memberId, final String contents,
        final LocalDate createdDate, final Long likeCount, final Long version,
        final LocalDateTime createdAt) {
        this.id = id;
        this.memberId = Objects.requireNonNull(memberId);
        this.contents = Objects.requireNonNull(contents);
        this.createdDate = createdDate == null ? LocalDate.now() : createdDate;
        this.likeCount = likeCount == null ? 0 : likeCount;
        this.version = version == null ? 0 : version;
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    public void incrementLikeCount() {
        this.likeCount++;
    }
}
