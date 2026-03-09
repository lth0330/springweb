package study.day07.자바참조;


import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Exam1 {

    public static void main(String[] args) {

        // 자바는 객체지향 언어이다.
        // System : 클래스 , System.out : 객체, println() ; 함수
        // 즉] 즉정한 객체가 특정한 함수를 실행한다. // .참조
        // 단방향 : FK 통해 PK를 참조하는 것 처럼, 특정한 객체를 통해 참조 객체를 참조한다.
        // 즉] 게시물 객체를 통해 카테고리 객체를 참조한다. 카테고리객체를 통해 게시물 객체는 참조못한다.

        // [1] 카테고리 객체 생성 == 클래스로 메모리 생성 뜻
        // 동일한 클래스(셀계도)로 서로 다른 객체를 생성한다.
       Category category = new Category();      // 101호
        category.setCno(1); category.setCname("공지사항");

       Category category1 = new Category();     // 102호
        category.setCno(2); category1.setCname("자유게시판");

        // [2] 게시물 객체 생성, 참조란? 다른 값 접근한다.
        // 2-1 : 첫번째 게시물은 공지사항이다.
        Board board = new Board();              // 201호
        board.setBcontent("첫번째 카테고리입니다.");
        board.setCategory(category);

        // 2-2 : 두번째 게시물은 자유게시판이다.
        Board board1 = new Board();             // 202호
        board1.setBcontent("두번째 카테고리입니다.");
        board1.setCategory(category1);

        // [3] 카테고테가 게시물 참조
        // 양방향 : 두 객체간의 서로 참조하는 관계, 데이터베이스는 존재하지 않는다.
        // 즉] ORM(JPA)는 단향방/양방향 모두 지원한다.    특징: 조회가 빠르다.
        category.getBoardList().add(board); // 101호에 201호 참조 대입한다
        category1.getBoardList().add(board1); // 102호에 202호 참조 대입한다.

        // 확인
        // FK에서 PK 단방향 참조/조회
        System.out.println(board1.getCategory());
        // PK 에서 FK 양방향 참조/조회
        System.out.println(category.getBoardList());

    }
}

@Data
class Category{
    private int cno;
    private String cname;
    @ToString.Exclude // 순환참조 방지
    private List<Board> boardList = new ArrayList<>(); // 양방향 목록
}


@Data
class Board{
    private int bno;
    private String bcontent;
    private Category category; // 단방향 참조 , FK 느낌
}
