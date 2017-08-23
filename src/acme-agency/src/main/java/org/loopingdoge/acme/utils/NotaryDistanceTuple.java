package org.loopingdoge.acme.utils;

import org.loopingdoge.acme.model.Notary;

import java.io.Serializable;

public class NotaryDistanceTuple implements Serializable {

    private Notary notary;

    private int distance;

    public NotaryDistanceTuple(Notary notary, int distance) {
        this.notary = notary;
        this.distance = distance;
    }

    public Notary getNotary() {
        return notary;
    }

    public void setNotary(Notary notary) {
        this.notary = notary;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
