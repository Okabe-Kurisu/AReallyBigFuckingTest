package com.model;

import java.util.Date;

public class Partitions {
    private String TABLE_CATALOG;

    private String TABLE_SCHEMA;

    private String TABLE_NAME;

    private String PARTITION_NAME;

    private String SUBPARTITION_NAME;

    private Long PARTITION_ORDINAL_POSITION;

    private Long SUBPARTITION_ORDINAL_POSITION;

    private String PARTITION_METHOD;

    private String SUBPARTITION_METHOD;

    private Long TABLE_ROWS;

    private Long AVG_ROW_LENGTH;

    private Long DATA_LENGTH;

    private Long MAX_DATA_LENGTH;

    private Long INDEX_LENGTH;

    private Long DATA_FREE;

    private Date CREATE_TIME;

    private Date UPDATE_TIME;

    private Date CHECK_TIME;

    private Long CHECKSUM;

    private String PARTITION_COMMENT;

    private String NODEGROUP;

    private String TABLESPACE_NAME;

    private String PARTITION_EXPRESSION;

    private String SUBPARTITION_EXPRESSION;

    private String PARTITION_DESCRIPTION;

    public String getTABLE_CATALOG() {
        return TABLE_CATALOG;
    }

    public void setTABLE_CATALOG(String TABLE_CATALOG) {
        this.TABLE_CATALOG = TABLE_CATALOG == null ? null : TABLE_CATALOG.trim();
    }

    public String getTABLE_SCHEMA() {
        return TABLE_SCHEMA;
    }

    public void setTABLE_SCHEMA(String TABLE_SCHEMA) {
        this.TABLE_SCHEMA = TABLE_SCHEMA == null ? null : TABLE_SCHEMA.trim();
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME == null ? null : TABLE_NAME.trim();
    }

    public String getPARTITION_NAME() {
        return PARTITION_NAME;
    }

    public void setPARTITION_NAME(String PARTITION_NAME) {
        this.PARTITION_NAME = PARTITION_NAME == null ? null : PARTITION_NAME.trim();
    }

    public String getSUBPARTITION_NAME() {
        return SUBPARTITION_NAME;
    }

    public void setSUBPARTITION_NAME(String SUBPARTITION_NAME) {
        this.SUBPARTITION_NAME = SUBPARTITION_NAME == null ? null : SUBPARTITION_NAME.trim();
    }

    public Long getPARTITION_ORDINAL_POSITION() {
        return PARTITION_ORDINAL_POSITION;
    }

    public void setPARTITION_ORDINAL_POSITION(Long PARTITION_ORDINAL_POSITION) {
        this.PARTITION_ORDINAL_POSITION = PARTITION_ORDINAL_POSITION;
    }

    public Long getSUBPARTITION_ORDINAL_POSITION() {
        return SUBPARTITION_ORDINAL_POSITION;
    }

    public void setSUBPARTITION_ORDINAL_POSITION(Long SUBPARTITION_ORDINAL_POSITION) {
        this.SUBPARTITION_ORDINAL_POSITION = SUBPARTITION_ORDINAL_POSITION;
    }

    public String getPARTITION_METHOD() {
        return PARTITION_METHOD;
    }

    public void setPARTITION_METHOD(String PARTITION_METHOD) {
        this.PARTITION_METHOD = PARTITION_METHOD == null ? null : PARTITION_METHOD.trim();
    }

    public String getSUBPARTITION_METHOD() {
        return SUBPARTITION_METHOD;
    }

    public void setSUBPARTITION_METHOD(String SUBPARTITION_METHOD) {
        this.SUBPARTITION_METHOD = SUBPARTITION_METHOD == null ? null : SUBPARTITION_METHOD.trim();
    }

    public Long getTABLE_ROWS() {
        return TABLE_ROWS;
    }

    public void setTABLE_ROWS(Long TABLE_ROWS) {
        this.TABLE_ROWS = TABLE_ROWS;
    }

    public Long getAVG_ROW_LENGTH() {
        return AVG_ROW_LENGTH;
    }

    public void setAVG_ROW_LENGTH(Long AVG_ROW_LENGTH) {
        this.AVG_ROW_LENGTH = AVG_ROW_LENGTH;
    }

    public Long getDATA_LENGTH() {
        return DATA_LENGTH;
    }

    public void setDATA_LENGTH(Long DATA_LENGTH) {
        this.DATA_LENGTH = DATA_LENGTH;
    }

    public Long getMAX_DATA_LENGTH() {
        return MAX_DATA_LENGTH;
    }

    public void setMAX_DATA_LENGTH(Long MAX_DATA_LENGTH) {
        this.MAX_DATA_LENGTH = MAX_DATA_LENGTH;
    }

    public Long getINDEX_LENGTH() {
        return INDEX_LENGTH;
    }

    public void setINDEX_LENGTH(Long INDEX_LENGTH) {
        this.INDEX_LENGTH = INDEX_LENGTH;
    }

    public Long getDATA_FREE() {
        return DATA_FREE;
    }

    public void setDATA_FREE(Long DATA_FREE) {
        this.DATA_FREE = DATA_FREE;
    }

    public Date getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Date CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public Date getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(Date UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public Date getCHECK_TIME() {
        return CHECK_TIME;
    }

    public void setCHECK_TIME(Date CHECK_TIME) {
        this.CHECK_TIME = CHECK_TIME;
    }

    public Long getCHECKSUM() {
        return CHECKSUM;
    }

    public void setCHECKSUM(Long CHECKSUM) {
        this.CHECKSUM = CHECKSUM;
    }

    public String getPARTITION_COMMENT() {
        return PARTITION_COMMENT;
    }

    public void setPARTITION_COMMENT(String PARTITION_COMMENT) {
        this.PARTITION_COMMENT = PARTITION_COMMENT == null ? null : PARTITION_COMMENT.trim();
    }

    public String getNODEGROUP() {
        return NODEGROUP;
    }

    public void setNODEGROUP(String NODEGROUP) {
        this.NODEGROUP = NODEGROUP == null ? null : NODEGROUP.trim();
    }

    public String getTABLESPACE_NAME() {
        return TABLESPACE_NAME;
    }

    public void setTABLESPACE_NAME(String TABLESPACE_NAME) {
        this.TABLESPACE_NAME = TABLESPACE_NAME == null ? null : TABLESPACE_NAME.trim();
    }

    public String getPARTITION_EXPRESSION() {
        return PARTITION_EXPRESSION;
    }

    public void setPARTITION_EXPRESSION(String PARTITION_EXPRESSION) {
        this.PARTITION_EXPRESSION = PARTITION_EXPRESSION == null ? null : PARTITION_EXPRESSION.trim();
    }

    public String getSUBPARTITION_EXPRESSION() {
        return SUBPARTITION_EXPRESSION;
    }

    public void setSUBPARTITION_EXPRESSION(String SUBPARTITION_EXPRESSION) {
        this.SUBPARTITION_EXPRESSION = SUBPARTITION_EXPRESSION == null ? null : SUBPARTITION_EXPRESSION.trim();
    }

    public String getPARTITION_DESCRIPTION() {
        return PARTITION_DESCRIPTION;
    }

    public void setPARTITION_DESCRIPTION(String PARTITION_DESCRIPTION) {
        this.PARTITION_DESCRIPTION = PARTITION_DESCRIPTION == null ? null : PARTITION_DESCRIPTION.trim();
    }
}