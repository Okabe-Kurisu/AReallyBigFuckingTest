package com.model;

public class Parameters {
    private String specificCatalog;

    private String specificSchema;

    private String specificName;

    private Integer ordinalPosition;

    private String parameterMode;

    private String parameterName;

    private String dataType;

    private Integer characterMaximumLength;

    private Integer characterOctetLength;

    private Integer numericPrecision;

    private Integer numericScale;

    private String characterSetName;

    private String collationName;

    private String routineType;

    private String dtdIdentifier;

    public String getSpecificCatalog() {
        return specificCatalog;
    }

    public void setSpecificCatalog(String specificCatalog) {
        this.specificCatalog = specificCatalog == null ? null : specificCatalog.trim();
    }

    public String getSpecificSchema() {
        return specificSchema;
    }

    public void setSpecificSchema(String specificSchema) {
        this.specificSchema = specificSchema == null ? null : specificSchema.trim();
    }

    public String getSpecificName() {
        return specificName;
    }

    public void setSpecificName(String specificName) {
        this.specificName = specificName == null ? null : specificName.trim();
    }

    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getParameterMode() {
        return parameterMode;
    }

    public void setParameterMode(String parameterMode) {
        this.parameterMode = parameterMode == null ? null : parameterMode.trim();
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName == null ? null : parameterName.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public Integer getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(Integer characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    public Integer getCharacterOctetLength() {
        return characterOctetLength;
    }

    public void setCharacterOctetLength(Integer characterOctetLength) {
        this.characterOctetLength = characterOctetLength;
    }

    public Integer getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(Integer numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public Integer getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(Integer numericScale) {
        this.numericScale = numericScale;
    }

    public String getCharacterSetName() {
        return characterSetName;
    }

    public void setCharacterSetName(String characterSetName) {
        this.characterSetName = characterSetName == null ? null : characterSetName.trim();
    }

    public String getCollationName() {
        return collationName;
    }

    public void setCollationName(String collationName) {
        this.collationName = collationName == null ? null : collationName.trim();
    }

    public String getRoutineType() {
        return routineType;
    }

    public void setRoutineType(String routineType) {
        this.routineType = routineType == null ? null : routineType.trim();
    }

    public String getDtdIdentifier() {
        return dtdIdentifier;
    }

    public void setDtdIdentifier(String dtdIdentifier) {
        this.dtdIdentifier = dtdIdentifier == null ? null : dtdIdentifier.trim();
    }
}