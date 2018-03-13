package com.model;

public class ReferentialConstraints {
    private String constraintCatalog;

    private String constraintSchema;

    private String constraintName;

    private String uniqueConstraintCatalog;

    private String uniqueConstraintSchema;

    private String uniqueConstraintName;

    private String matchOption;

    private String updateRule;

    private String deleteRule;

    private String tableName;

    private String referencedTableName;

    public String getConstraintCatalog() {
        return constraintCatalog;
    }

    public void setConstraintCatalog(String constraintCatalog) {
        this.constraintCatalog = constraintCatalog == null ? null : constraintCatalog.trim();
    }

    public String getConstraintSchema() {
        return constraintSchema;
    }

    public void setConstraintSchema(String constraintSchema) {
        this.constraintSchema = constraintSchema == null ? null : constraintSchema.trim();
    }

    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName == null ? null : constraintName.trim();
    }

    public String getUniqueConstraintCatalog() {
        return uniqueConstraintCatalog;
    }

    public void setUniqueConstraintCatalog(String uniqueConstraintCatalog) {
        this.uniqueConstraintCatalog = uniqueConstraintCatalog == null ? null : uniqueConstraintCatalog.trim();
    }

    public String getUniqueConstraintSchema() {
        return uniqueConstraintSchema;
    }

    public void setUniqueConstraintSchema(String uniqueConstraintSchema) {
        this.uniqueConstraintSchema = uniqueConstraintSchema == null ? null : uniqueConstraintSchema.trim();
    }

    public String getUniqueConstraintName() {
        return uniqueConstraintName;
    }

    public void setUniqueConstraintName(String uniqueConstraintName) {
        this.uniqueConstraintName = uniqueConstraintName == null ? null : uniqueConstraintName.trim();
    }

    public String getMatchOption() {
        return matchOption;
    }

    public void setMatchOption(String matchOption) {
        this.matchOption = matchOption == null ? null : matchOption.trim();
    }

    public String getUpdateRule() {
        return updateRule;
    }

    public void setUpdateRule(String updateRule) {
        this.updateRule = updateRule == null ? null : updateRule.trim();
    }

    public String getDeleteRule() {
        return deleteRule;
    }

    public void setDeleteRule(String deleteRule) {
        this.deleteRule = deleteRule == null ? null : deleteRule.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getReferencedTableName() {
        return referencedTableName;
    }

    public void setReferencedTableName(String referencedTableName) {
        this.referencedTableName = referencedTableName == null ? null : referencedTableName.trim();
    }
}