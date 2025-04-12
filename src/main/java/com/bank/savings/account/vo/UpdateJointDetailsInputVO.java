package com.bank.savings.account.vo;

public class UpdateJointDetailsInputVO {
    private String isJoint;
    private String jointId;
    private String cifId;
    private String smId;

    public String getCifId() {
        return cifId;
    }

    public void setCifId(String cifId) {
        this.cifId = cifId;
    }

    public String getSmId() {
        return smId;
    }

    public void setSmId(String smId) {
        this.smId = smId;
    }

    public String getIsJoint() {
        return isJoint;
    }

    public void setIsJoint(String isJoint) {
        this.isJoint = isJoint;
    }

    public String getJointId() {
        return jointId;
    }

    public void setJointId(String jointId) {
        this.jointId = jointId;
    }
}
