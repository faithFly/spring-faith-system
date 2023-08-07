package com.faith.express;

import com.faith.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author:faith
 * @time:2023/5/2413:54
 */
@Component("ex")
public class ExpressRoot {
public boolean hasAuthority(String authority){
    //获取当前权限
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    LoginUser loginUser = (LoginUser) authentication.getPrincipal();
    List<String> permissions = loginUser.getPermissions();
    return permissions.contains(authority);
}
}
