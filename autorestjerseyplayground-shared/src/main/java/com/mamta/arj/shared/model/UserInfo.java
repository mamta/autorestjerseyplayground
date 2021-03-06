package com.mamta.arj.shared.model;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, name = "Object", isNative = true)
public class UserInfo {

    @JsProperty
    public String firstName;

    @JsProperty
    public AddressInfo addressInfo;

    public static @JsOverlay UserInfo create(String firstName, AddressInfo addressInfo) {
        UserInfo out = new UserInfo();
        out.firstName = firstName;
        out.addressInfo = addressInfo;
        return out;
    }
}
