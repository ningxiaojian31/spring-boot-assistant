package cn.zdxh.assistant.interceptor;

import cn.zdxh.assistant.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        User admin = (User)request.getSession().getAttribute("admin");
        if(admin==null){
            response.sendRedirect("/admin/index");
            request.getSession().setAttribute("msg","请登录！");
            return false;
        }

        //session存在即放行
        return true;
    }


}
