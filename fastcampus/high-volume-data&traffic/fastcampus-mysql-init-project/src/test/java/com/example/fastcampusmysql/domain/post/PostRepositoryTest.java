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
import org.springframework.data.domain.PageRequest;
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
        var post1 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        var post2 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        var post3 = PostFixtureFactory.getByCreatedDate(2L, LocalDate.of(1999, 12, 31)).nextObject(Post.class);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        var findPosts = postRepository.findAllByMemberId(1L, PageRequest.of(0, 10));

        assertThat(findPosts).hasSize(2);
    }

    @Test
    void findById() {
        var post = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        postRepository.save(post);

        final Post savedPost = postRepository.findAllByMemberIdOrderByIdDesc(1L, 1)
            .stream()
            .findFirst()
            .get();

        final Post findPost = postRepository.findById(savedPost.getId(), false).get();

        assertThat(findPost.getContents()).isEqualTo(savedPost.getContents());
    }

    @Test
    void findAllByMemberIdOrderByIdDesc() {
        var post1 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        var post2 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        var post3 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 31)).nextObject(Post.class);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        final List<Post> findPosts = postRepository.findAllByMemberIdOrderByIdDesc(
            1L, 3);

        assertThat(findPosts).hasSize(3);
    }

    @Test
    void findAllByInMemberIdOrderByIdDesc() {
        var post1 = PostFixtureFactory.getByCreatedDate(1L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        var post2 = PostFixtureFactory.getByCreatedDate(2L, LocalDate.of(1999, 12, 30)).nextObject(Post.class);
        var post3 = PostFixtureFactory.getByCreatedDate(3L, LocalDate.of(1999, 12, 31)).nextObject(Post.class);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        final List<Post> findPosts = postRepository.findAllByInMemberIdOrderByIdDesc(
            List.of(1L, 2L, 3L), 3);

        assertThat(findPosts).hasSize(3);
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
