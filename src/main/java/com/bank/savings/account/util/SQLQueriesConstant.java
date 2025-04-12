package com.bank.savings.account.util;

public class SQLQueriesConstant {

    public static final String GET_SAVINGS_ACCOUNTS_INFO = "select * from bank_savings_accounts where cif_id = ? and sm_id = ?;";

    public static final  String GET_FREEZE_DETAILS = "select if_freeze, freeze_reason from  bank_savings_accounts " +
                                                        "where cif_id = ? and sm_id = ?;";

    public static final String UPDATE_FREEZE_DETAILS = "update bank_savings_accounts " +
                                                        "set if_freeze = ? , freeze_reason = ?" +
                                                        " where cif_id = ? and sm_id = ?;";

    public static final String GET_NOMINEE_DETAILS = "select is_nominee, nominee_id, nominee_name, nominee_phone, nominee_address " +
                                                     "from  bank_savings_accounts " +
                                                     "where cif_id = ? and sm_id = ?;";

    public static final String UPDATE_NOMINEE_DETAILS = "update bank_savings_accounts set " +
                                                        "is_nominee = ?, nominee_id = ?, nominee_name = ?, nominee_phone = ?, nominee_address = ? " +
                                                        "where cif_id = ? and sm_id = ?;";

    public static final String GET_JOINT_DETAILS = "select is_joint, joint_id from  bank_savings_accounts " +
                                                    "where cif_id = ? and sm_id = ?;";

    public static final String DELETE_SAVINGS_ACCOUNT = "delete from bank_savings_accounts " +
                                                        "where cif_id = ? and sm_id = ?;";

    public static final String UPDATE_SAVINGS_STATUS_ACCOUNT_LEVEL_FOR_SAVINGS_DELETION = "update crmuser_accounts set is_savings = 'N' where cif_id = ? ;";

    public static final String INSERT_NEW_GENERAL_SAVINGS_ACCOUNT = "Insert into bank_savings_accounts " +
            "(sm_id, user_id, cif_id, ifsc_code, account_no, pan_id, email, " +
            "account_name, guardian_name, phone_no, address, district, pin_code, " +
            "date_of_issue, is_joint, joint_id, is_nominee, nominee_id, nominee_name, " +
            "nominee_phone, nominee_address, current_balance, interest_rate, " +
            "if_freeze, freeze_reason, last_transaction_date, last_update_on, currency) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?, current_date(), 'N','','N','','','','',0.0,5,'N','',current_timestamp(), current_timestamp(),'USD');";

    public static final String SQL_GET_SPECIFIC_ACCOUNT_DETAILS = "select * from crmuser_accounts where cif_id = ? ;";

    public static final String UPDATE_SAVINGS_DETAILS_IN_CRM_TABLE = "update crmuser_accounts set is_savings = 'Y' where cif_id = ? ;";
    public static final String UPDATE_SAVINGS_DETAILS_IN_CRM_TABLE_FOR_JOINT = "update crmuser_accounts set is_savings = 'Y', is_joint = 'Y', joint_id = ? where cif_id in (?, ?) ;";

    public static final String ACCOUNT_DUPLICATE = "select count(*) as official_duplicate from bank_savings_accounts where sm_id = ? and account_no = ?";

    public static final String INSERT_NEW_JOINT_SAVINGS_ACCOUNT = "Insert into bank_savings_accounts " +
            "(sm_id, user_id, cif_id, ifsc_code, account_no, pan_id, email, " +
            "account_name, guardian_name, phone_no, address, district, pin_code, " +
            "date_of_issue, is_joint, joint_id, is_nominee, nominee_id, nominee_name, " +
            "nominee_phone, nominee_address, current_balance, interest_rate, " +
            "if_freeze, freeze_reason, last_transaction_date, last_update_on, currency) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?, current_date(), 'Y',?,'N','','','','',0.0,5,'N','',current_timestamp(), current_timestamp(),'USD');";

    public static final String DELETE_JOINT_SAVINGS_ACCOUNT = "delete from bank_savings_accounts " +
                                                                "where account_no = ?;";

    public static final String UPDATE_SAVINGS_JOINT_STATUS_ACCOUNT_LEVEL_FOR_SAVINGS_DELETION = "update crmuser_accounts set is_savings = 'N', is_joint = 'N', joint_id = '' " +
                                                                                                "where joint_id = ? ;";
}
    