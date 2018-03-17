package com.model;

public class Collations {
    private String COLLATION_NAME;

    private String CHARACTER_SET_NAME;

    private Long ID;

    private String IS_DEFAULT;

    private String IS_COMPILED;

    private Long SORTLEN;

    public String getCOLLATION_NAME() {
        return COLLATION_NAME;
    }

    public void setCOLLATION_NAME(String COLLATION_NAME) {
        this.COLLATION_NAME = COLLATION_NAME == null ? null : COLLATION_NAME.trim();
    }

    public String getCHARACTER_SET_NAME() {
        return CHARACTER_SET_NAME;
    }

    public void setCHARACTER_SET_NAME(String CHARACTER_SET_NAME) {
        this.CHARACTER_SET_NAME = CHARACTER_SET_NAME == null ? null : CHARACTER_SET_NAME.trim();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getIS_DEFAULT() {
        return IS_DEFAULT;
    }

    public void setIS_DEFAULT(String IS_DEFAULT) {
        this.IS_DEFAULT = IS_DEFAULT == null ? null : IS_DEFAULT.trim();
    }

    public String getIS_COMPILED() {
        return IS_COMPILED;
    }

    public void setIS_COMPILED(String IS_COMPILED) {
        this.IS_COMPILED = IS_COMPILED == null ? null : IS_COMPILED.trim();
    }

    public Long getSORTLEN() {
        return SORTLEN;
    }

    public void setSORTLEN(Long SORTLEN) {
        this.SORTLEN = SORTLEN;
    }
}