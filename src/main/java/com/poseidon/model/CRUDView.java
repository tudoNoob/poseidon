package com.poseidon.model;


public class CRUDView {

    private String isSave;

    private String isUpdate;

    private String isSearch;

    private String isDelete;

    private String isToShowAll;

    public String getIsToShowAll() {
        return isToShowAll;
    }

    public void setIsToShowAll(String isToShowAll) {
        this.isToShowAll = isToShowAll;
    }

    public String getIsSave() {
        return isSave;
    }

    public void setIsSave(String isSave) {
        this.isSave = isSave;
    }

    public String getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(String isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getIsSearch() {
        return isSearch;
    }

    public void setIsSearch(String isSearch) {
        this.isSearch = isSearch;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
