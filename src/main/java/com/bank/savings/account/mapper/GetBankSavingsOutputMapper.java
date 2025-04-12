package com.bank.savings.account.mapper;

import com.bank.savings.account.vo.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GetBankSavingsOutputMapper implements RowMapper {
    public GetSavingsInfoOutputInfoVO mapRow(ResultSet rs, int rowNo) throws SQLException {
        GetSavingsInfoOutputInfoVO getSavingsInfoOutputInfoVO = new GetSavingsInfoOutputInfoVO();
        SavingsOfficialVO savingsOfficialVO = new SavingsOfficialVO();
        SavingsCustomerInfoVO savingsCustomerInfoVO = new SavingsCustomerInfoVO();
        JointInfoVO jointInfoVO = new JointInfoVO();
        NomineeInfoVO nomineeInfoVO = new NomineeInfoVO();
        FreezeInfoVO freezeInfoVO = new FreezeInfoVO();
        SavingsAccountInfoVO savingsAccountInfoVO = new SavingsAccountInfoVO();

        savingsOfficialVO.setAccountNumber(rs.getString("account_no"));
        savingsOfficialVO.setCifId(rs.getString("cif_id"));
        savingsOfficialVO.setDateOfIssue(rs.getString("date_of_issue"));
        savingsOfficialVO.setIfscCode(rs.getString("ifsc_code"));
        savingsOfficialVO.setSmId(rs.getString("sm_id"));
        savingsOfficialVO.setPanNumber(rs.getString("pan_id"));
        savingsOfficialVO.setUserId(rs.getString("user_id"));


        savingsCustomerInfoVO.setAccountName(rs.getString("account_name"));
        savingsCustomerInfoVO.setGuardianName(rs.getString("guardian_name"));
        savingsCustomerInfoVO.setAddress(rs.getString("address"));
        savingsCustomerInfoVO.setDistrict(rs.getString("district"));
        savingsCustomerInfoVO.setState(rs.getString("state"));
        savingsCustomerInfoVO.setPin(rs.getString("pin_code"));
        savingsCustomerInfoVO.setPhNo(rs.getString("phone_no"));
        savingsCustomerInfoVO.setEmail(rs.getString("email"));

        jointInfoVO.setIsJoint(rs.getString("is_joint"));
        jointInfoVO.setJointId(rs.getString("joint_id"));

        nomineeInfoVO.setIsNominee(rs.getString("is_nominee"));
        nomineeInfoVO.setNomineeAddress(rs.getString("nominee_address"));
        nomineeInfoVO.setNomineeId(rs.getString("nominee_id"));
        nomineeInfoVO.setNomineePhone(rs.getString("nominee_phone"));
        nomineeInfoVO.setNomineeName(rs.getString("nominee_name"));

        freezeInfoVO.setFreezeReason(rs.getString("freeze_reason"));
        freezeInfoVO.setIsFreeze(rs.getString("if_freeze"));

        savingsAccountInfoVO.setCurrency(rs.getString("currency"));
        savingsAccountInfoVO.setCurrentBal(rs.getString("current_balance"));
        savingsAccountInfoVO.setInterestRate(rs.getString("interest_rate"));
        savingsAccountInfoVO.setLastUpdate(rs.getString("last_update_on"));
        savingsAccountInfoVO.setLastTransaction(rs.getString("last_transaction_date"));

        getSavingsInfoOutputInfoVO.setFreezeInfoVO(freezeInfoVO);
        getSavingsInfoOutputInfoVO.setJointInfoVO(jointInfoVO);
        getSavingsInfoOutputInfoVO.setSavingsAccountInfoVO(savingsAccountInfoVO);
        getSavingsInfoOutputInfoVO.setNomineeInfoVO(nomineeInfoVO);
        getSavingsInfoOutputInfoVO.setSavingsCustomerInfoVO(savingsCustomerInfoVO);
        getSavingsInfoOutputInfoVO.setSavingsOfficialVO(savingsOfficialVO);

        return getSavingsInfoOutputInfoVO;

    }
}
