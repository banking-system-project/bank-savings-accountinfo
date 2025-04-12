package com.bank.savings.account.mapper;

import com.bank.savings.account.dto.GetFreezeOutputDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GetFreezeOutputMapper implements RowMapper {
    public GetFreezeOutputDTO mapRow(ResultSet rs, int rowNo) throws SQLException {
        GetFreezeOutputDTO getFreezeOutputDTO = new GetFreezeOutputDTO();
        getFreezeOutputDTO.setIsFreeze(rs.getString("if_freeze"));
        getFreezeOutputDTO.setFreezeReason(rs.getString("freeze_reason"));

        return getFreezeOutputDTO;
    }
}
