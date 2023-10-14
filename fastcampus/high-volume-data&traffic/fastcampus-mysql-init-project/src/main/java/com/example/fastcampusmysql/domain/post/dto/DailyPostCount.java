package com.example.fastcampusmysql.domain.post.dto;

import java.time.LocalDate;
import org.springframework.cglib.core.Local;

public record DailyPostCount(
    Long memberId,
    LocalDate date,
    Long postCount
) {
}
