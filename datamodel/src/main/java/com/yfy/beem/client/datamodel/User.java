package com.yfy.beem.client.datamodel;

import lombok.Getter;

import java.net.InetAddress;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;

@Getter
public class User {
    private final long id;
    private String name;
    private final InetAddress address;
    private final RSAPublicKey publicKey;

    public User(long id, String name, InetAddress address, RSAPublicKey publicKey) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.publicKey = publicKey;

    }

}
