package com.yfy.beem.client.datamodel;

import lombok.Getter;
import lombok.Setter;
import retrofit.RetrofitError;

import java.net.InetAddress;
import java.security.interfaces.RSAPublicKey;

@Getter
public class User {
    private final long id;
    @Setter
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
