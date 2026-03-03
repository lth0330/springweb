package example.종합.예제9.model.dao;

import example.종합.예제9.model.dto.BoardDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component // 빈등록
public class BoardDao {
    public BoardDao(){connect();}

    private String url = "jdbc:mysql://localhost:3306/boardservice9";
    private String user = "root";
    private String password = "1234";

    // 2) 연동 인터페이스 변수 선언
    Connection conn;

    // 3) 연동 함수 정의, dao에
    private void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("=======연동 성공=======");
        }catch (Exception e) {
            System.out.println("등록된 DB 서버로 연동 실패 : 관리자에게 문의");
        }
    }

    // 1] 전체 조회
    public List<BoardDto> findAll(){
        List<BoardDto> list = new ArrayList<>();
        try{
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                BoardDto boardDto = new BoardDto(
                        rs.getInt("bno") , rs.getString("bcontent") ,
                        rs.getString("bwriter") , rs.getString("bdate") );
                list.add(boardDto);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }


    // 2. 등록

    public boolean writer(BoardDto boardDto){
        try{
            String sql = "insert into board( bcontent , bwriter) values( ? , ? ) "; // 1] SQL 작성한다.
            PreparedStatement ps = conn.prepareStatement( sql );    // 2] SQL 등록한다.
            ps.setString( 1 , boardDto.getBcontent() ); // 3] SQL 첫번째 매개변수? 에 값 대입한다.
            ps.setString( 2 , boardDto.getBwriter() ); // 3] SQL 첫번째 매개변수? 에 값 대입한다.
            int count = ps.executeUpdate();             // 4] SQL 실행하고 반영한 레코드 수 저장한다.
            if( count == 1 ) return true ;              // 5] 반영한 레코드수가 1개이면 성
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    // 3. 게심물 개별 수정

    public boolean update(BoardDto boardDto){
        try {
            String sql = "update board set bcontent =? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setInt(2,boardDto.getBno());
            int count = ps.executeUpdate();
            if(count == 1)return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    // 4. 게시물 개별삭제
    public boolean delete(int bno) {

        try {String sql = "delete from board where bno = ? ";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setInt( 1 , bno );
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        } catch (Exception e) {    System.out.println(e);  }
        return false;
    }

}


