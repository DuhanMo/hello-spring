package exam.duhan.hellospring.service;

import exam.duhan.hellospring.domain.Member;
import exam.duhan.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        // 중복검사 중복이름이 있으면 안됨
        validateDuplicate(member);
        memberRepository.save(member);
        return member.getId();
    }

    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    private void validateDuplicate(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            System.out.println(m);
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

}
