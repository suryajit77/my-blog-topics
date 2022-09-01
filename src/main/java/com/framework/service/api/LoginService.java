package com.framework.service.api;

import com.framework.service.BaseService;
import io.restassured.response.Response;

public class LoginService extends BaseService {

    public static final String LOGIN_ROUTE = "/login";

    public Response getLoginResponse(){
        return get(LOGIN_ROUTE);
    }



}
