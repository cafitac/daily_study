package com.example.fastcampusmysql.domain.post.service;

import com.example.fastcampusmysql.util.CursorRequest;
import java.util.List;

public record PageCursor<T> (
    CursorRequest nextCursorRequest,
    List<T> body
) {
}
