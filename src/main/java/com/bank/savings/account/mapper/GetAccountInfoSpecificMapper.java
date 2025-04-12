package com.bank.savings.account.mapper;

import com.bank.savings.account.vo.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GetAccountInfoSpecificMapper implements RowMapper {
    public GetAccountInfoOutputVO mapRow(ResultSet rs, int rowNo) throws SQLException{

        GetAccountInfoOutputVO getAccountInfoOutputVO =  new GetAccountInfoOutputVO();
        BankCredDetailsVO bankCredDetailsVO = new BankCredDetailsVO();
        UserDemographicInfoVO userDemographicInfoVO = new UserDemographicInfoVO();
        UserOfficialInfoVO userOfficialInfoVO = new UserOfficialInfoVO();
        UserAddressInfoVO userAddressInfoVO = new UserAddressInfoVO();
        UserProfessionalInfoVO userProfessionalInfoVO = new UserProfessionalInfoVO();

        bankCredDetailsVO.setUserId(rs.getString("USER_ID"));
        bankCredDetailsVO.setCifId(rs.getString("CIF_ID"));
        bankCredDetailsVO.setIfscCode(rs.getString("IFSC_CODE"));
        bankCredDetailsVO.setIsSaving(rs.getString("IS_SAVINGS"));
        bankCredDetailsVO.setIsJoint(rs.getString("IS_JOINT"));
        bankCredDetailsVO.setJointId(rs.getString("JOINT_ID"));

        userDemographicInfoVO.setCustName(rs.getString("CUSTOMER_NAME"));
        userDemographicInfoVO.setCustFirstName(rs.getString("CUSTOMER_FIRST_NAME"));
        userDemographicInfoVO.setCustLastName(rs.getString("CUSTOMER_LAT_NAME"));
        userDemographicInfoVO.setMothersName(rs.getString("MOTHERS_NAME"));
        userDemographicInfoVO.setGuardiansName(rs.getString("GUARDIAN_NAME"));
        userDemographicInfoVO.setDob(rs.getString("CUSTOMER_DOB"));
        userDemographicInfoVO.setGender(rs.getString("GENDER"));
        userDemographicInfoVO.setBirthDay(rs.getString("BIRTH_DAY"));
        userDemographicInfoVO.setBirthMonth(rs.getString("BIRTH_MONTH"));
        userDemographicInfoVO.setBirthYear(rs.getString("BIRTH_YEAR"));
        userDemographicInfoVO.setDateOfDeath(rs.getString("DATE_OF_DEATH"));
        userDemographicInfoVO.setCountryOfBirth(rs.getString("COUNTRY_OF_BIRTH"));

        userOfficialInfoVO.setAadhaarNo(rs.getString("AADHAAR_NO"));
        userOfficialInfoVO.setPhNo(rs.getString("PHONE_NO"));
        userOfficialInfoVO.setPanId(rs.getString("PAN_ID"));
        userOfficialInfoVO.setEmail(rs.getString("EMAIL"));
        userOfficialInfoVO.setAltPhNo(rs.getString("ALTERNATE_MOBILE"));
        userOfficialInfoVO.setCustomerType(rs.getString("CUSTOMER_TYPE"));

        userAddressInfoVO.setAddr1(rs.getString("ADDR_1"));
        userAddressInfoVO.setAddr2(rs.getString("ADDR_2"));
        userAddressInfoVO.setDistrict(rs.getString("DISTRICT"));
        userAddressInfoVO.setState(rs.getString("STATE"));
        userAddressInfoVO.setPinCode(rs.getString("PIN_CODE"));

        userProfessionalInfoVO.setEducation(rs.getString("EDUCATION"));
        userProfessionalInfoVO.setOccupation(rs.getString("OCCUPATION"));
        userProfessionalInfoVO.setPrimaryLanguage(rs.getString("PRIMARY_LANGUAGE"));

        getAccountInfoOutputVO.setBankCredDetailsVO(bankCredDetailsVO);
        getAccountInfoOutputVO.setUserDemographicInfoVO(userDemographicInfoVO);
        getAccountInfoOutputVO.setUserOfficialInfoVO(userOfficialInfoVO);
        getAccountInfoOutputVO.setUserAddressInfoVO(userAddressInfoVO);
        getAccountInfoOutputVO.setUserProfessionalInfoVO(userProfessionalInfoVO);

        return getAccountInfoOutputVO;

    }

}
