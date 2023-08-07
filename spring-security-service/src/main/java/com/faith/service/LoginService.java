package com.faith.service;

import com.faith.domain.ResponseResult;
import com.faith.domain.User;

public interface LoginService {
    public ResponseResult login(User user);
    public ResponseResult logout();
}
