package com.model;

public class Columns {
    private String TABLE_CATALOG;

    private String TABLE_SCHEMA;

    private String TABLE_NAME;

    private String COLUMN_NAME;

    private Long ORDINAL_POSITION;

    private String IS_NULLABLE;

    private String DATA_TYPE;

    private Long CHARACTER_MAXIMUM_LENGTH;

    private Long CHARACTER_OCTET_LENGTH;

    private Long NUMERIC_PRECISION;

    private Long NUMERIC_SCALE;

    private String CHARACTER_SET_NAME;

    private String COLLATION_NAME;

    private String COLUMN_KEY;

    private String EXTRA;

    private String PRIVILEGES;

    private String COLUMN_COMMENT;

    private String COLUMN_DEFAULT;

    private String COLUMN_TYPE;

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

    public String getCOLUMN_NAME() {
        return COLUMN_NAME;
    }

    public void setCOLUMN_NAME(String COLUMN_NAME) {
        this.COLUMN_NAME = COLUMN_NAME == null ? null : COLUMN_NAME.trim();
    }

    public Long getORDINAL_POSITION() {
        return ORDINAL_POSITION;
    }

    public void setORDINAL_POSITION(Long ORDINAL_POSITION) {
        this.ORDINAL_POSITION = ORDINAL_POSITION;
    }

    public String getIS_NULLABLE() {
        return IS_NULLABLE;
    }

    public void setIS_NULLABLE(String IS_NULLABLE) {
        this.IS_NULLABLE = IS_NULLABLE == null ? null : IS_NULLABLE.trim();
    }

    public String getDATA_TYPE() {
        return DATA_TYPE;
    }

    public void setDATA_TYPE(String DATA_TYPE) {
        this.DATA_TYPE = DATA_TYPE == null ? null : DATA_TYPE.trim();
    }

    public Long getCHARACTER_MAXIMUM_LENGTH() {
        return CHARACTER_MAXIMUM_LENGTH;
    }

    public void setCHARACTER_MAXIMUM_LENGTH(Long CHARACTER_MAXIMUM_LENGTH) {
        this.CHARACTER_MAXIMUM_LENGTH = CHARACTER_MAXIMUM_LENGTH;
    }

    public Long getCHARACTER_OCTET_LENGTH() {
        return CHARACTER_OCTET_LENGTH;
    }

    public void setCHARACTER_OCTET_LENGTH(Long CHARACTER_OCTET_LENGTH) {
        this.CHARACTER_OCTET_LENGTH = CHARACTER_OCTET_LENGTH;
    }

    public Long getNUMERIC_PRECISION() {
        return NUMERIC_PRECISION;
    }

    public void setNUMERIC_PRECISION(Long NUMERIC_PRECISION) {
        this.NUMERIC_PRECISION = NUMERIC_PRECISION;
    }

    public Long getNUMERIC_SCALE() {
        return NUMERIC_SCALE;
    }

    public void setNUMERIC_SCALE(Long NUMERIC_SCALE) {
        this.NUMERIC_SCALE = NUMERIC_SCALE;
    }

    public String getCHARACTER_SET_NAME() {
        return CHARACTER_SET_NAME;
    }

    public void setCHARACTER_SET_NAME(String CHARACTER_SET_NAME) {
        this.CHARACTER_SET_NAME = CHARACTER_SET_NAME == null ? null : CHARACTER_SET_NAME.trim();
    }

    public String getCOLLATION_NAME() {
        return COLLATION_NAME;
    }

    public void setCOLLATION_NAME(String COLLATION_NAME) {
        this.COLLATION_NAME = COLLATION_NAME == null ? null : COLLATION_NAME.trim();
    }

    public String getCOLUMN_KEY() {
        return COLUMN_KEY;
    }

    public void setCOLUMN_KEY(String COLUMN_KEY) {
        this.COLUMN_KEY = COLUMN_KEY == null ? null : COLUMN_KEY.trim();
    }

    public String getEXTRA() {
        return EXTRA;
    }

    public void setEXTRA(String EXTRA) {
        this.EXTRA = EXTRA == null ? null : EXTRA.trim();
    }

    public String getPRIVILEGES() {
        return PRIVILEGES;
    }

    public void setPRIVILEGES(String PRIVILEGES) {
        this.PRIVILEGES = PRIVILEGES == null ? null : PRIVILEGES.trim();
    }

    public String getCOLUMN_COMMENT() {
        return COLUMN_COMMENT;
    }

    public void setCOLUMN_COMMENT(String COLUMN_COMMENT) {
        this.COLUMN_COMMENT = COLUMN_COMMENT == null ? null : COLUMN_COMMENT.trim();
    }

    public String getCOLUMN_DEFAULT() {
        return COLUMN_DEFAULT;
    }

    public void setCOLUMN_DEFAULT(String COLUMN_DEFAULT) {
        this.COLUMN_DEFAULT = COLUMN_DEFAULT == null ? null : COLUMN_DEFAULT.trim();
    }

    public String getCOLUMN_TYPE() {
        return COLUMN_TYPE;
    }

    public void setCOLUMN_TYPE(String COLUMN_TYPE) {
        this.COLUMN_TYPE = COLUMN_TYPE == null ? null : COLUMN_TYPE.trim();
    }
}