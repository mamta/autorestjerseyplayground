package com.mamta.arj.shared.model;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, name = "Object", isNative = true)
public class AddressInfo {

    @JsProperty
    public String streetName;

    public static @JsOverlay AddressInfo create(String streetName) {
        AddressInfo out = new AddressInfo();
        out.streetName = streetName;
        return out;
    }
}

