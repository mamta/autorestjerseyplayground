package com.mamta.arj.client.api;

import com.intendia.gwt.autorest.client.AutoRestGwt;
import com.mamta.arj.shared.model.UserInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.reactivex.Observable;
import io.reactivex.Single;

@AutoRestGwt
@Path("userinfo")
public interface UserInfoService {


    @GET
    @Path("/singleuser")
    Single<UserInfo> getUserInfo();

    @GET
    @Path("/info")
    Observable<String> getInfo();
}

