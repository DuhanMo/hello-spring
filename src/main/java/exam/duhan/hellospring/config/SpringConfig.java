package exam.duhan.hellospring.config;


import exam.duhan.hellospring.repository.MemberRepository;
import exam.duhan.hellospring.repository.MemoryMemberRepository;
import exam.duhan.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
