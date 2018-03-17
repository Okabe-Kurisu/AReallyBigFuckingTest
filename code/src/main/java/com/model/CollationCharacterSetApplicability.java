package com.model;

public class CollationCharacterSetApplicability {
    private String COLLATION_NAME;

    private String CHARACTER_SET_NAME;

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
}