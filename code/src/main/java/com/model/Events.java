package com.model;

import java.util.Date;

public class Events {
    private String EVENT_CATALOG;

    private String EVENT_SCHEMA;

    private String EVENT_NAME;

    private String DEFINER;

    private String TIME_ZONE;

    private String EVENT_BODY;

    private String EVENT_TYPE;

    private Date EXECUTE_AT;

    private String INTERVAL_VALUE;

    private String INTERVAL_FIELD;

    private String SQL_MODE;

    private Date STARTS;

    private Date ENDS;

    private String STATUS;

    private String ON_COMPLETION;

    private Date CREATED;

    private Date LAST_ALTERED;

    private Date LAST_EXECUTED;

    private String EVENT_COMMENT;

    private Long ORIGINATOR;

    private String CHARACTER_SET_CLIENT;

    private String COLLATION_CONNECTION;

    private String DATABASE_COLLATION;

    private String EVENT_DEFINITION;

    public String getEVENT_CATALOG() {
        return EVENT_CATALOG;
    }

    public void setEVENT_CATALOG(String EVENT_CATALOG) {
        this.EVENT_CATALOG = EVENT_CATALOG == null ? null : EVENT_CATALOG.trim();
    }

    public String getEVENT_SCHEMA() {
        return EVENT_SCHEMA;
    }

    public void setEVENT_SCHEMA(String EVENT_SCHEMA) {
        this.EVENT_SCHEMA = EVENT_SCHEMA == null ? null : EVENT_SCHEMA.trim();
    }

    public String getEVENT_NAME() {
        return EVENT_NAME;
    }

    public void setEVENT_NAME(String EVENT_NAME) {
        this.EVENT_NAME = EVENT_NAME == null ? null : EVENT_NAME.trim();
    }

    public String getDEFINER() {
        return DEFINER;
    }

    public void setDEFINER(String DEFINER) {
        this.DEFINER = DEFINER == null ? null : DEFINER.trim();
    }

    public String getTIME_ZONE() {
        return TIME_ZONE;
    }

    public void setTIME_ZONE(String TIME_ZONE) {
        this.TIME_ZONE = TIME_ZONE == null ? null : TIME_ZONE.trim();
    }

    public String getEVENT_BODY() {
        return EVENT_BODY;
    }

    public void setEVENT_BODY(String EVENT_BODY) {
        this.EVENT_BODY = EVENT_BODY == null ? null : EVENT_BODY.trim();
    }

    public String getEVENT_TYPE() {
        return EVENT_TYPE;
    }

    public void setEVENT_TYPE(String EVENT_TYPE) {
        this.EVENT_TYPE = EVENT_TYPE == null ? null : EVENT_TYPE.trim();
    }

    public Date getEXECUTE_AT() {
        return EXECUTE_AT;
    }

    public void setEXECUTE_AT(Date EXECUTE_AT) {
        this.EXECUTE_AT = EXECUTE_AT;
    }

    public String getINTERVAL_VALUE() {
        return INTERVAL_VALUE;
    }

    public void setINTERVAL_VALUE(String INTERVAL_VALUE) {
        this.INTERVAL_VALUE = INTERVAL_VALUE == null ? null : INTERVAL_VALUE.trim();
    }

    public String getINTERVAL_FIELD() {
        return INTERVAL_FIELD;
    }

    public void setINTERVAL_FIELD(String INTERVAL_FIELD) {
        this.INTERVAL_FIELD = INTERVAL_FIELD == null ? null : INTERVAL_FIELD.trim();
    }

    public String getSQL_MODE() {
        return SQL_MODE;
    }

    public void setSQL_MODE(String SQL_MODE) {
        this.SQL_MODE = SQL_MODE == null ? null : SQL_MODE.trim();
    }

    public Date getSTARTS() {
        return STARTS;
    }

    public void setSTARTS(Date STARTS) {
        this.STARTS = STARTS;
    }

    public Date getENDS() {
        return ENDS;
    }

    public void setENDS(Date ENDS) {
        this.ENDS = ENDS;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    public String getON_COMPLETION() {
        return ON_COMPLETION;
    }

    public void setON_COMPLETION(String ON_COMPLETION) {
        this.ON_COMPLETION = ON_COMPLETION == null ? null : ON_COMPLETION.trim();
    }

    public Date getCREATED() {
        return CREATED;
    }

    public void setCREATED(Date CREATED) {
        this.CREATED = CREATED;
    }

    public Date getLAST_ALTERED() {
        return LAST_ALTERED;
    }

    public void setLAST_ALTERED(Date LAST_ALTERED) {
        this.LAST_ALTERED = LAST_ALTERED;
    }

    public Date getLAST_EXECUTED() {
        return LAST_EXECUTED;
    }

    public void setLAST_EXECUTED(Date LAST_EXECUTED) {
        this.LAST_EXECUTED = LAST_EXECUTED;
    }

    public String getEVENT_COMMENT() {
        return EVENT_COMMENT;
    }

    public void setEVENT_COMMENT(String EVENT_COMMENT) {
        this.EVENT_COMMENT = EVENT_COMMENT == null ? null : EVENT_COMMENT.trim();
    }

    public Long getORIGINATOR() {
        return ORIGINATOR;
    }

    public void setORIGINATOR(Long ORIGINATOR) {
        this.ORIGINATOR = ORIGINATOR;
    }

    public String getCHARACTER_SET_CLIENT() {
        return CHARACTER_SET_CLIENT;
    }

    public void setCHARACTER_SET_CLIENT(String CHARACTER_SET_CLIENT) {
        this.CHARACTER_SET_CLIENT = CHARACTER_SET_CLIENT == null ? null : CHARACTER_SET_CLIENT.trim();
    }

    public String getCOLLATION_CONNECTION() {
        return COLLATION_CONNECTION;
    }

    public void setCOLLATION_CONNECTION(String COLLATION_CONNECTION) {
        this.COLLATION_CONNECTION = COLLATION_CONNECTION == null ? null : COLLATION_CONNECTION.trim();
    }

    public String getDATABASE_COLLATION() {
        return DATABASE_COLLATION;
    }

    public void setDATABASE_COLLATION(String DATABASE_COLLATION) {
        this.DATABASE_COLLATION = DATABASE_COLLATION == null ? null : DATABASE_COLLATION.trim();
    }

    public String getEVENT_DEFINITION() {
        return EVENT_DEFINITION;
    }

    public void setEVENT_DEFINITION(String EVENT_DEFINITION) {
        this.EVENT_DEFINITION = EVENT_DEFINITION == null ? null : EVENT_DEFINITION.trim();
    }
}