package example.day02.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

// 서블릿이란? 자바 회사에서 HTTP웹 동적처리를 하기위한 라이브러리/클래스 (라이브러리)
// 사용법
    // 1. 현재 클래스의 "HttpServlet 클래스로부터 상속 받는다.
    // 2. 현재 클래스 위에 @WebServlet("/URL") 주소 설정.  중복없이 아무거나(한글은 되도록이면 뺴고) 가능
    // 3. (스프링 환경에만 해당) AppStart 클래스 위에 @ServletComponentScan 주입하여 스프링이 서블릿을 찾을 수 있도록 한다.
@WebServlet("/day02/servlet") // localhost:8080/day02/servlet 요청 시 통신이 가능한 클래스 정의
public class ServletController extends HttpServlet {

    // 순수 자바의 메소드/함수
    boolean metod(int param){
        return true;
    };

    // 1. 서블릿 클래슬부터 HTTP 요청 시 init함수 최초 1번 실행
    @Override
    public void init() throws ServletException {
        System.out.println("init() 함수 실행");
        super.init();
    }

    // 2. 서블릿 클래스로부터 HTTP 요청마다 service 함수 실행
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service함수 실행");
        super.service(req, res);
    }
}
