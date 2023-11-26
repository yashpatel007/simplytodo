package com.simplytodo.enums;

public enum DescriptionBlockType {
    PLAIN_TEXT("PLAIN_TEXT"),
    MD_FORMATTED("MD_FORMATTED"),
    IMAGE("IMAGE");
    private String value;
    private DescriptionBlockType(String name) {
        this.value = name;
    }
    public String getValue() {
        return value;
    }
}
