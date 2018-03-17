package com.model;

public class Plugins {
    private String PLUGIN_NAME;

    private String PLUGIN_VERSION;

    private String PLUGIN_STATUS;

    private String PLUGIN_TYPE;

    private String PLUGIN_TYPE_VERSION;

    private String PLUGIN_LIBRARY;

    private String PLUGIN_LIBRARY_VERSION;

    private String PLUGIN_AUTHOR;

    private String PLUGIN_LICENSE;

    private String LOAD_OPTION;

    private String PLUGIN_DESCRIPTION;

    public String getPLUGIN_NAME() {
        return PLUGIN_NAME;
    }

    public void setPLUGIN_NAME(String PLUGIN_NAME) {
        this.PLUGIN_NAME = PLUGIN_NAME == null ? null : PLUGIN_NAME.trim();
    }

    public String getPLUGIN_VERSION() {
        return PLUGIN_VERSION;
    }

    public void setPLUGIN_VERSION(String PLUGIN_VERSION) {
        this.PLUGIN_VERSION = PLUGIN_VERSION == null ? null : PLUGIN_VERSION.trim();
    }

    public String getPLUGIN_STATUS() {
        return PLUGIN_STATUS;
    }

    public void setPLUGIN_STATUS(String PLUGIN_STATUS) {
        this.PLUGIN_STATUS = PLUGIN_STATUS == null ? null : PLUGIN_STATUS.trim();
    }

    public String getPLUGIN_TYPE() {
        return PLUGIN_TYPE;
    }

    public void setPLUGIN_TYPE(String PLUGIN_TYPE) {
        this.PLUGIN_TYPE = PLUGIN_TYPE == null ? null : PLUGIN_TYPE.trim();
    }

    public String getPLUGIN_TYPE_VERSION() {
        return PLUGIN_TYPE_VERSION;
    }

    public void setPLUGIN_TYPE_VERSION(String PLUGIN_TYPE_VERSION) {
        this.PLUGIN_TYPE_VERSION = PLUGIN_TYPE_VERSION == null ? null : PLUGIN_TYPE_VERSION.trim();
    }

    public String getPLUGIN_LIBRARY() {
        return PLUGIN_LIBRARY;
    }

    public void setPLUGIN_LIBRARY(String PLUGIN_LIBRARY) {
        this.PLUGIN_LIBRARY = PLUGIN_LIBRARY == null ? null : PLUGIN_LIBRARY.trim();
    }

    public String getPLUGIN_LIBRARY_VERSION() {
        return PLUGIN_LIBRARY_VERSION;
    }

    public void setPLUGIN_LIBRARY_VERSION(String PLUGIN_LIBRARY_VERSION) {
        this.PLUGIN_LIBRARY_VERSION = PLUGIN_LIBRARY_VERSION == null ? null : PLUGIN_LIBRARY_VERSION.trim();
    }

    public String getPLUGIN_AUTHOR() {
        return PLUGIN_AUTHOR;
    }

    public void setPLUGIN_AUTHOR(String PLUGIN_AUTHOR) {
        this.PLUGIN_AUTHOR = PLUGIN_AUTHOR == null ? null : PLUGIN_AUTHOR.trim();
    }

    public String getPLUGIN_LICENSE() {
        return PLUGIN_LICENSE;
    }

    public void setPLUGIN_LICENSE(String PLUGIN_LICENSE) {
        this.PLUGIN_LICENSE = PLUGIN_LICENSE == null ? null : PLUGIN_LICENSE.trim();
    }

    public String getLOAD_OPTION() {
        return LOAD_OPTION;
    }

    public void setLOAD_OPTION(String LOAD_OPTION) {
        this.LOAD_OPTION = LOAD_OPTION == null ? null : LOAD_OPTION.trim();
    }

    public String getPLUGIN_DESCRIPTION() {
        return PLUGIN_DESCRIPTION;
    }

    public void setPLUGIN_DESCRIPTION(String PLUGIN_DESCRIPTION) {
        this.PLUGIN_DESCRIPTION = PLUGIN_DESCRIPTION == null ? null : PLUGIN_DESCRIPTION.trim();
    }
}