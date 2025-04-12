package com.bank.savings.account.mapper;

import com.bank.savings.account.dto.GetJointDetailsOutputDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GetJoinDetailsOutputMapper implements RowMapper {
    public GetJointDetailsOutputDTO mapRow(ResultSet rs, int rowNo) throws SQLException {
        GetJointDetailsOutputDTO getJointDatailsOutputDTO = new GetJointDetailsOutputDTO();
        getJointDatailsOutputDTO.setIsJoint(rs.getString("is_joint"));
        getJointDatailsOutputDTO.setJointId(rs.getString("joint_id"));

        return getJointDatailsOutputDTO;
    }
}
