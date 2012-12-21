package com.appswanted.db.tables.records;

import static com.appswanted.db.tables.Users.Users;
import org.featherj.db.DbRecord;
import java.sql.Timestamp;

public class UsersRecord extends DbRecord {

    public UsersRecord() {
        super(Users);
    }
    
    public UsersRecord(DbRecord innerRecord) {
        super(innerRecord);
    }
    
    public String getDisplayName() {
        return getValue(Users.DisplayName);
    }
    
    public void setDisplayName(String value) {
        setValue(Users.DisplayName, value);
    }
    
    public Timestamp getTs() {
        return getValue(Users.Ts);
    }
    
    public void setTs(Timestamp value) {
        setValue(Users.Ts, value);
    }
    
    public Character getStatus() {
        return getValue(Users.Status);
    }
    
    public void setStatus(Character value) {
        setValue(Users.Status, value);
    }
    
    public Timestamp getRegisterDate() {
        return getValue(Users.RegisterDate);
    }
    
    public void setRegisterDate(Timestamp value) {
        setValue(Users.RegisterDate, value);
    }
    
    public String getEmail() {
        return getValue(Users.Email);
    }
    
    public void setEmail(String value) {
        setValue(Users.Email, value);
    }
    
    public Integer getActivated() {
        return getValue(Users.Activated);
    }
    
    public void setActivated(Integer value) {
        setValue(Users.Activated, value);
    }
    
    public Integer getUserId() {
        return getValue(Users.UserId);
    }
    
    public void setUserId(Integer value) {
        setValue(Users.UserId, value);
    }
    
    public String getActivationCode() {
        return getValue(Users.ActivationCode);
    }
    
    public void setActivationCode(String value) {
        setValue(Users.ActivationCode, value);
    }
    
}