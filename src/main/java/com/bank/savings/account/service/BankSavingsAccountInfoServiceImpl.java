package com.bank.savings.account.service;

import com.bank.savings.account.bo.BankSavingsAccountInfoBO;
import com.bank.savings.account.dto.GetFreezeOutputDTO;
import com.bank.savings.account.dto.GetJointDetailsOutputDTO;
import com.bank.savings.account.dto.GetNomineeOutputDTO;
import com.bank.savings.account.util.MapperUtil;
import com.bank.savings.account.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankSavingsAccountInfoServiceImpl implements BankSavingsAccountInfoService{


    private static final Logger logger = LoggerFactory.getLogger(BankSavingsAccountInfoServiceImpl.class);
    @Autowired
    private BankSavingsAccountInfoBO bankSavingsAccountInfoBO;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public GetFreezeOutputVO getFreezeInfoUsingAccountDetails(SavingsAccountInputVO savingsAccountInputVO) {
        logger.info("Service layer: beginning of getFreezeInfoUsingAccountDetails");
        GetFreezeOutputDTO getFreezeOutputDTO = bankSavingsAccountInfoBO.getFreezeInfoUsingAccountDetails(mapperUtil.savingsAccountInputVOtoDTO(savingsAccountInputVO));
        return mapperUtil.getFreezeOutputDTOtoVO(getFreezeOutputDTO);
    }

    @Override
    public GetNomineeOutputVO getNomineeInfoUsingAccountDetails(SavingsAccountInputVO savingsAccountInputVO) {
        logger.info("Service layer: beggining of getNomineeInfoUsingAccountDetails");
        GetNomineeOutputDTO getNomineeOutputDTO = bankSavingsAccountInfoBO.getNomineeInfoUsingAccountDetails(mapperUtil.savingsAccountInputVOtoDTO(savingsAccountInputVO));
        return mapperUtil.getNomineeDTOtoVO(getNomineeOutputDTO);
    }

    @Override
    public GetJointDetailsOutputVO getJointInfoUsingAccountDetails(SavingsAccountInputVO savingsAccountInputVO) {
        logger.info("Service layer: beggining of getJointInfoUsingAccountDetails");
        GetJointDetailsOutputDTO getJointDetailsOutputDTO = bankSavingsAccountInfoBO.getJointInfoUsingAccountDetails(mapperUtil.savingsAccountInputVOtoDTO(savingsAccountInputVO));
        return mapperUtil.getJointDetailsDTOtoVO(getJointDetailsOutputDTO);
    }

    @Override
    public GetSavingsInfoOutputInfoVO getSavingsAccountsInfo(SavingsAccountInputVO savingsAccountInputVO) {
        logger.info("Service layer: beggining of getSavingsAccountsInfo");
        return bankSavingsAccountInfoBO.getSavingsAccountsInfo(savingsAccountInputVO);
    }

    @Override
    public CommonUpdateVO updateFreezeInfo(UpdateFreezeInputVO updateFreezeInputVO) {
        logger.info("Service layer: beggining of updateFreezeInfo");
        return bankSavingsAccountInfoBO.updateFreezeInfo(mapperUtil.updateFreezeInputVOtoDTO(updateFreezeInputVO));
    }

    @Override
    public CommonUpdateVO updateNomineeDetailsInfo(UpdateNomineeInputVO updateNomineeInputVO) {
        logger.info("Service layer: beggining of updateNomineeDetailsInfo");
        return bankSavingsAccountInfoBO.updateNomineeDetailsInfo(mapperUtil.updateNomineeInputVOtoDTO(updateNomineeInputVO));
    }

    @Override
    public CommonUpdateVO createGeneralSavingsAccount(NewAccountInfoInputVO newAccountInfoInputVO){
        logger.info("Service layer: beggining of createGeneralSavingsAccount");
        return bankSavingsAccountInfoBO.createGeneralSavingsAccount(newAccountInfoInputVO);
    }

    @Override
    public CommonUpdateVO createJointSavingsAccount(NewJointAccountInfoInputVO newJointAccountInfoInputVO){
        logger.info("Service layer: beggining of createJointSavingsAccount");
        return bankSavingsAccountInfoBO.createJointSavingsAccount(newJointAccountInfoInputVO);
    }

    @Override
    public CommonUpdateVO deleteSavingsRecord(SavingsAccountInputVO savingsAccountInputVO) {
        logger.info("Service layer: beggining of deleteSavingsRecord");
        return bankSavingsAccountInfoBO.deleteSavingsRecord(mapperUtil.savingsAccountInputVOtoDTO(savingsAccountInputVO));
    }
}
