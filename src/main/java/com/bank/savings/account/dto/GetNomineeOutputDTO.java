package com.bank.savings.account.dto;

public class GetNomineeOutputDTO {
    private String isNominee;
    private String nomineeId;
    private String nomineeName;
    private String nomineePhone;
    private String nomineeAddress;


    public String getIsNominee() {
        return isNominee;
    }

    public void setIsNominee(String isNominee) {
        this.isNominee = isNominee;
    }

    public String getNomineeId() {
        return nomineeId;
    }

    public void setNomineeId(String nomineeId) {
        this.nomineeId = nomineeId;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineePhone() {
        return nomineePhone;
    }

    public void setNomineePhone(String nomineePhone) {
        this.nomineePhone = nomineePhone;
    }

    public String getNomineeAddress() {
        return nomineeAddress;
    }

    public void setNomineeAddress(String nomineeAddress) {
        this.nomineeAddress = nomineeAddress;
    }
}
