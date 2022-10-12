package solo.solospring.repository;

import solo.solospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {     // member에는 이미 name이 넘어온 상태
        member.setId(++sequence);           // sequence를 하나 증가시키고 id에 세팅
        store.put(member.getId(),member);   // store에 id와 name을 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 결과가 없을수도 있는데 이거 처리할때 Optional로 감싸줌(처리방식중 하나) ofNullable 은 null이여도 감쌀수 있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // (람다형식) 루프를 돌림
                .filter(member -> member.getName().equals(name)) //파라미터랑 getName값이랑 같으면 반환
                .findAny(); // 하나라도 있으면 반환

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store는 Map형식이지만 List형식으로 쓰인 메소드니 List로 만들어줌
    }

    // 이후 제대로 됬는지 검증을 해야함 => 테스트코드 작성
}
