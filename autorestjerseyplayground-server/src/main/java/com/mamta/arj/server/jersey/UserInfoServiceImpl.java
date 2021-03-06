package com.mamta.arj.server.jersey;

import com.mamta.arj.shared.model.AddressInfo;
import com.mamta.arj.shared.model.UserInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/UserInfoService")
public class UserInfoServiceImpl {

    @GET
    @Path("/userinfo/singleuser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponseSingleUser1() {

        AddressInfo addressInfo = AddressInfo.create("Musterstreet");
        UserInfo userInfo = UserInfo.create("Max", addressInfo);
        return Response.ok().entity(userInfo).build();
    }

}
