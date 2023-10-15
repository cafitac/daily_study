package com.example.fastcampusmysql.domain.post.service;

import com.example.fastcampusmysql.domain.post.dto.DailyPostCount;
import com.example.fastcampusmysql.domain.post.dto.DailyPostCountRequest;
import com.example.fastcampusmysql.domain.post.dto.PostDto;
import com.example.fastcampusmysql.domain.post.entity.Post;
import com.example.fastcampusmysql.domain.post.repository.PostLikeRepository;
import com.example.fastcampusmysql.domain.post.repository.PostRepository;
import com.example.fastcampusmysql.util.CursorRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostReadService {

    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;

    public List<DailyPostCount> getDailyPostCount(DailyPostCountRequest request) {
        /*
            반환 값 -> 리스트 [작성일자, 작성회원, 작성 게시물 갯수]
            select createdDate, memberId, count(id)
            from Post
            where memberId = :memberId and createDate between firstDate and lastDate
            group by createdDate memberId
         */
        return postRepository.groupByCreatedDate(request);
    }

    public Page<PostDto> getPosts(Long memberId, Pageable pageRequest) {
        return postRepository.findAllByMemberId(memberId, pageRequest).map(this::toDto);
    }

    private PostDto toDto(Post post) {
        return new PostDto(
            post.getId(),
            post.getContents(),
            post.getCreatedAt(),
            postLikeRepository.count(post.getId())
        );
    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId, false).orElseThrow();
    }

    public PageCursor<Post> getPosts(Long memberId, CursorRequest cursorRequest) {
        var posts = findAllBy(memberId, cursorRequest);
        final var nextKey = getNextKey(posts);
        return new PageCursor<>(cursorRequest.next(nextKey), posts);
    }

    public PageCursor<Post> getPosts(List<Long> memberIds, CursorRequest cursorRequest) {
        var posts = findAllBy(memberIds, cursorRequest);
        final var nextKey = getNextKey(posts);
        return new PageCursor<>(cursorRequest.next(nextKey), posts);
    }

    public List<Post> getPosts(List<Long> ids) {
        return postRepository.findAllByInId(ids);
    }

    private List<Post> findAllBy(final Long memberId, final CursorRequest cursorRequest) {
        if (cursorRequest.hasKey()) {
            return postRepository.findAllByLessThenIdAndMemberIdOrderByIdDesc(
                cursorRequest.key(), memberId, cursorRequest.size());
        }
        return postRepository.findAllByMemberIdOrderByIdDesc(memberId, cursorRequest.size());
    }

    private List<Post> findAllBy(final List<Long> memberIds, final CursorRequest cursorRequest) {
        if (cursorRequest.hasKey()) {
            return postRepository.findAllByLessThenIdAndInMemberIdOrderByIdDesc(
                cursorRequest.key(), memberIds, cursorRequest.size());
        }
        return postRepository.findAllByInMemberIdOrderByIdDesc(memberIds, cursorRequest.size());
    }

    private static long getNextKey(final List<Post> posts) {
        var nextKey = posts.stream()
            .mapToLong(Post::getId)
            .min()
            .orElse(CursorRequest.NONE_KEY);
        return nextKey;
    }
}
