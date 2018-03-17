package com.model;

public class UserPrivileges {
    private String GRANTEE;

    private String TABLE_CATALOG;

    private String PRIVILEGE_TYPE;

    private String IS_GRANTABLE;

    public String getGRANTEE() {
        return GRANTEE;
    }

    public void setGRANTEE(String GRANTEE) {
        this.GRANTEE = GRANTEE == null ? null : GRANTEE.trim();
    }

    public String getTABLE_CATALOG() {
        return TABLE_CATALOG;
    }

    public void setTABLE_CATALOG(String TABLE_CATALOG) {
        this.TABLE_CATALOG = TABLE_CATALOG == null ? null : TABLE_CATALOG.trim();
    }

    public String getPRIVILEGE_TYPE() {
        return PRIVILEGE_TYPE;
    }

    public void setPRIVILEGE_TYPE(String PRIVILEGE_TYPE) {
        this.PRIVILEGE_TYPE = PRIVILEGE_TYPE == null ? null : PRIVILEGE_TYPE.trim();
    }

    public String getIS_GRANTABLE() {
        return IS_GRANTABLE;
    }

    public void setIS_GRANTABLE(String IS_GRANTABLE) {
        this.IS_GRANTABLE = IS_GRANTABLE == null ? null : IS_GRANTABLE.trim();
    }
}