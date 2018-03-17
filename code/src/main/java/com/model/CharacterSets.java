package com.model;

public class CharacterSets {
    private String CHARACTER_SET_NAME;

    private String DEFAULT_COLLATE_NAME;

    private String DESCRIPTION;

    private Long MAXLEN;

    public String getCHARACTER_SET_NAME() {
        return CHARACTER_SET_NAME;
    }

    public void setCHARACTER_SET_NAME(String CHARACTER_SET_NAME) {
        this.CHARACTER_SET_NAME = CHARACTER_SET_NAME == null ? null : CHARACTER_SET_NAME.trim();
    }

    public String getDEFAULT_COLLATE_NAME() {
        return DEFAULT_COLLATE_NAME;
    }

    public void setDEFAULT_COLLATE_NAME(String DEFAULT_COLLATE_NAME) {
        this.DEFAULT_COLLATE_NAME = DEFAULT_COLLATE_NAME == null ? null : DEFAULT_COLLATE_NAME.trim();
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    public Long getMAXLEN() {
        return MAXLEN;
    }

    public void setMAXLEN(Long MAXLEN) {
        this.MAXLEN = MAXLEN;
    }
}