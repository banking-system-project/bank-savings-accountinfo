package com.bank.savings.account.mapper;

import com.bank.savings.account.dto.GetNomineeOutputDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GetNomineeOutputMapper implements RowMapper {
    public GetNomineeOutputDTO mapRow(ResultSet rs, int rowNo) throws SQLException {
        GetNomineeOutputDTO getNomineeOutputDTO = new GetNomineeOutputDTO();
        getNomineeOutputDTO.setIsNominee(rs.getString("is_nominee"));
        getNomineeOutputDTO.setNomineeId(rs.getString("nominee_id"));
        getNomineeOutputDTO.setNomineeName(rs.getString("nominee_name"));
        getNomineeOutputDTO.setNomineePhone(rs.getString("nominee_phone"));
        getNomineeOutputDTO.setNomineeAddress(rs.getString("nominee_address"));

        return getNomineeOutputDTO;
    }
}
