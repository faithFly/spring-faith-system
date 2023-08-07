package com.faith.handle;

import com.alibaba.fastjson.JSON;
import com.faith.domain.ResponseResult;
import com.faith.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author:faith
 * @time:2023/5/249:41
 */
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult res = new ResponseResult(HttpStatus.FORBIDDEN.value(),"权限不足！");
        String json = JSON.toJSONString(res);
        WebUtils.renderString(response,json);
    }
}
