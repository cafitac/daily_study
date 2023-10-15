package com.example.fastcampusmysql.application.usecase;

import com.example.fastcampusmysql.domain.follow.dto.FollowDto;
import com.example.fastcampusmysql.domain.follow.service.FollowReadService;
import com.example.fastcampusmysql.domain.post.dto.PostCommand;
import com.example.fastcampusmysql.domain.post.service.PostWriteService;
import com.example.fastcampusmysql.domain.post.service.TimelineWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreatePostUseCase {

    private final PostWriteService postWriteService;
    private final FollowReadService followReadService;
    private final TimelineWriteService timelineWriteService;

    @Transactional
    public Long execute(PostCommand postCommand) {
        var postId = postWriteService.create(postCommand);

        var followerMemberId = followReadService
            .getFollowers(postCommand.memberId())
            .stream()
            .map(FollowDto::fromMemberId)
            .toList();
        timelineWriteService.deliveryToTimeline(postId, followerMemberId);

        return postId;
    }
}
