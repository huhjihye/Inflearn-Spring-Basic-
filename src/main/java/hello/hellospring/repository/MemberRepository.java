package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;
public interface MemberRepository {

    Member save(Member member);  //회원 저장

    Optional<Member> findById(Long id); //id로 회원을 찾음  Optional로 감싸서 반환

    Optional<Member> findByName(String name); // 이름으로 회원을 찾음

    List<Member> findAll(); //저장된 모든 리스트 반환

    void clearStore();
}
