package com.bank.savings.account.vo;

public class UserOfficialInfoVO {

    private String aadhaarNo;
    private String panId;
    private String email;
    private String phNo;
    private String altPhNo;
    private String CustomerType;

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getPanId() {
        return panId;
    }

    public void setPanId(String panId) {
        this.panId = panId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getAltPhNo() {
        return altPhNo;
    }

    public void setAltPhNo(String altPhNo) {
        this.altPhNo = altPhNo;
    }

    public String getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(String customerType) {
        CustomerType = customerType;
    }
}
