package com.ale.minichat.service;

import com.ale.minichat.entity.RefreshToken;
import com.ale.minichat.entity.User;
import com.ale.minichat.mapper.input.RefreshTokenInput;
import com.ale.minichat.mapper.view.AccessToken;
import com.ale.minichat.util.exception.AppException;

public interface RefreshTokenService {
    AccessToken createAccessToken(RefreshTokenInput refreshTokenInput) throws AppException;
    RefreshToken createRefreshToken(User user);
}
