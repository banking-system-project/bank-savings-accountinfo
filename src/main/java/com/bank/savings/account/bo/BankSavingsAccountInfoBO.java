package com.bank.savings.account.bo;

import com.bank.savings.account.dao.BankSavingsAccountDAO;
import com.bank.savings.account.dto.*;
import com.bank.savings.account.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankSavingsAccountInfoBO {


    private static final Logger log = LoggerFactory.getLogger(BankSavingsAccountInfoBO.class);
    @Autowired
    private BankSavingsAccountDAO bankSavingsAccountDAO;

    public GetFreezeOutputDTO getFreezeInfoUsingAccountDetails (SavingsAccountInputDTO savingsAccountInputDTO){
        log.info("BO layer: beginning of getFreezeInfoUsingAccountDetails");
        return bankSavingsAccountDAO.getFreezeInfoUsingAccountDetails(savingsAccountInputDTO);
    }

    public GetNomineeOutputDTO getNomineeInfoUsingAccountDetails (SavingsAccountInputDTO savingsAccountInputDTO){
        log.info("BO layer: beginning of getNomineeInfoUsingAccountDetails");
        return bankSavingsAccountDAO.getNomineeInfoUsingAccountDetails(savingsAccountInputDTO);
    }

    public GetJointDetailsOutputDTO getJointInfoUsingAccountDetails (SavingsAccountInputDTO savingsAccountInputDTO){
        log.info("BO layer: beginning of getJointInfoUsingAccountDetails");
        return bankSavingsAccountDAO.getJointInfoUsingAccountDetails(savingsAccountInputDTO);
    }

    public GetSavingsInfoOutputInfoVO getSavingsAccountsInfo(SavingsAccountInputVO savingsAccountInputVO){
        log.info("BO layer: beginning of getSavingsAccountsInfo");
        return bankSavingsAccountDAO.getSavingsAccountsInfo(savingsAccountInputVO);
    }

    public CommonUpdateVO updateFreezeInfo (UpdateFreezeInputDTO updateFreezeInputDTO){
        log.info("BO layer: beginning of updateFreezeInfo");
        return bankSavingsAccountDAO.updateFreezeInfo(updateFreezeInputDTO);
    }

    public CommonUpdateVO createGeneralSavingsAccount(NewAccountInfoInputVO newAccountInfoInputVO){
        log.info("BO layer: beginning of createGeneralSavingsAccount");
        OfficialVO officialVO = bankSavingsAccountDAO.generateOffcialInfo();
        log.info("BO layer: creating new accountid and smid for the new record for createGeneralSavingsAccount");
        newAccountInfoInputVO.setAccountId(officialVO.getAccountId());
        newAccountInfoInputVO.setSmId(officialVO.getSmId());
        log.info("BO layer: ending of createGeneralSavingsAccount");
        return bankSavingsAccountDAO.createGeneralSavingsAccount(newAccountInfoInputVO);
    }

    public CommonUpdateVO createJointSavingsAccount(NewJointAccountInfoInputVO newJointAccountInfoInputVO){
        log.info("BO layer: beginning of createJointSavingsAccount");
        OfficialVO officialVO = bankSavingsAccountDAO.generateOffcialInfo();
        log.info("BO layer: creating new accountid and smid for the customer 1 for createJointSavingsAccount");
        newJointAccountInfoInputVO.setAccountId(officialVO.getAccountId());
        newJointAccountInfoInputVO.setSm1Id(officialVO.getSmId());

        officialVO = bankSavingsAccountDAO.generateOffcialInfo();
        log.info("BO layer: creating new accountid and smid for the customer 2 for createJointSavingsAccount");
        newJointAccountInfoInputVO.setSm2Id(officialVO.getSmId());

        log.info("BO layer: ending of createJointSavingsAccount");
        return bankSavingsAccountDAO.createJointSavingsAccount(newJointAccountInfoInputVO);
    }

    public CommonUpdateVO updateNomineeDetailsInfo(UpdateNomineeInputDTO updateNomineeInputDTO){
        log.info("BO layer: beginning of updateNomineeDetailsInfo");
        return bankSavingsAccountDAO.updateNomineeDetailsInfo(updateNomineeInputDTO);
    }

    public CommonUpdateVO deleteSavingsRecord(SavingsAccountInputDTO savingsAccountInputDTO) {
        log.info("BO layer: beginning of deleteSavingsRecord");
        return bankSavingsAccountDAO.deleteSavingsRecord(savingsAccountInputDTO);
    }
}
