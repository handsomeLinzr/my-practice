package com.example.pattern.delegate.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 委派模式，委派给其他对象执行
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/16 4:01 下午
 * @since V1.0.0
 */
public class DispatcherServlet extends HttpServlet {

    // 策略+委派，封装各个controller的对象，将强求分情况委派给各个controller执行
    private final List<Handler> handlerList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        Class<?> memberControllerClass = MemberController.class;
        Class<?> orderControllerClass = OrderController.class;
        Class<?> systemControllerClass = SystemController.class;
        try {
            handlerList.add(new Handler().setUri("getMemberById")
                    .setController(memberControllerClass.newInstance())
                    .setMethod(memberControllerClass.getMethod("getMemberById", String.class)));
            handlerList.add(new Handler().setUri("getOrderById")
                    .setController(orderControllerClass.newInstance())
                    .setMethod(orderControllerClass.getMethod("getOrderById", String.class)));
            handlerList.add(new Handler().setUri("logout")
                    .setController(systemControllerClass.newInstance())
                    .setMethod(systemControllerClass.getMethod("logout", String.class)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//        String uri = req.getRequestURI();
//        String param = req.getParameter("param");
//        if ("getMemberById".equals(uri)) {
//            new MemberController().getMemberById(param);
//        } else if ("getOrderById".equals(uri)) {
//            new OrderController().getOrderById(param);
//        } else if ("logout".equals(param)) {
//            new SystemController().logout(param);
//        } else {
//            resp.getWriter().write("404, NOT FOUNT");
//        }
        Handler handler = null;
        String uri = req.getRequestURI();
        for (Handler h : handlerList) {
            if (uri.equals(h.uri)) {
                handler = h;
                break;
            }
        }
        if (handler == null) {
            resp.getWriter().write("404, NOT FOUND");
            return;
        }
        Object result = null;
        try {
            result = handler.method.invoke(handler.controller, req.getParameter("param"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.getWriter().write(result.toString());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatch(req, resp);
    }

    private class Handler {
        private String uri;
        private Object controller;
        private Method method;

        public Handler setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }
    }

}
