package com.simplytodo.enums;

public enum TodoTaskStatus {
    COMPLETED, IN_PROGRESS, NOT_STARTED;

    public static TodoTaskStatus fromString(String str) {
        for (TodoTaskStatus type : TodoTaskStatus.values()) {
            if (type.name().equalsIgnoreCase(str)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + TodoTaskStatus.class.getName() + "." + str);
    }
}
