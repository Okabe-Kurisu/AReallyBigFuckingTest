package com.model;

import java.util.Date;

public class Tables {
    private String TABLE_CATALOG;

    private String TABLE_SCHEMA;

    private String TABLE_NAME;

    private String TABLE_TYPE;

    private String ENGINE;

    private Long VERSION;

    private String ROW_FORMAT;

    private Long TABLE_ROWS;

    private Long AVG_ROW_LENGTH;

    private Long DATA_LENGTH;

    private Long MAX_DATA_LENGTH;

    private Long INDEX_LENGTH;

    private Long DATA_FREE;

    private Long AUTO_INCREMENT;

    private Date CREATE_TIME;

    private Date UPDATE_TIME;

    private Date CHECK_TIME;

    private String TABLE_COLLATION;

    private Long CHECKSUM;

    private String CREATE_OPTIONS;

    private String TABLE_COMMENT;

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

    public String getTABLE_TYPE() {
        return TABLE_TYPE;
    }

    public void setTABLE_TYPE(String TABLE_TYPE) {
        this.TABLE_TYPE = TABLE_TYPE == null ? null : TABLE_TYPE.trim();
    }

    public String getENGINE() {
        return ENGINE;
    }

    public void setENGINE(String ENGINE) {
        this.ENGINE = ENGINE == null ? null : ENGINE.trim();
    }

    public Long getVERSION() {
        return VERSION;
    }

    public void setVERSION(Long VERSION) {
        this.VERSION = VERSION;
    }

    public String getROW_FORMAT() {
        return ROW_FORMAT;
    }

    public void setROW_FORMAT(String ROW_FORMAT) {
        this.ROW_FORMAT = ROW_FORMAT == null ? null : ROW_FORMAT.trim();
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

    public Long getAUTO_INCREMENT() {
        return AUTO_INCREMENT;
    }

    public void setAUTO_INCREMENT(Long AUTO_INCREMENT) {
        this.AUTO_INCREMENT = AUTO_INCREMENT;
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

    public String getTABLE_COLLATION() {
        return TABLE_COLLATION;
    }

    public void setTABLE_COLLATION(String TABLE_COLLATION) {
        this.TABLE_COLLATION = TABLE_COLLATION == null ? null : TABLE_COLLATION.trim();
    }

    public Long getCHECKSUM() {
        return CHECKSUM;
    }

    public void setCHECKSUM(Long CHECKSUM) {
        this.CHECKSUM = CHECKSUM;
    }

    public String getCREATE_OPTIONS() {
        return CREATE_OPTIONS;
    }

    public void setCREATE_OPTIONS(String CREATE_OPTIONS) {
        this.CREATE_OPTIONS = CREATE_OPTIONS == null ? null : CREATE_OPTIONS.trim();
    }

    public String getTABLE_COMMENT() {
        return TABLE_COMMENT;
    }

    public void setTABLE_COMMENT(String TABLE_COMMENT) {
        this.TABLE_COMMENT = TABLE_COMMENT == null ? null : TABLE_COMMENT.trim();
    }
}