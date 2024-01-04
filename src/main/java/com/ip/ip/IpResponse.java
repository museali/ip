package com.ip.ip;


import com.fasterxml.jackson.annotation.JsonProperty;

public class IpResponse {

    @JsonProperty("ip")
    private String ip;

    // Default constructor required for deserialization
    public IpResponse() {
    }

    // Constructors, getters, and setters

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
