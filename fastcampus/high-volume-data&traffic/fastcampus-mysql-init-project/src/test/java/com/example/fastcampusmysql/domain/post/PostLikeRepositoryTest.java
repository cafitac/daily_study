package com.example.fastcampusmysql.domain.post;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.fastcampusmysql.domain.post.entity.PostLike;
import com.example.fastcampusmysql.domain.post.repository.PostLikeRepository;
import com.example.fastcampusmysql.util.PostLikeFixtureFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class PostLikeRepositoryTest {

    @Autowired
    private PostLikeRepository postLikeRepository;

    @Test
    void saveInsert() {
        var postLike = PostLikeFixtureFactory.get(1L).nextObject(PostLike.class);
        var savePostLike = postLikeRepository.save(postLike);

        var findPostLike = postLikeRepository.findById(savePostLike.getId()).get();

        assertThat(findPostLike.getId()).isEqualTo(savePostLike.getId());
    }

    @Test
    void count() {
        var postLike1 = PostLikeFixtureFactory.get(1L).nextObject(PostLike.class);
        postLikeRepository.save(postLike1);
        var postLike2 = PostLikeFixtureFactory.get(1L).nextObject(PostLike.class);
        postLikeRepository.save(postLike2);

        var postLikeCount = postLikeRepository.count(1L);

        assertThat(postLikeCount).isEqualTo(2);
    }
}
