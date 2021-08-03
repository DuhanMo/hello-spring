package exam.duhan.hellospring.config;


import exam.duhan.hellospring.repository.JpaMemberRepository;
import exam.duhan.hellospring.repository.MemberRepository;
import exam.duhan.hellospring.repository.MemoryMemberRepository;
import exam.duhan.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource datasource;
    private final EntityManager em;

    public SpringConfig(DataSource datasource, EntityManager em) {
        this.datasource = datasource;
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}
