package com.project.accounts.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BranchAddress {
    @JsonProperty("Bangalore")
    BANGALORE("Bangalore"),
    @JsonProperty("Chennai")
    CHENNAI("Chennai"),
    @JsonProperty("Delhi")
    HYDERABAD("Hyderabad"),
    @JsonProperty("Kolkata")
    MUMBAI("Mumbai"),
    @JsonProperty("Pune")
    PUNE("Pune");

    private final String address;

    BranchAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
