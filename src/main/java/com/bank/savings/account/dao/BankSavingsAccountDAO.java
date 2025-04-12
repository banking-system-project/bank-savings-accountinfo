package com.bank.savings.account.dao;

import com.bank.savings.account.dto.*;
import com.bank.savings.account.mapper.*;
import com.bank.savings.account.util.SQLQueriesConstant;
import com.bank.savings.account.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class BankSavingsAccountDAO {

    private static final Logger logger = LoggerFactory.getLogger(BankSavingsAccountDAO.class);

    @Autowired
    GetBankSavingsOutputMapper getBankSavingsOutputMapper;

    @Autowired
    GetFreezeOutputMapper getFreezeOutputMapper;

    @Autowired
    GetJoinDetailsOutputMapper getJoinDetailsOutputMapper;

    @Autowired
    GetNomineeOutputMapper getNomineeOutputMapper;

    @Autowired
    GetAccountInfoSpecificMapper getAccountInfoSpecificMapper;

    @Autowired
    AccountDuplicateMapper accountDuplicateMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public GetFreezeOutputDTO getFreezeInfoUsingAccountDetails (SavingsAccountInputDTO savingsAccountInputDTO){
        GetFreezeOutputDTO getFreezeOutputDTO;
        try{
            logger.info("DAO layer: fetching freeze status from savings table");
            getFreezeOutputDTO = (GetFreezeOutputDTO) jdbcTemplate.queryForObject(SQLQueriesConstant.GET_FREEZE_DETAILS, getFreezeOutputMapper, new Object[]{savingsAccountInputDTO.getCifId(), savingsAccountInputDTO.getSmId()});
        } catch (Exception e) {
            logger.error("DAO layer: something went wrong while fetching freeze info");
            throw new RuntimeException(e);
        }
        return getFreezeOutputDTO;
    }

    public GetNomineeOutputDTO getNomineeInfoUsingAccountDetails (SavingsAccountInputDTO savingsAccountInputDTO){
        GetNomineeOutputDTO getNomineeOutputDTO = null;
        try{
            logger.info("DAO layer: fetching nominee status from savings table");
            getNomineeOutputDTO = (GetNomineeOutputDTO) jdbcTemplate.queryForObject(SQLQueriesConstant.GET_NOMINEE_DETAILS, getNomineeOutputMapper, new Object[]{savingsAccountInputDTO.getCifId(), savingsAccountInputDTO.getSmId()});
        } catch (Exception e) {
            logger.error("DAO layer: something went wrong while fetching nominee info");
            throw new RuntimeException(e);
        }
        return getNomineeOutputDTO;
    }

    public GetJointDetailsOutputDTO getJointInfoUsingAccountDetails (SavingsAccountInputDTO savingsAccountInputDTO){
        GetJointDetailsOutputDTO getJointDatailsOutputDTO = null;
        try{
            logger.info("DAO layer: fetching joint info from savings table");
            getJointDatailsOutputDTO = (GetJointDetailsOutputDTO) jdbcTemplate.queryForObject(SQLQueriesConstant.GET_JOINT_DETAILS, getJoinDetailsOutputMapper, new Object[]{savingsAccountInputDTO.getCifId(), savingsAccountInputDTO.getSmId()});
        } catch (Exception e) {
            logger.error("DAO layer: something went wrong while fetching joint info");
            throw new RuntimeException(e);
        }
        return getJointDatailsOutputDTO;
    }

    public GetSavingsInfoOutputInfoVO getSavingsAccountsInfo(SavingsAccountInputVO savingsAccountInputVO){
        GetSavingsInfoOutputInfoVO getSavingsInfoOutputInfoVO = null;
        try{
            logger.info("DAO layer: fetching savings info from savings table");
            getSavingsInfoOutputInfoVO = (GetSavingsInfoOutputInfoVO) jdbcTemplate.queryForObject(SQLQueriesConstant.GET_SAVINGS_ACCOUNTS_INFO, getBankSavingsOutputMapper, new Object[]{savingsAccountInputVO.getCifId(), savingsAccountInputVO.getSmId()});
        } catch (Exception e) {
            logger.error("DAO layer: something went wrong while fetching savings info");
            throw new RuntimeException(e);
        }
        return getSavingsInfoOutputInfoVO;
    }

    public CommonUpdateVO updateFreezeInfo (UpdateFreezeInputDTO updateFreezeInputDTO){
        logger.info("DAO layer: initializing the variables for updating freeze details");
        CommonUpdateVO commonUpdateVO = new CommonUpdateVO();
        GetFreezeOutputDTO getFreezeOutputDTO;
        int result = 0;

        try{
            logger.info("DAO layer: fetching existing freeze status from ");
            getFreezeOutputDTO = (GetFreezeOutputDTO) jdbcTemplate.queryForObject(SQLQueriesConstant.GET_FREEZE_DETAILS, getFreezeOutputMapper,new Object[]{updateFreezeInputDTO.getCifId(), updateFreezeInputDTO.getSmId()});

            if(getFreezeOutputDTO.getIsFreeze().equals(updateFreezeInputDTO.getIsFreeze())){
                logger.error("DAO layer: account is already freeze");
                throw new Exception("Already freeze info updated with requested freeze status");
            }else{
                logger.info("DAO layer: adding nominee details into the savings table");
                result = jdbcTemplate.update(SQLQueriesConstant.UPDATE_FREEZE_DETAILS,
                        updateFreezeInputDTO.getIsFreeze(),
                        updateFreezeInputDTO.getFreezeReason(),
                        updateFreezeInputDTO.getCifId(),
                        updateFreezeInputDTO.getSmId()
                );
            }

            if(result == 0){
                commonUpdateVO.setStatus("Error");
                commonUpdateVO.setMessage("Freeze details update failed due to unwanted issue");
            }else{
                commonUpdateVO.setStatus("completed");
                commonUpdateVO.setMessage("Freeze details updated");
            }

        } catch (Exception e) {
            logger.error("DAO layer: Something went wrong while updating database for freeze detials");
            throw new RuntimeException(e);
        }

        return commonUpdateVO;
    }


    public CommonUpdateVO updateNomineeDetailsInfo(UpdateNomineeInputDTO updateNomineeInputDTO){
        logger.info("DAO layer: initializing the variables for updating nominee details");
        CommonUpdateVO commonUpdateVO = new CommonUpdateVO();
        GetNomineeOutputDTO getNomineeOutputDTO;
        int result = 0;

        try{
            logger.info("DAO layer: fetching existing nominee status from ");
            getNomineeOutputDTO = (GetNomineeOutputDTO) jdbcTemplate.queryForObject(SQLQueriesConstant.GET_NOMINEE_DETAILS, getNomineeOutputMapper,new Object[]{updateNomineeInputDTO.getCifId(), updateNomineeInputDTO.getSmId()});

            if(getNomineeOutputDTO.getIsNominee().equals(updateNomineeInputDTO.getIsNominee())){
                logger.error("DAO layer: already nominee info added");
                throw new Exception("Already nominee info updated with requested joint status");
            }else{
                logger.info("DAO layer: adding nominee details into the savings table");
                result = jdbcTemplate.update(SQLQueriesConstant.UPDATE_NOMINEE_DETAILS,
                        updateNomineeInputDTO.getIsNominee(),
                        updateNomineeInputDTO.getNomineeId(),
                        updateNomineeInputDTO.getNomineeName(),
                        updateNomineeInputDTO.getNomineePhone(),
                        updateNomineeInputDTO.getNomineeAddress(),
                        updateNomineeInputDTO.getCifId(),
                        updateNomineeInputDTO.getSmId()
                );
            }

            if(result == 0){
                commonUpdateVO.setStatus("Error");
                commonUpdateVO.setMessage("Nominee details update failed due to unwanted issue");
            }else{
                commonUpdateVO.setStatus("completed");
                commonUpdateVO.setMessage("Nominee details updated");
            }

        } catch (Exception e) {
            logger.error("DAO layer: Something went wrong while updating database");
            throw new RuntimeException(e);
        }

        return commonUpdateVO;
    }

    public CommonUpdateVO deleteSavingsRecord(SavingsAccountInputDTO savingsAccountInputDTO) {
        logger.info("DAO layer: initializing the variables for deleting savings records");
        CommonUpdateVO commonUpdateVO = new CommonUpdateVO();
        int result1, result2 = 0;

        try{
            logger.info("DAO layer: checking cif id is valid or not before deletion");
            GetSavingsInfoOutputInfoVO getSavingsInfoOutputInfoVO = (GetSavingsInfoOutputInfoVO) jdbcTemplate.queryForObject(SQLQueriesConstant.GET_SAVINGS_ACCOUNTS_INFO, getBankSavingsOutputMapper, new Object[]{savingsAccountInputDTO.getCifId(), savingsAccountInputDTO.getSmId()});

            assert getSavingsInfoOutputInfoVO != null;

            if(getSavingsInfoOutputInfoVO.getJointInfoVO().getIsJoint().equalsIgnoreCase("Y")){
                logger.info("DAO layer: when the account is joint account");
                String accountId = getSavingsInfoOutputInfoVO.getSavingsOfficialVO().getAccountNumber();
                String jointId = getSavingsInfoOutputInfoVO.getJointInfoVO().getJointId();
                logger.info("DAO layer: deleting all accounts associated with the joint id");
                result1 = jdbcTemplate.update(SQLQueriesConstant.DELETE_JOINT_SAVINGS_ACCOUNT,accountId);
                logger.info("DAO layer: updating joint and savings status in crm table");
                result2 = jdbcTemplate.update(SQLQueriesConstant.UPDATE_SAVINGS_JOINT_STATUS_ACCOUNT_LEVEL_FOR_SAVINGS_DELETION, jointId);
            }else{
                logger.info("DAO layer: when non joint account, proceed for deleting the account");
                result1 = jdbcTemplate.update(SQLQueriesConstant.DELETE_SAVINGS_ACCOUNT,
                        savingsAccountInputDTO.getCifId(),
                        savingsAccountInputDTO.getSmId()
                );
                logger.info("DAO layer: updating savings status in crm table");
                result2 = jdbcTemplate.update(SQLQueriesConstant.UPDATE_SAVINGS_STATUS_ACCOUNT_LEVEL_FOR_SAVINGS_DELETION, savingsAccountInputDTO.getCifId());
            }

        } catch (Exception e){
            logger.error("DAO layer: error while updating the table");
            throw new RuntimeException(e);
        }

        if(result1 == 0 && result2 == 0){
            commonUpdateVO.setStatus("Error");
            commonUpdateVO.setMessage("Savings record deletion failed due to unwanted issue");
        }else{
            commonUpdateVO.setStatus("completed");
            commonUpdateVO.setMessage("Savings record deletion successfully completed");
        }

        return commonUpdateVO;
    }

    public CommonUpdateVO createGeneralSavingsAccount(NewAccountInfoInputVO newAccountInfoInputVO){
        logger.info("DAO layer: initialize variables for creating new account record");
        int result1, result2 = 0;
        CommonUpdateVO commonUpdateVO = new CommonUpdateVO();
        try {

            logger.info("DAO Layer:  checking the cif of person is valid or not");
            GetAccountInfoOutputVO getAccountInfoOutputVO = (GetAccountInfoOutputVO) jdbcTemplate.queryForObject(SQLQueriesConstant.SQL_GET_SPECIFIC_ACCOUNT_DETAILS,getAccountInfoSpecificMapper, new Object[]{newAccountInfoInputVO.getCifId()});

            logger.info("DAO layer: checking the cif is valid and no pre existing joint status in crm table");
            if(getAccountInfoOutputVO.getBankCredDetailsVO().getIsSaving()!= null && getAccountInfoOutputVO.getBankCredDetailsVO().getIsSaving().equalsIgnoreCase("N")){

                logger.error("DAO layer: Enter new records into savings table for the customer");
                result1 = jdbcTemplate.update( SQLQueriesConstant.INSERT_NEW_GENERAL_SAVINGS_ACCOUNT,
                        newAccountInfoInputVO.getSmId(), getAccountInfoOutputVO.getBankCredDetailsVO().getUserId(),
                        getAccountInfoOutputVO.getBankCredDetailsVO().getCifId(),
                        getAccountInfoOutputVO.getBankCredDetailsVO().getIfscCode(), newAccountInfoInputVO.getAccountId(),
                        getAccountInfoOutputVO.getUserOfficialInfoVO().getPanId(),
                        getAccountInfoOutputVO.getUserOfficialInfoVO().getEmail(),
                        getAccountInfoOutputVO.getUserDemographicInfoVO().getCustName(),
                        getAccountInfoOutputVO.getUserDemographicInfoVO().getGuardiansName(),
                        getAccountInfoOutputVO.getUserOfficialInfoVO().getPhNo(),
                        getAccountInfoOutputVO.getUserAddressInfoVO().getAddr1(),
                        getAccountInfoOutputVO.getUserAddressInfoVO().getDistrict(),
                        getAccountInfoOutputVO.getUserAddressInfoVO().getPinCode()

                );
                logger.info("DAO layer: checking the data insertion completed or not");
                if(result1 == 1){
                    logger.info("DAO layer: update savings status in CRM table for the customer");
                    result2 = jdbcTemplate.update(SQLQueriesConstant.UPDATE_SAVINGS_DETAILS_IN_CRM_TABLE, newAccountInfoInputVO.getCifId());
                }
            }else{
                logger.error("DAO layer: either the cif is not valid and any pre existing joint status in crm table");
            }
        } catch (RuntimeException e) {
            logger.error("DAO Layer: issue while creating new record");
            throw new RuntimeException(e);
        }
        if (result2 !=0){
            commonUpdateVO.setStatus("success");
            commonUpdateVO.setMessage("Account is created successfully");
        }else{
            commonUpdateVO.setStatus("failure");
            commonUpdateVO.setMessage("Issue while creating new record");
        }

        return commonUpdateVO;
    }

    public CommonUpdateVO createJointSavingsAccount(NewJointAccountInfoInputVO newJointAccountInfoInputVO){
        logger.info("DAO layer: initialize variables for creating new joint account record");
        int result10, result20, result2 = 0;
        String jointId;
        CommonUpdateVO commonUpdateVO = new CommonUpdateVO();

        try{
            logger.info("DAO Layer:  checking the cif of first person is valid or not");
            GetAccountInfoOutputVO getAccount1InfoOutputVO = (GetAccountInfoOutputVO) jdbcTemplate.queryForObject(SQLQueriesConstant.SQL_GET_SPECIFIC_ACCOUNT_DETAILS,getAccountInfoSpecificMapper, new Object[]{newJointAccountInfoInputVO.getCif1Id()});

            logger.info("DAO Layer:  checking the cif of second person is valid or not");
            GetAccountInfoOutputVO getAccount2InfoOutputVO = (GetAccountInfoOutputVO) jdbcTemplate.queryForObject(SQLQueriesConstant.SQL_GET_SPECIFIC_ACCOUNT_DETAILS,getAccountInfoSpecificMapper, new Object[]{newJointAccountInfoInputVO.getCif2Id()});


            logger.info("DAO layer: checking both the cifs are valid and no pre existing joint status in crm table");
            if(getAccount1InfoOutputVO.getBankCredDetailsVO().getIsSaving()!= null && getAccount1InfoOutputVO.getBankCredDetailsVO().getIsSaving().equalsIgnoreCase("N") && getAccount2InfoOutputVO.getBankCredDetailsVO().getIsSaving()!= null && getAccount2InfoOutputVO.getBankCredDetailsVO().getIsSaving().equalsIgnoreCase("N")){
                logger.info("DAO layer: creating a new joint ID before inserting record in savings table");
                jointId = "JN"+newJointAccountInfoInputVO.getAccountId();

                logger.error("DAO layer: Enter new joint records into savings table for customer 1");
                result10 = jdbcTemplate.update( SQLQueriesConstant.INSERT_NEW_JOINT_SAVINGS_ACCOUNT,
                        newJointAccountInfoInputVO.getSm1Id(), getAccount1InfoOutputVO.getBankCredDetailsVO().getUserId(),
                        getAccount1InfoOutputVO.getBankCredDetailsVO().getCifId(),
                        getAccount1InfoOutputVO.getBankCredDetailsVO().getIfscCode(), newJointAccountInfoInputVO.getAccountId(),
                        getAccount1InfoOutputVO.getUserOfficialInfoVO().getPanId(),
                        getAccount1InfoOutputVO.getUserOfficialInfoVO().getEmail(),
                        getAccount1InfoOutputVO.getUserDemographicInfoVO().getCustName(),
                        getAccount1InfoOutputVO.getUserDemographicInfoVO().getGuardiansName(),
                        getAccount1InfoOutputVO.getUserOfficialInfoVO().getPhNo(),
                        getAccount1InfoOutputVO.getUserAddressInfoVO().getAddr1(),
                        getAccount1InfoOutputVO.getUserAddressInfoVO().getDistrict(),
                        getAccount1InfoOutputVO.getUserAddressInfoVO().getPinCode(),
                        jointId

                );

                logger.error("DAO layer: Enter new joint records into savings table for customer 2");
                result20 = jdbcTemplate.update( SQLQueriesConstant.INSERT_NEW_JOINT_SAVINGS_ACCOUNT,
                        newJointAccountInfoInputVO.getSm2Id(), getAccount2InfoOutputVO.getBankCredDetailsVO().getUserId(),
                        getAccount2InfoOutputVO.getBankCredDetailsVO().getCifId(),
                        getAccount2InfoOutputVO.getBankCredDetailsVO().getIfscCode(), newJointAccountInfoInputVO.getAccountId(),
                        getAccount2InfoOutputVO.getUserOfficialInfoVO().getPanId(),
                        getAccount2InfoOutputVO.getUserOfficialInfoVO().getEmail(),
                        getAccount2InfoOutputVO.getUserDemographicInfoVO().getCustName(),
                        getAccount2InfoOutputVO.getUserDemographicInfoVO().getGuardiansName(),
                        getAccount2InfoOutputVO.getUserOfficialInfoVO().getPhNo(),
                        getAccount2InfoOutputVO.getUserAddressInfoVO().getAddr1(),
                        getAccount2InfoOutputVO.getUserAddressInfoVO().getDistrict(),
                        getAccount2InfoOutputVO.getUserAddressInfoVO().getPinCode(),
                        jointId
                );

                logger.info("DAO layer: checking both data insertion completed or not");
                if(result10 == 1 && result20 == 1){
                    logger.info("DAO layer: update savings status in CRM table");
                    result2 = jdbcTemplate.update(SQLQueriesConstant.UPDATE_SAVINGS_DETAILS_IN_CRM_TABLE_FOR_JOINT,
                            jointId,
                            newJointAccountInfoInputVO.getCif1Id(),
                            newJointAccountInfoInputVO.getCif2Id());
                }
            }else{
                logger.error("DAO layer: either both the cifs are not valid and any pre existing joint status in crm table");
            }
        } catch (RuntimeException e) {
            logger.error("DAO Layer: issue while creating new joint record");
            throw new RuntimeException(e);
        }

        if (result2 !=0){
            commonUpdateVO.setStatus("success");
            commonUpdateVO.setMessage("Account is created successfully");
        }else{
            commonUpdateVO.setStatus("failure");
            commonUpdateVO.setMessage("Issue while creating new record");
        }

        return commonUpdateVO;
    }


    public OfficialVO generateOffcialInfo(){

        logger.info("DAO Layer: initialized variables for generating random smId and accountId");
        OfficialVO officialVO = new OfficialVO();
        Random rnd = new Random();
        String smId, accountNo;
        boolean isIdPresent;

        try{
            do{
                logger.info("DAO layer: generating new smID");
                int n = 10000 + rnd.nextInt(90000);
                smId = "SM"+n;
                logger.info("DAO layer: generated smId {}",smId);

                logger.info("DAO Layer: generating new accountId");
                long k = 100000000000L + rnd.nextLong(900000000000L);
                accountNo = String.valueOf(k);
                logger.info("DAO layer: generated account id {} ",accountNo);

                logger.info("DAO Layer: searching the pre-occurances of generated smid and ac_no if any");
                int count = (Integer)  jdbcTemplate.queryForObject(SQLQueriesConstant.ACCOUNT_DUPLICATE, accountDuplicateMapper, new Object[]{smId, accountNo});

                isIdPresent = count > 0;
            }while(isIdPresent);

            logger.info("DAO layer: setting newly generated official info before returning");
            officialVO.setAccountId(accountNo);
            officialVO.setSmId(smId);
            return officialVO;
        } catch (Exception e) {
            logger.error("Something went wrong while generating official info");
            throw new RuntimeException(e);
        }
    }
}
