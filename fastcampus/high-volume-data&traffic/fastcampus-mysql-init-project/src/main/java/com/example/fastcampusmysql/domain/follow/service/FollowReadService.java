package com.example.fastcampusmysql.domain.follow.service;

import com.example.fastcampusmysql.domain.follow.dto.FollowDto;
import com.example.fastcampusmysql.domain.follow.entity.Follow;
import com.example.fastcampusmysql.domain.follow.repository.FollowRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FollowReadService {

    private final FollowRepository followRepository;

    public List<FollowDto> getFollowings(Long memberId) {
        return followRepository.findAllByFromMemberId(memberId)
            .stream()
            .map(this::toDto)
            .toList();
    }

    public List<FollowDto> getFollowers(Long memberId) {
        return followRepository.findAllByToMemberId(memberId)
            .stream()
            .map(this::toDto)
            .toList();
    }

    private FollowDto toDto(Follow follow) {
        return new FollowDto(follow.getId(), follow.getFromMemberId(), follow.getToMemberId(),
            follow.getCreatedAt());
    }
}
