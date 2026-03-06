package example.종합.예제10.board;


import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@MappedSuperclass  // 해당 클래스는 상속할때 앤티티 매핑 퐆함
@Getter     // 룸북 : 상속받은 클래스가 맴버변수 접근 허용
@EntityListeners(AuditingEntityListener.class)  // 해당 클래스 JPA 감지 설정
public class BaseTime {

    @CreatedDate
    private LocalDate createDate;   // 생성 닐짜/시간

    @LastModifiedDate
    private LocalDate updateDate;   // 수정 날짜/시간
}
