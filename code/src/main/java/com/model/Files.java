package com.model;

import java.util.Date;

public class Files {
    private Long FILE_ID;

    private String FILE_NAME;

    private String FILE_TYPE;

    private String TABLESPACE_NAME;

    private String TABLE_CATALOG;

    private String TABLE_SCHEMA;

    private String TABLE_NAME;

    private String LOGFILE_GROUP_NAME;

    private Long LOGFILE_GROUP_NUMBER;

    private String ENGINE;

    private String FULLTEXT_KEYS;

    private Long DELETED_ROWS;

    private Long UPDATE_COUNT;

    private Long FREE_EXTENTS;

    private Long TOTAL_EXTENTS;

    private Long EXTENT_SIZE;

    private Long INITIAL_SIZE;

    private Long MAXIMUM_SIZE;

    private Long AUTOEXTEND_SIZE;

    private Date CREATION_TIME;

    private Date LAST_UPDATE_TIME;

    private Date LAST_ACCESS_TIME;

    private Long RECOVER_TIME;

    private Long TRANSACTION_COUNTER;

    private Long VERSION;

    private String ROW_FORMAT;

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

    private String STATUS;

    private String EXTRA;

    public Long getFILE_ID() {
        return FILE_ID;
    }

    public void setFILE_ID(Long FILE_ID) {
        this.FILE_ID = FILE_ID;
    }

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public void setFILE_NAME(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME == null ? null : FILE_NAME.trim();
    }

    public String getFILE_TYPE() {
        return FILE_TYPE;
    }

    public void setFILE_TYPE(String FILE_TYPE) {
        this.FILE_TYPE = FILE_TYPE == null ? null : FILE_TYPE.trim();
    }

    public String getTABLESPACE_NAME() {
        return TABLESPACE_NAME;
    }

    public void setTABLESPACE_NAME(String TABLESPACE_NAME) {
        this.TABLESPACE_NAME = TABLESPACE_NAME == null ? null : TABLESPACE_NAME.trim();
    }

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

    public String getLOGFILE_GROUP_NAME() {
        return LOGFILE_GROUP_NAME;
    }

    public void setLOGFILE_GROUP_NAME(String LOGFILE_GROUP_NAME) {
        this.LOGFILE_GROUP_NAME = LOGFILE_GROUP_NAME == null ? null : LOGFILE_GROUP_NAME.trim();
    }

    public Long getLOGFILE_GROUP_NUMBER() {
        return LOGFILE_GROUP_NUMBER;
    }

    public void setLOGFILE_GROUP_NUMBER(Long LOGFILE_GROUP_NUMBER) {
        this.LOGFILE_GROUP_NUMBER = LOGFILE_GROUP_NUMBER;
    }

    public String getENGINE() {
        return ENGINE;
    }

    public void setENGINE(String ENGINE) {
        this.ENGINE = ENGINE == null ? null : ENGINE.trim();
    }

    public String getFULLTEXT_KEYS() {
        return FULLTEXT_KEYS;
    }

    public void setFULLTEXT_KEYS(String FULLTEXT_KEYS) {
        this.FULLTEXT_KEYS = FULLTEXT_KEYS == null ? null : FULLTEXT_KEYS.trim();
    }

    public Long getDELETED_ROWS() {
        return DELETED_ROWS;
    }

    public void setDELETED_ROWS(Long DELETED_ROWS) {
        this.DELETED_ROWS = DELETED_ROWS;
    }

    public Long getUPDATE_COUNT() {
        return UPDATE_COUNT;
    }

    public void setUPDATE_COUNT(Long UPDATE_COUNT) {
        this.UPDATE_COUNT = UPDATE_COUNT;
    }

    public Long getFREE_EXTENTS() {
        return FREE_EXTENTS;
    }

    public void setFREE_EXTENTS(Long FREE_EXTENTS) {
        this.FREE_EXTENTS = FREE_EXTENTS;
    }

    public Long getTOTAL_EXTENTS() {
        return TOTAL_EXTENTS;
    }

    public void setTOTAL_EXTENTS(Long TOTAL_EXTENTS) {
        this.TOTAL_EXTENTS = TOTAL_EXTENTS;
    }

    public Long getEXTENT_SIZE() {
        return EXTENT_SIZE;
    }

    public void setEXTENT_SIZE(Long EXTENT_SIZE) {
        this.EXTENT_SIZE = EXTENT_SIZE;
    }

    public Long getINITIAL_SIZE() {
        return INITIAL_SIZE;
    }

    public void setINITIAL_SIZE(Long INITIAL_SIZE) {
        this.INITIAL_SIZE = INITIAL_SIZE;
    }

    public Long getMAXIMUM_SIZE() {
        return MAXIMUM_SIZE;
    }

    public void setMAXIMUM_SIZE(Long MAXIMUM_SIZE) {
        this.MAXIMUM_SIZE = MAXIMUM_SIZE;
    }

    public Long getAUTOEXTEND_SIZE() {
        return AUTOEXTEND_SIZE;
    }

    public void setAUTOEXTEND_SIZE(Long AUTOEXTEND_SIZE) {
        this.AUTOEXTEND_SIZE = AUTOEXTEND_SIZE;
    }

    public Date getCREATION_TIME() {
        return CREATION_TIME;
    }

    public void setCREATION_TIME(Date CREATION_TIME) {
        this.CREATION_TIME = CREATION_TIME;
    }

    public Date getLAST_UPDATE_TIME() {
        return LAST_UPDATE_TIME;
    }

    public void setLAST_UPDATE_TIME(Date LAST_UPDATE_TIME) {
        this.LAST_UPDATE_TIME = LAST_UPDATE_TIME;
    }

    public Date getLAST_ACCESS_TIME() {
        return LAST_ACCESS_TIME;
    }

    public void setLAST_ACCESS_TIME(Date LAST_ACCESS_TIME) {
        this.LAST_ACCESS_TIME = LAST_ACCESS_TIME;
    }

    public Long getRECOVER_TIME() {
        return RECOVER_TIME;
    }

    public void setRECOVER_TIME(Long RECOVER_TIME) {
        this.RECOVER_TIME = RECOVER_TIME;
    }

    public Long getTRANSACTION_COUNTER() {
        return TRANSACTION_COUNTER;
    }

    public void setTRANSACTION_COUNTER(Long TRANSACTION_COUNTER) {
        this.TRANSACTION_COUNTER = TRANSACTION_COUNTER;
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

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    public String getEXTRA() {
        return EXTRA;
    }

    public void setEXTRA(String EXTRA) {
        this.EXTRA = EXTRA == null ? null : EXTRA.trim();
    }
}