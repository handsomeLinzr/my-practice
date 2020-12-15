package com.example.pattern.delegate.mvc;

import com.example.pattern.delegate.mvc.controller.MemberController;
import com.example.pattern.delegate.mvc.controller.OrderController;
import com.example.pattern.delegate.mvc.controller.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 委派模式在servlet中的应用
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/15 4:44 下午
 * @since V1.0.0
 */
public class DispatcherServlet extends HttpServlet {

    // 委派实现，分发uri
    private void dispacter(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String param = req.getParameter("param");
        if ("getMemberById".equals(uri)) {
            resp.getWriter().write(new MemberController().getMemberById(param));
        } else if ("getOrderById".equals(uri)) {
            new OrderController().getOrderById(param);
        } else if ("logout".equals(uri)) {
            new SystemController().logout(param);
        } else {
            resp.getWriter().write("404, NOT FOUND");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispacter(req, resp);
    }
}
