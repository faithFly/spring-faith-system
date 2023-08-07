package com.faith.handle;

import com.alibaba.fastjson.JSON;
import com.faith.domain.ResponseResult;
import com.faith.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author:faith
 * @time:2023/5/249:38
 */
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult res = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"用户认证失败！");
        String json = JSON.toJSONString(res);
        WebUtils.renderString(response,json);
    }
}
