package com.model;

public class Tablespaces {
    private String tablespaceName;

    private String engine;

    private String tablespaceType;

    private String logfileGroupName;

    private Long extentSize;

    private Long autoextendSize;

    private Long maximumSize;

    private Long nodegroupId;

    private String tablespaceComment;

    public String getTablespaceName() {
        return tablespaceName;
    }

    public void setTablespaceName(String tablespaceName) {
        this.tablespaceName = tablespaceName == null ? null : tablespaceName.trim();
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getTablespaceType() {
        return tablespaceType;
    }

    public void setTablespaceType(String tablespaceType) {
        this.tablespaceType = tablespaceType == null ? null : tablespaceType.trim();
    }

    public String getLogfileGroupName() {
        return logfileGroupName;
    }

    public void setLogfileGroupName(String logfileGroupName) {
        this.logfileGroupName = logfileGroupName == null ? null : logfileGroupName.trim();
    }

    public Long getExtentSize() {
        return extentSize;
    }

    public void setExtentSize(Long extentSize) {
        this.extentSize = extentSize;
    }

    public Long getAutoextendSize() {
        return autoextendSize;
    }

    public void setAutoextendSize(Long autoextendSize) {
        this.autoextendSize = autoextendSize;
    }

    public Long getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(Long maximumSize) {
        this.maximumSize = maximumSize;
    }

    public Long getNodegroupId() {
        return nodegroupId;
    }

    public void setNodegroupId(Long nodegroupId) {
        this.nodegroupId = nodegroupId;
    }

    public String getTablespaceComment() {
        return tablespaceComment;
    }

    public void setTablespaceComment(String tablespaceComment) {
        this.tablespaceComment = tablespaceComment == null ? null : tablespaceComment.trim();
    }
}