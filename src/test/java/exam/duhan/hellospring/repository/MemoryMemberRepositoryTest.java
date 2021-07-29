package exam.duhan.hellospring.repository;

import exam.duhan.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @Test
    void save() {

        //given
        Member member = new Member();
        member.setName("spring");

        //when
        memoryMemberRepository.save(member);

        //then
        Member result = memoryMemberRepository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);


    }

    @Test
    void findById() {

        //given
        Member member1= new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        //when
        Member result = memoryMemberRepository.findById(member1.getId()).get();

        //then
        assertThat(result).isEqualTo(member1);

    }

    @Test
    void findByName() {
        //given
        Member member1= new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        //when
        Member result = memoryMemberRepository.findByName("spring1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {

        //given
        Member member1= new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

       //when
        List<Member> result = memoryMemberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);

    }
}