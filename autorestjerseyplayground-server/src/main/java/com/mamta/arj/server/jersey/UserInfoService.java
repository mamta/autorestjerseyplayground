package com.mamta.arj.server.jersey;

import com.mamta.arj.shared.model.UserInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.reactivex.Observable;

@Path("/UserInfoService")
public class UserInfoService {

    @GET
    @Path("/userinfo/singleuser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponseSingleUser1() {

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName("Mamta");

        return Response.ok().entity(userInfo).build();
    }

}
