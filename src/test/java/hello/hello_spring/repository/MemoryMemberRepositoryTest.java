package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("test");

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();

//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("test1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        memoryMemberRepository.save(member2);

        Member result = memoryMemberRepository.findByName("test1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("test1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        memoryMemberRepository.save(member2);

        List<Member> results= memoryMemberRepository.findAll();

        assertThat(results.size()).isEqualTo(3);
    }
}
