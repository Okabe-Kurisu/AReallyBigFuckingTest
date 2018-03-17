package com.model;

public class Views {
    private String TABLE_CATALOG;

    private String TABLE_SCHEMA;

    private String TABLE_NAME;

    private String CHECK_OPTION;

    private String IS_UPDATABLE;

    private String DEFINER;

    private String SECURITY_TYPE;

    private String CHARACTER_SET_CLIENT;

    private String COLLATION_CONNECTION;

    private String VIEW_DEFINITION;

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

    public String getCHECK_OPTION() {
        return CHECK_OPTION;
    }

    public void setCHECK_OPTION(String CHECK_OPTION) {
        this.CHECK_OPTION = CHECK_OPTION == null ? null : CHECK_OPTION.trim();
    }

    public String getIS_UPDATABLE() {
        return IS_UPDATABLE;
    }

    public void setIS_UPDATABLE(String IS_UPDATABLE) {
        this.IS_UPDATABLE = IS_UPDATABLE == null ? null : IS_UPDATABLE.trim();
    }

    public String getDEFINER() {
        return DEFINER;
    }

    public void setDEFINER(String DEFINER) {
        this.DEFINER = DEFINER == null ? null : DEFINER.trim();
    }

    public String getSECURITY_TYPE() {
        return SECURITY_TYPE;
    }

    public void setSECURITY_TYPE(String SECURITY_TYPE) {
        this.SECURITY_TYPE = SECURITY_TYPE == null ? null : SECURITY_TYPE.trim();
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

    public String getVIEW_DEFINITION() {
        return VIEW_DEFINITION;
    }

    public void setVIEW_DEFINITION(String VIEW_DEFINITION) {
        this.VIEW_DEFINITION = VIEW_DEFINITION == null ? null : VIEW_DEFINITION.trim();
    }
}