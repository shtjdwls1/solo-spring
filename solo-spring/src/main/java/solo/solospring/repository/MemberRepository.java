package solo.solospring.repository;

import solo.solospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);  // null일수도 있는데 null을 처리하는 방법중 Optional로 감싸서 처리하기 위해
    List<Member> findAll();
}
