package org.example;

public class User {
    private String sso;
    private String userType;
    private String bsId;
    private String quoteNumber;
    private String timestamp;
    private String opportunityId;
    private String addressCmatIds;

    public User(String sso, String userType, String bsId, String quoteNumber, String timestamp, String opportunityId, String addressCmatIds) {
        this.sso = sso;
        this.userType = userType;
        this.bsId = bsId;
        this.quoteNumber = quoteNumber;
        this.timestamp = timestamp;
        this.opportunityId = opportunityId;
        this.addressCmatIds = addressCmatIds;
    }

    public String getUserString() {
        return "sso=" + sso + "&userType=" + userType + "&bsId=" + bsId + "&quoteNumber=" + quoteNumber + "&timestamp=" + timestamp + "&sfdcOpportunityId=" + opportunityId + "&addressCMATIds=" + addressCmatIds;
    }
}
