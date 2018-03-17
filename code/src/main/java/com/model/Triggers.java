package com.model;

import java.util.Date;

public class Triggers {
    private String TRIGGER_CATALOG;

    private String TRIGGER_SCHEMA;

    private String TRIGGER_NAME;

    private String EVENT_MANIPULATION;

    private String EVENT_OBJECT_CATALOG;

    private String EVENT_OBJECT_SCHEMA;

    private String EVENT_OBJECT_TABLE;

    private Long ACTION_ORDER;

    private String ACTION_ORIENTATION;

    private String ACTION_TIMING;

    private String ACTION_REFERENCE_OLD_TABLE;

    private String ACTION_REFERENCE_NEW_TABLE;

    private String ACTION_REFERENCE_OLD_ROW;

    private String ACTION_REFERENCE_NEW_ROW;

    private Date CREATED;

    private String SQL_MODE;

    private String DEFINER;

    private String CHARACTER_SET_CLIENT;

    private String COLLATION_CONNECTION;

    private String DATABASE_COLLATION;

    private String ACTION_CONDITION;

    private String ACTION_STATEMENT;

    public String getTRIGGER_CATALOG() {
        return TRIGGER_CATALOG;
    }

    public void setTRIGGER_CATALOG(String TRIGGER_CATALOG) {
        this.TRIGGER_CATALOG = TRIGGER_CATALOG == null ? null : TRIGGER_CATALOG.trim();
    }

    public String getTRIGGER_SCHEMA() {
        return TRIGGER_SCHEMA;
    }

    public void setTRIGGER_SCHEMA(String TRIGGER_SCHEMA) {
        this.TRIGGER_SCHEMA = TRIGGER_SCHEMA == null ? null : TRIGGER_SCHEMA.trim();
    }

    public String getTRIGGER_NAME() {
        return TRIGGER_NAME;
    }

    public void setTRIGGER_NAME(String TRIGGER_NAME) {
        this.TRIGGER_NAME = TRIGGER_NAME == null ? null : TRIGGER_NAME.trim();
    }

    public String getEVENT_MANIPULATION() {
        return EVENT_MANIPULATION;
    }

    public void setEVENT_MANIPULATION(String EVENT_MANIPULATION) {
        this.EVENT_MANIPULATION = EVENT_MANIPULATION == null ? null : EVENT_MANIPULATION.trim();
    }

    public String getEVENT_OBJECT_CATALOG() {
        return EVENT_OBJECT_CATALOG;
    }

    public void setEVENT_OBJECT_CATALOG(String EVENT_OBJECT_CATALOG) {
        this.EVENT_OBJECT_CATALOG = EVENT_OBJECT_CATALOG == null ? null : EVENT_OBJECT_CATALOG.trim();
    }

    public String getEVENT_OBJECT_SCHEMA() {
        return EVENT_OBJECT_SCHEMA;
    }

    public void setEVENT_OBJECT_SCHEMA(String EVENT_OBJECT_SCHEMA) {
        this.EVENT_OBJECT_SCHEMA = EVENT_OBJECT_SCHEMA == null ? null : EVENT_OBJECT_SCHEMA.trim();
    }

    public String getEVENT_OBJECT_TABLE() {
        return EVENT_OBJECT_TABLE;
    }

    public void setEVENT_OBJECT_TABLE(String EVENT_OBJECT_TABLE) {
        this.EVENT_OBJECT_TABLE = EVENT_OBJECT_TABLE == null ? null : EVENT_OBJECT_TABLE.trim();
    }

    public Long getACTION_ORDER() {
        return ACTION_ORDER;
    }

    public void setACTION_ORDER(Long ACTION_ORDER) {
        this.ACTION_ORDER = ACTION_ORDER;
    }

    public String getACTION_ORIENTATION() {
        return ACTION_ORIENTATION;
    }

    public void setACTION_ORIENTATION(String ACTION_ORIENTATION) {
        this.ACTION_ORIENTATION = ACTION_ORIENTATION == null ? null : ACTION_ORIENTATION.trim();
    }

    public String getACTION_TIMING() {
        return ACTION_TIMING;
    }

    public void setACTION_TIMING(String ACTION_TIMING) {
        this.ACTION_TIMING = ACTION_TIMING == null ? null : ACTION_TIMING.trim();
    }

    public String getACTION_REFERENCE_OLD_TABLE() {
        return ACTION_REFERENCE_OLD_TABLE;
    }

    public void setACTION_REFERENCE_OLD_TABLE(String ACTION_REFERENCE_OLD_TABLE) {
        this.ACTION_REFERENCE_OLD_TABLE = ACTION_REFERENCE_OLD_TABLE == null ? null : ACTION_REFERENCE_OLD_TABLE.trim();
    }

    public String getACTION_REFERENCE_NEW_TABLE() {
        return ACTION_REFERENCE_NEW_TABLE;
    }

    public void setACTION_REFERENCE_NEW_TABLE(String ACTION_REFERENCE_NEW_TABLE) {
        this.ACTION_REFERENCE_NEW_TABLE = ACTION_REFERENCE_NEW_TABLE == null ? null : ACTION_REFERENCE_NEW_TABLE.trim();
    }

    public String getACTION_REFERENCE_OLD_ROW() {
        return ACTION_REFERENCE_OLD_ROW;
    }

    public void setACTION_REFERENCE_OLD_ROW(String ACTION_REFERENCE_OLD_ROW) {
        this.ACTION_REFERENCE_OLD_ROW = ACTION_REFERENCE_OLD_ROW == null ? null : ACTION_REFERENCE_OLD_ROW.trim();
    }

    public String getACTION_REFERENCE_NEW_ROW() {
        return ACTION_REFERENCE_NEW_ROW;
    }

    public void setACTION_REFERENCE_NEW_ROW(String ACTION_REFERENCE_NEW_ROW) {
        this.ACTION_REFERENCE_NEW_ROW = ACTION_REFERENCE_NEW_ROW == null ? null : ACTION_REFERENCE_NEW_ROW.trim();
    }

    public Date getCREATED() {
        return CREATED;
    }

    public void setCREATED(Date CREATED) {
        this.CREATED = CREATED;
    }

    public String getSQL_MODE() {
        return SQL_MODE;
    }

    public void setSQL_MODE(String SQL_MODE) {
        this.SQL_MODE = SQL_MODE == null ? null : SQL_MODE.trim();
    }

    public String getDEFINER() {
        return DEFINER;
    }

    public void setDEFINER(String DEFINER) {
        this.DEFINER = DEFINER == null ? null : DEFINER.trim();
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

    public String getACTION_CONDITION() {
        return ACTION_CONDITION;
    }

    public void setACTION_CONDITION(String ACTION_CONDITION) {
        this.ACTION_CONDITION = ACTION_CONDITION == null ? null : ACTION_CONDITION.trim();
    }

    public String getACTION_STATEMENT() {
        return ACTION_STATEMENT;
    }

    public void setACTION_STATEMENT(String ACTION_STATEMENT) {
        this.ACTION_STATEMENT = ACTION_STATEMENT == null ? null : ACTION_STATEMENT.trim();
    }
}