package com.bank.savings.account.vo;

public class GetAccountInfoOutputVO {

    private BankCredDetailsVO bankCredDetailsVO;
    private UserDemographicInfoVO userDemographicInfoVO;
    private UserOfficialInfoVO userOfficialInfoVO;
    private UserAddressInfoVO userAddressInfoVO;
    private UserProfessionalInfoVO userProfessionalInfoVO;

    public BankCredDetailsVO getBankCredDetailsVO() {
        return bankCredDetailsVO;
    }

    public void setBankCredDetailsVO(BankCredDetailsVO bankCredDetailsVO) {
        this.bankCredDetailsVO = bankCredDetailsVO;
    }

    public UserDemographicInfoVO getUserDemographicInfoVO() {
        return userDemographicInfoVO;
    }

    public void setUserDemographicInfoVO(UserDemographicInfoVO userDemographicInfoVO) {
        this.userDemographicInfoVO = userDemographicInfoVO;
    }

    public UserOfficialInfoVO getUserOfficialInfoVO() {
        return userOfficialInfoVO;
    }

    public void setUserOfficialInfoVO(UserOfficialInfoVO userOfficialInfoVO) {
        this.userOfficialInfoVO = userOfficialInfoVO;
    }

    public UserAddressInfoVO getUserAddressInfoVO() {
        return userAddressInfoVO;
    }

    public void setUserAddressInfoVO(UserAddressInfoVO userAddressInfoVO) {
        this.userAddressInfoVO = userAddressInfoVO;
    }

    public UserProfessionalInfoVO getUserProfessionalInfoVO() {
        return userProfessionalInfoVO;
    }

    public void setUserProfessionalInfoVO(UserProfessionalInfoVO userProfessionalInfoVO) {
        this.userProfessionalInfoVO = userProfessionalInfoVO;
    }
}
