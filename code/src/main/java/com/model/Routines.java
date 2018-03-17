package com.model;

import java.util.Date;

public class Routines {
    private String SPECIFIC_NAME;

    private String ROUTINE_CATALOG;

    private String ROUTINE_SCHEMA;

    private String ROUTINE_NAME;

    private String ROUTINE_TYPE;

    private String DATA_TYPE;

    private Integer CHARACTER_MAXIMUM_LENGTH;

    private Integer CHARACTER_OCTET_LENGTH;

    private Integer NUMERIC_PRECISION;

    private Integer NUMERIC_SCALE;

    private String CHARACTER_SET_NAME;

    private String COLLATION_NAME;

    private String ROUTINE_BODY;

    private String EXTERNAL_NAME;

    private String EXTERNAL_LANGUAGE;

    private String PARAMETER_STYLE;

    private String IS_DETERMINISTIC;

    private String SQL_DATA_ACCESS;

    private String SQL_PATH;

    private String SECURITY_TYPE;

    private Date CREATED;

    private Date LAST_ALTERED;

    private String SQL_MODE;

    private String DEFINER;

    private String CHARACTER_SET_CLIENT;

    private String COLLATION_CONNECTION;

    private String DATABASE_COLLATION;

    private String DTD_IDENTIFIER;

    private String ROUTINE_DEFINITION;

    private String ROUTINE_COMMENT;

    public String getSPECIFIC_NAME() {
        return SPECIFIC_NAME;
    }

    public void setSPECIFIC_NAME(String SPECIFIC_NAME) {
        this.SPECIFIC_NAME = SPECIFIC_NAME == null ? null : SPECIFIC_NAME.trim();
    }

    public String getROUTINE_CATALOG() {
        return ROUTINE_CATALOG;
    }

    public void setROUTINE_CATALOG(String ROUTINE_CATALOG) {
        this.ROUTINE_CATALOG = ROUTINE_CATALOG == null ? null : ROUTINE_CATALOG.trim();
    }

    public String getROUTINE_SCHEMA() {
        return ROUTINE_SCHEMA;
    }

    public void setROUTINE_SCHEMA(String ROUTINE_SCHEMA) {
        this.ROUTINE_SCHEMA = ROUTINE_SCHEMA == null ? null : ROUTINE_SCHEMA.trim();
    }

    public String getROUTINE_NAME() {
        return ROUTINE_NAME;
    }

    public void setROUTINE_NAME(String ROUTINE_NAME) {
        this.ROUTINE_NAME = ROUTINE_NAME == null ? null : ROUTINE_NAME.trim();
    }

    public String getROUTINE_TYPE() {
        return ROUTINE_TYPE;
    }

    public void setROUTINE_TYPE(String ROUTINE_TYPE) {
        this.ROUTINE_TYPE = ROUTINE_TYPE == null ? null : ROUTINE_TYPE.trim();
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

    public String getROUTINE_BODY() {
        return ROUTINE_BODY;
    }

    public void setROUTINE_BODY(String ROUTINE_BODY) {
        this.ROUTINE_BODY = ROUTINE_BODY == null ? null : ROUTINE_BODY.trim();
    }

    public String getEXTERNAL_NAME() {
        return EXTERNAL_NAME;
    }

    public void setEXTERNAL_NAME(String EXTERNAL_NAME) {
        this.EXTERNAL_NAME = EXTERNAL_NAME == null ? null : EXTERNAL_NAME.trim();
    }

    public String getEXTERNAL_LANGUAGE() {
        return EXTERNAL_LANGUAGE;
    }

    public void setEXTERNAL_LANGUAGE(String EXTERNAL_LANGUAGE) {
        this.EXTERNAL_LANGUAGE = EXTERNAL_LANGUAGE == null ? null : EXTERNAL_LANGUAGE.trim();
    }

    public String getPARAMETER_STYLE() {
        return PARAMETER_STYLE;
    }

    public void setPARAMETER_STYLE(String PARAMETER_STYLE) {
        this.PARAMETER_STYLE = PARAMETER_STYLE == null ? null : PARAMETER_STYLE.trim();
    }

    public String getIS_DETERMINISTIC() {
        return IS_DETERMINISTIC;
    }

    public void setIS_DETERMINISTIC(String IS_DETERMINISTIC) {
        this.IS_DETERMINISTIC = IS_DETERMINISTIC == null ? null : IS_DETERMINISTIC.trim();
    }

    public String getSQL_DATA_ACCESS() {
        return SQL_DATA_ACCESS;
    }

    public void setSQL_DATA_ACCESS(String SQL_DATA_ACCESS) {
        this.SQL_DATA_ACCESS = SQL_DATA_ACCESS == null ? null : SQL_DATA_ACCESS.trim();
    }

    public String getSQL_PATH() {
        return SQL_PATH;
    }

    public void setSQL_PATH(String SQL_PATH) {
        this.SQL_PATH = SQL_PATH == null ? null : SQL_PATH.trim();
    }

    public String getSECURITY_TYPE() {
        return SECURITY_TYPE;
    }

    public void setSECURITY_TYPE(String SECURITY_TYPE) {
        this.SECURITY_TYPE = SECURITY_TYPE == null ? null : SECURITY_TYPE.trim();
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

    public String getDTD_IDENTIFIER() {
        return DTD_IDENTIFIER;
    }

    public void setDTD_IDENTIFIER(String DTD_IDENTIFIER) {
        this.DTD_IDENTIFIER = DTD_IDENTIFIER == null ? null : DTD_IDENTIFIER.trim();
    }

    public String getROUTINE_DEFINITION() {
        return ROUTINE_DEFINITION;
    }

    public void setROUTINE_DEFINITION(String ROUTINE_DEFINITION) {
        this.ROUTINE_DEFINITION = ROUTINE_DEFINITION == null ? null : ROUTINE_DEFINITION.trim();
    }

    public String getROUTINE_COMMENT() {
        return ROUTINE_COMMENT;
    }

    public void setROUTINE_COMMENT(String ROUTINE_COMMENT) {
        this.ROUTINE_COMMENT = ROUTINE_COMMENT == null ? null : ROUTINE_COMMENT.trim();
    }
}