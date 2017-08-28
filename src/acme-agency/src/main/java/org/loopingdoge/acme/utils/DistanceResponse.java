package org.loopingdoge.acme.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistanceResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("distance")
    @Expose
    private String distance;

    /**
     * No args constructor for use in serialization
     */
    public DistanceResponse() {
    }

    /**
     * @param message
     * @param distance
     */
    public DistanceResponse(String message, String distance) {
        super();
        this.message = message;
        this.distance = distance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

}
