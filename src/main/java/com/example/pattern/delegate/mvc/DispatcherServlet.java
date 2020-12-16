package com.example.pattern.delegate.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 委派模式，委派给其他对象执行
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/16 4:01 下午
 * @since V1.0.0
 */
public class DispatcherServlet extends HttpServlet {


    private void dispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String uri = req.getRequestURI();
        String param = req.getParameter("param");
        if ("getMemberById".equals(uri)) {
            new MemberController().getMemberById(param);
        } else if ("getOrderById".equals(uri)) {
            new OrderController().getOrderById(param);
        } else if ("logout".equals(param)) {
            new SystemController().logout(param);
        } else {
            resp.getWriter().write("404, NOT FOUNT");
        }
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatch(req, resp);
    }
}
