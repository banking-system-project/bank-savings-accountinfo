package com.bank.savings.account.util;

import com.bank.savings.account.dto.*;
import com.bank.savings.account.vo.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperUtil {
    public GetFreezeOutputDTO getFreezeOutputVOtoDTO(GetFreezeOutputVO getFreezeOutputVO);
    public GetFreezeOutputVO getFreezeOutputDTOtoVO(GetFreezeOutputDTO getFreezeOutputDTO);
    public GetJointDetailsOutputDTO getJointDetailsVOtoDTO(GetJointDetailsOutputVO getJointDetailsOutputVO);
    public GetJointDetailsOutputVO getJointDetailsDTOtoVO(GetJointDetailsOutputDTO getJointDetailsOutputDTO);
    public GetNomineeOutputDTO getNomineeVOtoDTO (GetNomineeOutputVO getNomineeOutputVO);
    public GetNomineeOutputVO getNomineeDTOtoVO (GetNomineeOutputDTO getNomineeOutputDTO);
    public SavingsAccountInputDTO savingsAccountInputVOtoDTO(SavingsAccountInputVO savingsAccountInputVO);
    public SavingsAccountInputVO savingsAccountInputDTOtoVO(SavingsAccountInputDTO savingsAccountInputDTO);
    public UpdateFreezeInputDTO updateFreezeInputVOtoDTO(UpdateFreezeInputVO updateFreezeInputVO);
    public UpdateFreezeInputVO updateFreezeInputDTOtoVO(UpdateFreezeInputDTO updateFreezeInputDTO);
    public UpdateJointDetailsInputDTO updateJointDetailsInputVOtoDTO(UpdateJointDetailsInputVO updateJointDetailsInputVO);
    public UpdateJointDetailsInputVO updateJointDetailsInputDTOtoVO(UpdateJointDetailsInputDTO updateJointDetailsInputDTO);
    public UpdateNomineeInputDTO updateNomineeInputVOtoDTO(UpdateNomineeInputVO updateNomineeInputVO);
    public UpdateNomineeInputVO updateNomineeInputDTOtoVO(UpdateNomineeInputDTO updateNomineeInputDTO);
}
