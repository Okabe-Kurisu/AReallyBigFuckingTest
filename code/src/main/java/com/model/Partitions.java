package com.model;

import java.util.Date;

public class Partitions {
    private String tableCatalog;

    private String tableSchema;

    private String tableName;

    private String partitionName;

    private String subpartitionName;

    private Long partitionOrdinalPosition;

    private Long subpartitionOrdinalPosition;

    private String partitionMethod;

    private String subpartitionMethod;

    private Long tableRows;

    private Long avgRowLength;

    private Long dataLength;

    private Long maxDataLength;

    private Long indexLength;

    private Long dataFree;

    private Date createTime;

    private Date updateTime;

    private Date checkTime;

    private Long checksum;

    private String partitionComment;

    private String nodegroup;

    private String tablespaceName;

    private String partitionExpression;

    private String subpartitionExpression;

    private String partitionDescription;

    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog == null ? null : tableCatalog.trim();
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema == null ? null : tableSchema.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getPartitionName() {
        return partitionName;
    }

    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName == null ? null : partitionName.trim();
    }

    public String getSubpartitionName() {
        return subpartitionName;
    }

    public void setSubpartitionName(String subpartitionName) {
        this.subpartitionName = subpartitionName == null ? null : subpartitionName.trim();
    }

    public Long getPartitionOrdinalPosition() {
        return partitionOrdinalPosition;
    }

    public void setPartitionOrdinalPosition(Long partitionOrdinalPosition) {
        this.partitionOrdinalPosition = partitionOrdinalPosition;
    }

    public Long getSubpartitionOrdinalPosition() {
        return subpartitionOrdinalPosition;
    }

    public void setSubpartitionOrdinalPosition(Long subpartitionOrdinalPosition) {
        this.subpartitionOrdinalPosition = subpartitionOrdinalPosition;
    }

    public String getPartitionMethod() {
        return partitionMethod;
    }

    public void setPartitionMethod(String partitionMethod) {
        this.partitionMethod = partitionMethod == null ? null : partitionMethod.trim();
    }

    public String getSubpartitionMethod() {
        return subpartitionMethod;
    }

    public void setSubpartitionMethod(String subpartitionMethod) {
        this.subpartitionMethod = subpartitionMethod == null ? null : subpartitionMethod.trim();
    }

    public Long getTableRows() {
        return tableRows;
    }

    public void setTableRows(Long tableRows) {
        this.tableRows = tableRows;
    }

    public Long getAvgRowLength() {
        return avgRowLength;
    }

    public void setAvgRowLength(Long avgRowLength) {
        this.avgRowLength = avgRowLength;
    }

    public Long getDataLength() {
        return dataLength;
    }

    public void setDataLength(Long dataLength) {
        this.dataLength = dataLength;
    }

    public Long getMaxDataLength() {
        return maxDataLength;
    }

    public void setMaxDataLength(Long maxDataLength) {
        this.maxDataLength = maxDataLength;
    }

    public Long getIndexLength() {
        return indexLength;
    }

    public void setIndexLength(Long indexLength) {
        this.indexLength = indexLength;
    }

    public Long getDataFree() {
        return dataFree;
    }

    public void setDataFree(Long dataFree) {
        this.dataFree = dataFree;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Long getChecksum() {
        return checksum;
    }

    public void setChecksum(Long checksum) {
        this.checksum = checksum;
    }

    public String getPartitionComment() {
        return partitionComment;
    }

    public void setPartitionComment(String partitionComment) {
        this.partitionComment = partitionComment == null ? null : partitionComment.trim();
    }

    public String getNodegroup() {
        return nodegroup;
    }

    public void setNodegroup(String nodegroup) {
        this.nodegroup = nodegroup == null ? null : nodegroup.trim();
    }

    public String getTablespaceName() {
        return tablespaceName;
    }

    public void setTablespaceName(String tablespaceName) {
        this.tablespaceName = tablespaceName == null ? null : tablespaceName.trim();
    }

    public String getPartitionExpression() {
        return partitionExpression;
    }

    public void setPartitionExpression(String partitionExpression) {
        this.partitionExpression = partitionExpression == null ? null : partitionExpression.trim();
    }

    public String getSubpartitionExpression() {
        return subpartitionExpression;
    }

    public void setSubpartitionExpression(String subpartitionExpression) {
        this.subpartitionExpression = subpartitionExpression == null ? null : subpartitionExpression.trim();
    }

    public String getPartitionDescription() {
        return partitionDescription;
    }

    public void setPartitionDescription(String partitionDescription) {
        this.partitionDescription = partitionDescription == null ? null : partitionDescription.trim();
    }
}