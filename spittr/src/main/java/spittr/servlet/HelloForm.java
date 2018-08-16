package spittr.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/17
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        Cookie usernasme = new Cookie("usernasme", "voodoo");
        Cookie url = new Cookie("url", "http://localhost:8080");
        usernasme.setMaxAge(60 * 60 * 24);
        url.setMaxAge(60 * 60 * 24);
        resp.addCookie(usernasme);
        resp.addCookie(url);

        PrintWriter out = resp.getWriter();
        String title = "使用 GET 方法读取表单数据";
        // 处理中文
        String name =new String(req.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名</b>："
                + name + "\n" +
                "  <li><b>网址</b>："
                + req.getParameter("url") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
