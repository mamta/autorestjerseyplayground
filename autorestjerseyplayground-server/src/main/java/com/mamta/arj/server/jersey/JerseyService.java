package com.mamta.arj.server.jersey;

import com.mamta.arj.shared.model.UserInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.reactivex.Observable;

@Path("/AppService")
public class JerseyService {

    private static final String GREETING = "\"greeting\"";

    private static final String GREET = "\"Hello\"";

    @GET
    @Path("/start/greet")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContainer() {
        return Response.ok().entity("[{" + GREETING + ":" + GREET + "}]").build();
    }

    @GET
    @Path("/start/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponseSingleUser() {
        Observable<String> observer = Observable.just("Hello Reactive");
        return Response.ok().entity(observer).build();
    }

}
