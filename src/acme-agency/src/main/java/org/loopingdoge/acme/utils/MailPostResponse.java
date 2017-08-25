
package org.loopingdoge.acme.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MailPostResponse {

    @SerializedName("error")
    @Expose
    private String error;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MailPostResponse() {
    }

    /**
     * 
     * @param error
     */
    public MailPostResponse(String error) {
        super();
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
