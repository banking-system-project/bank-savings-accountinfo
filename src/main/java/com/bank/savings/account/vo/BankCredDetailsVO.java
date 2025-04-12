package com.bank.savings.account.vo;


public class BankCredDetailsVO {

    private String userId;
    private String cifId;
    private String ifscCode;
    private String isSaving;
    private String isJoint;
    private String jointId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCifId() {
        return cifId;
    }

    public void setCifId(String cifId) {
        this.cifId = cifId;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getIsSaving() {
        return isSaving;
    }

    public void setIsSaving(String isSaving) {
        this.isSaving = isSaving;
    }

    public String getJointId() {
        return jointId;
    }

    public void setJointId(String jointId) {
        this.jointId = jointId;
    }

    public String getIsJoint() {
        return isJoint;
    }

    public void setIsJoint(String isJoint) {
        this.isJoint = isJoint;
    }
}
