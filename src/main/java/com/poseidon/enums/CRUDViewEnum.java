package com.poseidon.enums;

public enum CRUDViewEnum {

    IS_SAVE("isSave"),
    IS_DELETE("isDelete"),
    IS_UPDATE("isUpdate"),
    IS_SEARCH("isSearch"),
    IS_To_SHOW_ALL("isToShowAll");



    private String operation;

    CRUDViewEnum(String operation) {
    this.operation=operation;
    }

    public String getOperation() {
        return operation;
    }
}
