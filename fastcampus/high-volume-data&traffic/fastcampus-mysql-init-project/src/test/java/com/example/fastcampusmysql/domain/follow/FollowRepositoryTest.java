package com.example.fastcampusmysql.domain.follow;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.fastcampusmysql.domain.follow.entity.Follow;
import com.example.fastcampusmysql.domain.follow.repository.FollowRepository;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class FollowRepositoryTest {

    private final Random random = new Random();
    @Autowired
    private FollowRepository followRepository;

    @Test
    void findById() {
        var follow = Follow.builder()
            .fromMemberId(1L)
            .toMemberId(2L)
            .build();
        var savedFollow = followRepository.save(follow);

        var findFollow = followRepository.findById(savedFollow.getId());

        assertThat(findFollow).isEqualTo(savedFollow);
    }

    @Test
    void findAllByFromMemberId() {
        final long fromMemberId = random.nextInt();

        IntStream.range(0, 2)
            .forEach(i -> {
                var follow = Follow.builder()
                    .fromMemberId(fromMemberId)
                    .toMemberId((long) random.nextInt())
                    .build();
                followRepository.save(follow);
            });

        var follows = followRepository.findAllByFromMemberId(fromMemberId);

        assertThat(follows).hasSize(2);
    }

    @Test
    void findAllByToMemberId() {
        final long toMemberId = random.nextInt();

        IntStream.range(0, 2)
            .forEach(i -> {
                var follow = Follow.builder()
                    .fromMemberId((long) random.nextInt())
                    .toMemberId(toMemberId)
                    .build();
                followRepository.save(follow);
            });

        var follows = followRepository.findAllByToMemberId(toMemberId);

        assertThat(follows).hasSize(2);
    }

    @Test
    void saveInsert() {
        var follow = Follow.builder()
            .fromMemberId(1L)
            .toMemberId(2L)
            .build();
        var savedFollow = followRepository.save(follow);

        var findFollow = followRepository.findById(savedFollow.getId());

        assertThat(findFollow).isEqualTo(savedFollow);
    }

    @Test
    void saveUpdateUnsupported() {
        var follow = Follow.builder()
            .id(1L)
            .fromMemberId(1L)
            .toMemberId(2L)
            .build();

        assertThatThrownBy(() -> {
            followRepository.save(follow);
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
