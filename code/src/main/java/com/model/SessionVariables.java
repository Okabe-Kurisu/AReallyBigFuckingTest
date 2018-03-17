package com.model;

public class SessionVariables {
    private String VARIABLE_NAME;

    private String VARIABLE_VALUE;

    public String getVARIABLE_NAME() {
        return VARIABLE_NAME;
    }

    public void setVARIABLE_NAME(String VARIABLE_NAME) {
        this.VARIABLE_NAME = VARIABLE_NAME == null ? null : VARIABLE_NAME.trim();
    }

    public String getVARIABLE_VALUE() {
        return VARIABLE_VALUE;
    }

    public void setVARIABLE_VALUE(String VARIABLE_VALUE) {
        this.VARIABLE_VALUE = VARIABLE_VALUE == null ? null : VARIABLE_VALUE.trim();
    }
}