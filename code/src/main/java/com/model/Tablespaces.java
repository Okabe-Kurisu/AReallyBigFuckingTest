package com.model;

public class Tablespaces {
    private String TABLESPACE_NAME;

    private String ENGINE;

    private String TABLESPACE_TYPE;

    private String LOGFILE_GROUP_NAME;

    private Long EXTENT_SIZE;

    private Long AUTOEXTEND_SIZE;

    private Long MAXIMUM_SIZE;

    private Long NODEGROUP_ID;

    private String TABLESPACE_COMMENT;

    public String getTABLESPACE_NAME() {
        return TABLESPACE_NAME;
    }

    public void setTABLESPACE_NAME(String TABLESPACE_NAME) {
        this.TABLESPACE_NAME = TABLESPACE_NAME == null ? null : TABLESPACE_NAME.trim();
    }

    public String getENGINE() {
        return ENGINE;
    }

    public void setENGINE(String ENGINE) {
        this.ENGINE = ENGINE == null ? null : ENGINE.trim();
    }

    public String getTABLESPACE_TYPE() {
        return TABLESPACE_TYPE;
    }

    public void setTABLESPACE_TYPE(String TABLESPACE_TYPE) {
        this.TABLESPACE_TYPE = TABLESPACE_TYPE == null ? null : TABLESPACE_TYPE.trim();
    }

    public String getLOGFILE_GROUP_NAME() {
        return LOGFILE_GROUP_NAME;
    }

    public void setLOGFILE_GROUP_NAME(String LOGFILE_GROUP_NAME) {
        this.LOGFILE_GROUP_NAME = LOGFILE_GROUP_NAME == null ? null : LOGFILE_GROUP_NAME.trim();
    }

    public Long getEXTENT_SIZE() {
        return EXTENT_SIZE;
    }

    public void setEXTENT_SIZE(Long EXTENT_SIZE) {
        this.EXTENT_SIZE = EXTENT_SIZE;
    }

    public Long getAUTOEXTEND_SIZE() {
        return AUTOEXTEND_SIZE;
    }

    public void setAUTOEXTEND_SIZE(Long AUTOEXTEND_SIZE) {
        this.AUTOEXTEND_SIZE = AUTOEXTEND_SIZE;
    }

    public Long getMAXIMUM_SIZE() {
        return MAXIMUM_SIZE;
    }

    public void setMAXIMUM_SIZE(Long MAXIMUM_SIZE) {
        this.MAXIMUM_SIZE = MAXIMUM_SIZE;
    }

    public Long getNODEGROUP_ID() {
        return NODEGROUP_ID;
    }

    public void setNODEGROUP_ID(Long NODEGROUP_ID) {
        this.NODEGROUP_ID = NODEGROUP_ID;
    }

    public String getTABLESPACE_COMMENT() {
        return TABLESPACE_COMMENT;
    }

    public void setTABLESPACE_COMMENT(String TABLESPACE_COMMENT) {
        this.TABLESPACE_COMMENT = TABLESPACE_COMMENT == null ? null : TABLESPACE_COMMENT.trim();
    }
}