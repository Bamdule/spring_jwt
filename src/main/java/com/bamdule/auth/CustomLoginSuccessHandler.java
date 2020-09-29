package com.bamdule.auth;

import com.bamdule.enums.AuthConstants;
import com.bamdule.model.UserVO;
import com.bamdule.util.TokenUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) {
        UserVO userVO = ((UserDetailsVO) authentication.getPrincipal()).getUserVO();
        String token = TokenUtils.generateJwtToken(userVO);
        response.addHeader(AuthConstants.AUTH_HEADER.toString(), AuthConstants.TOKEN_TYPE.toString() + " " + token);
    }

}
