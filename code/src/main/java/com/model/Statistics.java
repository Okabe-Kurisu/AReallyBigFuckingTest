package com.model;

public class Statistics {
    private String TABLE_CATALOG;

    private String TABLE_SCHEMA;

    private String TABLE_NAME;

    private Long NON_UNIQUE;

    private String INDEX_SCHEMA;

    private String INDEX_NAME;

    private Long SEQ_IN_INDEX;

    private String COLUMN_NAME;

    private String COLLATION;

    private Long CARDINALITY;

    private Long SUB_PART;

    private String PACKED;

    private String NULLABLE;

    private String INDEX_TYPE;

    private String COMMENT;

    private String INDEX_COMMENT;

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

    public Long getNON_UNIQUE() {
        return NON_UNIQUE;
    }

    public void setNON_UNIQUE(Long NON_UNIQUE) {
        this.NON_UNIQUE = NON_UNIQUE;
    }

    public String getINDEX_SCHEMA() {
        return INDEX_SCHEMA;
    }

    public void setINDEX_SCHEMA(String INDEX_SCHEMA) {
        this.INDEX_SCHEMA = INDEX_SCHEMA == null ? null : INDEX_SCHEMA.trim();
    }

    public String getINDEX_NAME() {
        return INDEX_NAME;
    }

    public void setINDEX_NAME(String INDEX_NAME) {
        this.INDEX_NAME = INDEX_NAME == null ? null : INDEX_NAME.trim();
    }

    public Long getSEQ_IN_INDEX() {
        return SEQ_IN_INDEX;
    }

    public void setSEQ_IN_INDEX(Long SEQ_IN_INDEX) {
        this.SEQ_IN_INDEX = SEQ_IN_INDEX;
    }

    public String getCOLUMN_NAME() {
        return COLUMN_NAME;
    }

    public void setCOLUMN_NAME(String COLUMN_NAME) {
        this.COLUMN_NAME = COLUMN_NAME == null ? null : COLUMN_NAME.trim();
    }

    public String getCOLLATION() {
        return COLLATION;
    }

    public void setCOLLATION(String COLLATION) {
        this.COLLATION = COLLATION == null ? null : COLLATION.trim();
    }

    public Long getCARDINALITY() {
        return CARDINALITY;
    }

    public void setCARDINALITY(Long CARDINALITY) {
        this.CARDINALITY = CARDINALITY;
    }

    public Long getSUB_PART() {
        return SUB_PART;
    }

    public void setSUB_PART(Long SUB_PART) {
        this.SUB_PART = SUB_PART;
    }

    public String getPACKED() {
        return PACKED;
    }

    public void setPACKED(String PACKED) {
        this.PACKED = PACKED == null ? null : PACKED.trim();
    }

    public String getNULLABLE() {
        return NULLABLE;
    }

    public void setNULLABLE(String NULLABLE) {
        this.NULLABLE = NULLABLE == null ? null : NULLABLE.trim();
    }

    public String getINDEX_TYPE() {
        return INDEX_TYPE;
    }

    public void setINDEX_TYPE(String INDEX_TYPE) {
        this.INDEX_TYPE = INDEX_TYPE == null ? null : INDEX_TYPE.trim();
    }

    public String getCOMMENT() {
        return COMMENT;
    }

    public void setCOMMENT(String COMMENT) {
        this.COMMENT = COMMENT == null ? null : COMMENT.trim();
    }

    public String getINDEX_COMMENT() {
        return INDEX_COMMENT;
    }

    public void setINDEX_COMMENT(String INDEX_COMMENT) {
        this.INDEX_COMMENT = INDEX_COMMENT == null ? null : INDEX_COMMENT.trim();
    }
}