package com.model;

public class CharacterSets {
    private String characterSetName;

    private String defaultCollateName;

    private String description;

    private Long maxlen;

    public String getCharacterSetName() {
        return characterSetName;
    }

    public void setCharacterSetName(String characterSetName) {
        this.characterSetName = characterSetName == null ? null : characterSetName.trim();
    }

    public String getDefaultCollateName() {
        return defaultCollateName;
    }

    public void setDefaultCollateName(String defaultCollateName) {
        this.defaultCollateName = defaultCollateName == null ? null : defaultCollateName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getMaxlen() {
        return maxlen;
    }

    public void setMaxlen(Long maxlen) {
        this.maxlen = maxlen;
    }
}