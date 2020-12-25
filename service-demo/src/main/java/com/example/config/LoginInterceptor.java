package com.example.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accessKeyId = request.getHeader("accessKeyId");
        String accessKeySecret = request.getHeader("accessKeySecret");

        if (null == accessKeyId || "".equals(accessKeyId) || null == accessKeySecret || "".equals(accessKeySecret)) {
            error(response,"缺少头部信息");
            return false;
        }
        return super.preHandle(request, response, handler);
    }

    /**
     * 错误信息
     *
     * @param response
     * @param msg
     */
    private void error(HttpServletResponse response, String msg) {
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "application/json");
        try {
            PrintWriter writer = response.getWriter();
            //将返回的错误提示压入流中
            writer.write(msg);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
