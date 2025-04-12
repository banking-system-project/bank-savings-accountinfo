package com.bank.savings.account.service;

import com.bank.savings.account.vo.*;

public interface BankSavingsAccountInfoService {

    public GetFreezeOutputVO getFreezeInfoUsingAccountDetails (SavingsAccountInputVO savingsAccountInputVO);

    public GetNomineeOutputVO getNomineeInfoUsingAccountDetails (SavingsAccountInputVO savingsAccountInputVO);

    public GetJointDetailsOutputVO getJointInfoUsingAccountDetails (SavingsAccountInputVO savingsAccountInputVO);

    public GetSavingsInfoOutputInfoVO getSavingsAccountsInfo(SavingsAccountInputVO savingsAccountInputVO);

    public CommonUpdateVO updateFreezeInfo (UpdateFreezeInputVO updateFreezeInputVO);

    public CommonUpdateVO updateNomineeDetailsInfo(UpdateNomineeInputVO updateNomineeInputVO);

    public CommonUpdateVO deleteSavingsRecord(SavingsAccountInputVO savingsAccountInputVO) ;

    public CommonUpdateVO createGeneralSavingsAccount(NewAccountInfoInputVO newAccountInfoInputVO);

    public CommonUpdateVO createJointSavingsAccount(NewJointAccountInfoInputVO newJointAccountInfoInputVO);
}
