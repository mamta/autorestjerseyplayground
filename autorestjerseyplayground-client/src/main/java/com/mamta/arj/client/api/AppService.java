package com.mamta.arj.client.api;

import static jsinterop.annotations.JsPackage.GLOBAL;

import com.intendia.gwt.autorest.client.AutoRestGwt;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.reactivex.Observable;
import jsinterop.annotations.JsType;

@AutoRestGwt
@Path("start")
public interface AppService {

    @GET @Path("info") Observable<String> getInfo();

    @GET @Path("greet") Observable<Greeting> getGreeting();

    @JsType(namespace = GLOBAL, name = "Object", isNative = true) class Greeting {
        public String greeting;
    }

}
