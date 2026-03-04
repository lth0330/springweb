package study.day05.mvc;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // 해당 객체는 데이타베이스 연동을 하겠다는 뜻
@Table(name = "exam") // 데이터베이스에서 데이블명 정의

// 롬북
@Data
@AllArgsConstructor
@NoArgsConstructor



public class ExamEntity {
    @Id // primary key 적용하겠다는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 적용하겠다는 뜻
    private Integer eno;

    @Column(name = "ename", length = 255,nullable = false) // 테이블 필드 속성
    private String ename;
}
// Entity 데이스베이스와 객체 간 연동 객체