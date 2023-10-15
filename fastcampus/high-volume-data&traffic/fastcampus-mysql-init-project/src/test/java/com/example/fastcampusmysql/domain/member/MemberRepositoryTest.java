package com.example.fastcampusmysql.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import com.example.fastcampusmysql.util.MemberFixtureFactory;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void findById() {
        var member = MemberFixtureFactory.getBySeed().nextObject(Member.class);
        var saveMember = memberRepository.save(member);

        var findMember = memberRepository.findById(saveMember.getId()).orElseThrow();

        assertThat(findMember.getEmail()).isEqualTo(saveMember.getEmail());
    }

    @Test
    void findAllByIdIn() {
        var member = MemberFixtureFactory.getBySeed().nextObject(Member.class);
        var saveMember = memberRepository.save(member);

        var findMembers = memberRepository.findAllByIdIn(List.of(saveMember.getId()));
        var findMemberEmails = findMembers.stream().map(Member::getEmail).toList();

        assertThat(findMemberEmails).contains(saveMember.getEmail());
    }

    @Test
    void saveInsert() {
        var member = MemberFixtureFactory.getBySeed().nextObject(Member.class);
        var savedMember = memberRepository.save(member);

        var findMember = memberRepository.findById(savedMember.getId()).orElseThrow();

        assertThat(findMember.getEmail()).isEqualTo(savedMember.getEmail());
    }

    @Test
    void saveUpdate() {
        var member = MemberFixtureFactory.getBySeed().nextObject(Member.class);
        var savedMember = memberRepository.save(member);

        savedMember.changeNickname("test");
        memberRepository.save(savedMember);

        var findMember = memberRepository.findById(savedMember.getId()).orElseThrow();

        assertThat(findMember.getNickname()).isEqualTo(savedMember.getNickname());
    }
}
