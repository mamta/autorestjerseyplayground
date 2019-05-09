package com.mamta.arj.shared.model;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, name = "Object", isNative = true)
public class UserInfo {

    @JsProperty
    public native void setFirstName(String firstname);

    @JsProperty
    public native String getFirstName();

}

