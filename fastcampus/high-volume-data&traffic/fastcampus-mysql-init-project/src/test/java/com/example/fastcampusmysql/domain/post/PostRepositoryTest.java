package com.example.fastcampusmysql.domain.post;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.fastcampusmysql.domain.post.dto.DailyPostCount;
import com.example.fastcampusmysql.domain.post.dto.DailyPostCountRequest;
import com.example.fastcampusmysql.domain.post.entity.Post;
import com.example.fastcampusmysql.domain.post.repository.PostRepository;
import com.example.fastcampusmysql.util.PostFixtureFactory;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void groupByCreatedDate() {
        var post1 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        var post2 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        var post3 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 31)).nextObject(Post.class);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        final LocalDate firstDate = LocalDate.of(1999, 12, 30);
        final LocalDate lastDate = LocalDate.of(1999, 12, 31);
        final List<DailyPostCount> dailyPostCounts = postRepository.groupByCreatedDate(
            new DailyPostCountRequest(1L, firstDate, lastDate));

        assertThat(dailyPostCounts).hasSize(2);
    }

    @Test
    void findAllByInId() {
        var post1 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        var post2 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        var post3 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 31)).nextObject(Post.class);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        var posts = postRepository.findAllByMemberIdOrderByIdDesc(1L, 10);
        var postIds = posts.stream()
            .map(Post::getId)
            .toList();

        var findPosts = postRepository.findAllByInId(postIds);

        assertThat(findPosts).hasSize(3);
    }

    @Test
    void findAllByMemberId() {
        // given

        // when

        // then
    }

    @Test
    void findById() {
        // given

        // when

        // then
    }

    @Test
    void findAllByMemberIdOrderByIdDesc() {
        // given

        // when

        // then
    }

    @Test
    void findAllByInMemberIdOrderByIdDesc() {
        // given

        // when

        // then
    }

    @Test
    void findAllByLessThenIdAndMemberIdOrderByIdDesc() {
        // given

        // when

        // then
    }

    @Test
    void findAllByLessThenIdAndInMemberIdOrderByIdDesc() {
        // given

        // when

        // then
    }

    @Test
    void saveInsert() {
        // given

        // when

        // then
    }

    @Test
    void saveUpdate() {
        // given

        // when

        // then
    }
}
