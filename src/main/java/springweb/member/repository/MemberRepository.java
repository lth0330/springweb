package springweb.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springweb.member.entity.MemberEntity;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {

    // [1] 아이디로 앤티티 찾기
    // findBy필드명( 값 ) : 필드명 카멜규칙!!!
    Optional<MemberEntity> findByMid(String mid);

    // 또는 @Query를 사용해서 쿼리문 작성  ,  필드가 복잡할때 사용
}
