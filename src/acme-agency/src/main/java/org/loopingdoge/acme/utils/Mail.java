package org.loopingdoge.acme.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mail {

    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("read")
    @Expose
    private String read;

    /**
     * No args constructor for use in serialization
     */
    public Mail() {
    }

    /**
     * @param to
     * @param text
     * @param read
     * @param from
     */
    public Mail(String from, String to, String text, String read) {
        super();
        this.from = from;
        this.to = to;
        this.text = text;
        this.read = read;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

}
