package com.model;

public class Plugins {
    private String pluginName;

    private String pluginVersion;

    private String pluginStatus;

    private String pluginType;

    private String pluginTypeVersion;

    private String pluginLibrary;

    private String pluginLibraryVersion;

    private String pluginAuthor;

    private String pluginLicense;

    private String loadOption;

    private String pluginDescription;

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName == null ? null : pluginName.trim();
    }

    public String getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(String pluginVersion) {
        this.pluginVersion = pluginVersion == null ? null : pluginVersion.trim();
    }

    public String getPluginStatus() {
        return pluginStatus;
    }

    public void setPluginStatus(String pluginStatus) {
        this.pluginStatus = pluginStatus == null ? null : pluginStatus.trim();
    }

    public String getPluginType() {
        return pluginType;
    }

    public void setPluginType(String pluginType) {
        this.pluginType = pluginType == null ? null : pluginType.trim();
    }

    public String getPluginTypeVersion() {
        return pluginTypeVersion;
    }

    public void setPluginTypeVersion(String pluginTypeVersion) {
        this.pluginTypeVersion = pluginTypeVersion == null ? null : pluginTypeVersion.trim();
    }

    public String getPluginLibrary() {
        return pluginLibrary;
    }

    public void setPluginLibrary(String pluginLibrary) {
        this.pluginLibrary = pluginLibrary == null ? null : pluginLibrary.trim();
    }

    public String getPluginLibraryVersion() {
        return pluginLibraryVersion;
    }

    public void setPluginLibraryVersion(String pluginLibraryVersion) {
        this.pluginLibraryVersion = pluginLibraryVersion == null ? null : pluginLibraryVersion.trim();
    }

    public String getPluginAuthor() {
        return pluginAuthor;
    }

    public void setPluginAuthor(String pluginAuthor) {
        this.pluginAuthor = pluginAuthor == null ? null : pluginAuthor.trim();
    }

    public String getPluginLicense() {
        return pluginLicense;
    }

    public void setPluginLicense(String pluginLicense) {
        this.pluginLicense = pluginLicense == null ? null : pluginLicense.trim();
    }

    public String getLoadOption() {
        return loadOption;
    }

    public void setLoadOption(String loadOption) {
        this.loadOption = loadOption == null ? null : loadOption.trim();
    }

    public String getPluginDescription() {
        return pluginDescription;
    }

    public void setPluginDescription(String pluginDescription) {
        this.pluginDescription = pluginDescription == null ? null : pluginDescription.trim();
    }
}