package org.loopingdoge.acme.model;

import java.io.Serializable;

public class Notary implements Serializable {

    protected String name;

    protected Address address;

    public Notary(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
