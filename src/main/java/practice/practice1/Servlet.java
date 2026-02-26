package practice.practice1;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/practice/practice1/servlet")
public class Servlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        System.out.println("init() 실행");
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service() 실행");
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doGet");
        String data = req.getParameter("data");
        int value = Integer.parseInt(data);
        resp.getWriter().println(value+2);
        int value2 =value+2;
        System.out.println("value+2 = " + value2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doPost");
        String data = req.getParameter("data");
        int value = Integer.parseInt(data);
        resp.getWriter().println(value*2);
        int value2 =value*2;
        System.out.println("value+2 = " + value2);
        

        resp.getWriter().println(data);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doPut");
        String data = req.getParameter("data");
        int value = Integer.parseInt(data);
        resp.getWriter().println(value/2);
        int value2 =value/2;
        System.out.println("value+2 = " + value2);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doDelete");
        String data = req.getParameter("data");
        int value = Integer.parseInt(data);
        resp.getWriter().println(value%2);
        int value2 =value%2;
        System.out.println("value+2 = " + value2);
    }
}
