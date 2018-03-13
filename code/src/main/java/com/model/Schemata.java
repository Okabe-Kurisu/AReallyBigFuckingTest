package com.model;

public class Schemata {
    private String catalogName;

    private String schemaName;

    private String defaultCharacterSetName;

    private String defaultCollationName;

    private String sqlPath;

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName == null ? null : schemaName.trim();
    }

    public String getDefaultCharacterSetName() {
        return defaultCharacterSetName;
    }

    public void setDefaultCharacterSetName(String defaultCharacterSetName) {
        this.defaultCharacterSetName = defaultCharacterSetName == null ? null : defaultCharacterSetName.trim();
    }

    public String getDefaultCollationName() {
        return defaultCollationName;
    }

    public void setDefaultCollationName(String defaultCollationName) {
        this.defaultCollationName = defaultCollationName == null ? null : defaultCollationName.trim();
    }

    public String getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(String sqlPath) {
        this.sqlPath = sqlPath == null ? null : sqlPath.trim();
    }
}