package com.bank.savings.account.controller;

import com.bank.savings.account.service.BankSavingsAccountInfoServiceImpl;
import com.bank.savings.account.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/savings/account/info")
public class BankSavingsAccountInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BankSavingsAccountInfoController.class);

    @Autowired
    private BankSavingsAccountInfoServiceImpl bankSavingsAccountInfoService;

    @PostMapping("/getFreezeInfo")
    public ResponseEntity<GetFreezeOutputVO>  getFreezeInfoUsingAccountDetails(@RequestBody SavingsAccountInputVO savingsAccountInputVO){
        logger.info("Beginning of Controller layer: calling service layer to get freeze info");
        GetFreezeOutputVO getFreezeOutputVO = bankSavingsAccountInfoService.getFreezeInfoUsingAccountDetails(savingsAccountInputVO);
        return new ResponseEntity<>(getFreezeOutputVO, HttpStatus.OK);
    }

    @PostMapping("/getNomineeInfo")
    public ResponseEntity<GetNomineeOutputVO> getNomineeInfoUsingAccountDetails(@RequestBody SavingsAccountInputVO savingsAccountInputVO){
        logger.info("Beginning of Controller layer: calling service layer to get nominee info");
        GetNomineeOutputVO getNomineeOutputVO = bankSavingsAccountInfoService.getNomineeInfoUsingAccountDetails(savingsAccountInputVO);
        logger.info("controller layer: ending of getNomineeInfoUsingAccountDetails");
        return new ResponseEntity<>(getNomineeOutputVO, HttpStatus.OK);
    }

    @PostMapping("/getJointInfo")
    public ResponseEntity<GetJointDetailsOutputVO> getJointInfoUsingAccountDetails(@RequestBody SavingsAccountInputVO savingsAccountInputVO){
        logger.info("Beginning of Controller layer: calling service layer to get joint info");
        GetJointDetailsOutputVO getJointDetailsOutputVO = bankSavingsAccountInfoService.getJointInfoUsingAccountDetails(savingsAccountInputVO);
        logger.info("controller layer: ending of getJointInfoUsingAccountDetails");
        return new ResponseEntity<>(getJointDetailsOutputVO, HttpStatus.OK);
    }

    @PostMapping("/getSavingsAccountsInfo")
    public ResponseEntity<GetSavingsInfoOutputInfoVO> getSavingsAccountsInfo(@RequestBody SavingsAccountInputVO savingsAccountInputVO){
        logger.info("Beginning of Controller layer: calling service layer to get savings account info");
        GetSavingsInfoOutputInfoVO getSavingsInfoOutputInfoVO = bankSavingsAccountInfoService.getSavingsAccountsInfo(savingsAccountInputVO);
        logger.info("controller layer: ending of getSavingsAccountsInfo");
        return new ResponseEntity<>(getSavingsInfoOutputInfoVO, HttpStatus.OK);
    }

    @PutMapping("/updateFreezeInfo")
    public ResponseEntity<CommonUpdateVO> updateFreezeInfo(@RequestBody UpdateFreezeInputVO updateFreezeInputVO){
        logger.info("Beginning of Controller layer: calling service layer to update freeze info");
        CommonUpdateVO commonUpdateVO = bankSavingsAccountInfoService.updateFreezeInfo(updateFreezeInputVO);
        logger.info("controller layer: ending of updateFreezeInfo");
        return new ResponseEntity<>(commonUpdateVO, HttpStatus.OK);
    }

    @PutMapping("/updateNomineeDetailsInfo")
    public ResponseEntity<CommonUpdateVO> updateNomineeDetailsInfo(@RequestBody UpdateNomineeInputVO updateNomineeInputVO){
        logger.info("Beginning of Controller layer: calling service layer to update nominee info");
        CommonUpdateVO commonUpdateVO = bankSavingsAccountInfoService.updateNomineeDetailsInfo(updateNomineeInputVO);
        logger.info("controller layer: ending of updateNomineeDetailsInfo");
        return new ResponseEntity<>(commonUpdateVO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteSavingsRecord")
    public ResponseEntity<CommonUpdateVO> deleteSavingsRecord(@RequestBody SavingsAccountInputVO savingsAccountInputVO){
        logger.info("Beginning of Controller layer: calling service layer to delete savings records");
        CommonUpdateVO commonUpdateVO = bankSavingsAccountInfoService.deleteSavingsRecord(savingsAccountInputVO);
        logger.info("controller layer: ending of deleteSavingsRecord");
        return new ResponseEntity<>(commonUpdateVO, HttpStatus.OK);
    }

    @PostMapping("/createNewSavingsAccount")
    public ResponseEntity<CommonUpdateVO> createGeneralSavingsAccount(@RequestBody NewAccountInfoInputVO newAccountInfoInputVO){
        logger.info("Beginning of Controller layer: calling service layer to create new savings record info");
        CommonUpdateVO commonUpdateVO = bankSavingsAccountInfoService.createGeneralSavingsAccount(newAccountInfoInputVO);
        logger.info("controller layer: ending of createGeneralSavingsAccount");
        return new ResponseEntity<>(commonUpdateVO, HttpStatus.OK);
    }

    @PostMapping("/createNewJointSavingsAccount")
    public ResponseEntity<CommonUpdateVO> createJointSavingsAccount(@RequestBody NewJointAccountInfoInputVO newJointAccountInfoInputVO){
        logger.info("Beginning of Controller layer: calling service layer to create new joint savings info");
        CommonUpdateVO commonUpdateVO = bankSavingsAccountInfoService.createJointSavingsAccount(newJointAccountInfoInputVO);
        logger.info("controller layer: ending of createJointSavingsAccount");
        return new ResponseEntity<>(commonUpdateVO, HttpStatus.OK);
    }
}
