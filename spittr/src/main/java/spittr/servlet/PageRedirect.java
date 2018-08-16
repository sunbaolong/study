package spittr.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/18
 */
@WebServlet("/PageRedirect")
public class PageRedirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("redirect");

        response.sendRedirect("https://www.baidu.com");

//        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
//        response.setHeader("Location", "https://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
