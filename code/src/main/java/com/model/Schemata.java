package com.model;

public class Schemata {
    private String CATALOG_NAME;

    private String SCHEMA_NAME;

    private String DEFAULT_CHARACTER_SET_NAME;

    private String DEFAULT_COLLATION_NAME;

    private String SQL_PATH;

    public String getCATALOG_NAME() {
        return CATALOG_NAME;
    }

    public void setCATALOG_NAME(String CATALOG_NAME) {
        this.CATALOG_NAME = CATALOG_NAME == null ? null : CATALOG_NAME.trim();
    }

    public String getSCHEMA_NAME() {
        return SCHEMA_NAME;
    }

    public void setSCHEMA_NAME(String SCHEMA_NAME) {
        this.SCHEMA_NAME = SCHEMA_NAME == null ? null : SCHEMA_NAME.trim();
    }

    public String getDEFAULT_CHARACTER_SET_NAME() {
        return DEFAULT_CHARACTER_SET_NAME;
    }

    public void setDEFAULT_CHARACTER_SET_NAME(String DEFAULT_CHARACTER_SET_NAME) {
        this.DEFAULT_CHARACTER_SET_NAME = DEFAULT_CHARACTER_SET_NAME == null ? null : DEFAULT_CHARACTER_SET_NAME.trim();
    }

    public String getDEFAULT_COLLATION_NAME() {
        return DEFAULT_COLLATION_NAME;
    }

    public void setDEFAULT_COLLATION_NAME(String DEFAULT_COLLATION_NAME) {
        this.DEFAULT_COLLATION_NAME = DEFAULT_COLLATION_NAME == null ? null : DEFAULT_COLLATION_NAME.trim();
    }

    public String getSQL_PATH() {
        return SQL_PATH;
    }

    public void setSQL_PATH(String SQL_PATH) {
        this.SQL_PATH = SQL_PATH == null ? null : SQL_PATH.trim();
    }
}