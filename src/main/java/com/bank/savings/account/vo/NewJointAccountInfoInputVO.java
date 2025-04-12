package com.bank.savings.account.vo;

public class NewJointAccountInfoInputVO {
    private String sm1Id;
    private String sm2Id;
    private String accountId;
    private String cif1Id;
    private String cif2Id;
    private String jointId;

    public String getSm1Id() {
        return sm1Id;
    }

    public void setSm1Id(String sm1Id) {
        this.sm1Id = sm1Id;
    }

    public String getSm2Id() {
        return sm2Id;
    }

    public void setSm2Id(String sm2Id) {
        this.sm2Id = sm2Id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCif1Id() {
        return cif1Id;
    }

    public void setCif1Id(String cif1Id) {
        this.cif1Id = cif1Id;
    }

    public String getCif2Id() {
        return cif2Id;
    }

    public void setCif2Id(String cif2Id) {
        this.cif2Id = cif2Id;
    }

    public String getJointId() {
        return jointId;
    }

    public void setJointId(String jointId) {
        this.jointId = jointId;
    }
}
