package com.bank.savings.account.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountDuplicateMapper implements RowMapper {
    public Integer mapRow(ResultSet rs, int rowNo) throws SQLException {
        return rs.getInt("official_duplicate");
    }
}
