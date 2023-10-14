package com.example.fastcampusmysql.application.usecase;

import com.example.fastcampusmysql.domain.follow.dto.FollowDto;
import com.example.fastcampusmysql.domain.follow.service.FollowReadService;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.service.MemberReadService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetFollowingMemberUseCase {

    private final MemberReadService memberReadService;
    private final FollowReadService followReadService;

    public List<MemberDto> execute(Long memberId) {
        /*
            1. fromMemberId = memberID -> Follow list
            2. 1번을 순회하면서 회원정보를 찾음련 된다!
         */
        var followings = followReadService.getFollowings(memberId);
        var followingMemberIds = followings.stream().map(FollowDto::id).toList();
        return memberReadService.getMembers(followingMemberIds);
    }
}
