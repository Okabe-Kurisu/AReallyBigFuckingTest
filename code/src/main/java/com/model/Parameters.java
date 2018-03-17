package com.model;

public class Parameters {
    private String SPECIFIC_CATALOG;

    private String SPECIFIC_SCHEMA;

    private String SPECIFIC_NAME;

    private Integer ORDINAL_POSITION;

    private String PARAMETER_MODE;

    private String PARAMETER_NAME;

    private String DATA_TYPE;

    private Integer CHARACTER_MAXIMUM_LENGTH;

    private Integer CHARACTER_OCTET_LENGTH;

    private Integer NUMERIC_PRECISION;

    private Integer NUMERIC_SCALE;

    private String CHARACTER_SET_NAME;

    private String COLLATION_NAME;

    private String ROUTINE_TYPE;

    private String DTD_IDENTIFIER;

    public String getSPECIFIC_CATALOG() {
        return SPECIFIC_CATALOG;
    }

    public void setSPECIFIC_CATALOG(String SPECIFIC_CATALOG) {
        this.SPECIFIC_CATALOG = SPECIFIC_CATALOG == null ? null : SPECIFIC_CATALOG.trim();
    }

    public String getSPECIFIC_SCHEMA() {
        return SPECIFIC_SCHEMA;
    }

    public void setSPECIFIC_SCHEMA(String SPECIFIC_SCHEMA) {
        this.SPECIFIC_SCHEMA = SPECIFIC_SCHEMA == null ? null : SPECIFIC_SCHEMA.trim();
    }

    public String getSPECIFIC_NAME() {
        return SPECIFIC_NAME;
    }

    public void setSPECIFIC_NAME(String SPECIFIC_NAME) {
        this.SPECIFIC_NAME = SPECIFIC_NAME == null ? null : SPECIFIC_NAME.trim();
    }

    public Integer getORDINAL_POSITION() {
        return ORDINAL_POSITION;
    }

    public void setORDINAL_POSITION(Integer ORDINAL_POSITION) {
        this.ORDINAL_POSITION = ORDINAL_POSITION;
    }

    public String getPARAMETER_MODE() {
        return PARAMETER_MODE;
    }

    public void setPARAMETER_MODE(String PARAMETER_MODE) {
        this.PARAMETER_MODE = PARAMETER_MODE == null ? null : PARAMETER_MODE.trim();
    }

    public String getPARAMETER_NAME() {
        return PARAMETER_NAME;
    }

    public void setPARAMETER_NAME(String PARAMETER_NAME) {
        this.PARAMETER_NAME = PARAMETER_NAME == null ? null : PARAMETER_NAME.trim();
    }

    public String getDATA_TYPE() {
        return DATA_TYPE;
    }

    public void setDATA_TYPE(String DATA_TYPE) {
        this.DATA_TYPE = DATA_TYPE == null ? null : DATA_TYPE.trim();
    }

    public Integer getCHARACTER_MAXIMUM_LENGTH() {
        return CHARACTER_MAXIMUM_LENGTH;
    }

    public void setCHARACTER_MAXIMUM_LENGTH(Integer CHARACTER_MAXIMUM_LENGTH) {
        this.CHARACTER_MAXIMUM_LENGTH = CHARACTER_MAXIMUM_LENGTH;
    }

    public Integer getCHARACTER_OCTET_LENGTH() {
        return CHARACTER_OCTET_LENGTH;
    }

    public void setCHARACTER_OCTET_LENGTH(Integer CHARACTER_OCTET_LENGTH) {
        this.CHARACTER_OCTET_LENGTH = CHARACTER_OCTET_LENGTH;
    }

    public Integer getNUMERIC_PRECISION() {
        return NUMERIC_PRECISION;
    }

    public void setNUMERIC_PRECISION(Integer NUMERIC_PRECISION) {
        this.NUMERIC_PRECISION = NUMERIC_PRECISION;
    }

    public Integer getNUMERIC_SCALE() {
        return NUMERIC_SCALE;
    }

    public void setNUMERIC_SCALE(Integer NUMERIC_SCALE) {
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

    public String getROUTINE_TYPE() {
        return ROUTINE_TYPE;
    }

    public void setROUTINE_TYPE(String ROUTINE_TYPE) {
        this.ROUTINE_TYPE = ROUTINE_TYPE == null ? null : ROUTINE_TYPE.trim();
    }

    public String getDTD_IDENTIFIER() {
        return DTD_IDENTIFIER;
    }

    public void setDTD_IDENTIFIER(String DTD_IDENTIFIER) {
        this.DTD_IDENTIFIER = DTD_IDENTIFIER == null ? null : DTD_IDENTIFIER.trim();
    }
}