package com.example.doanbanquanao.model;

public enum Size {
    S("S"),
    M("M"),
    L("L");
    private String size;
    private Size(){

    }
    private Size(String size) {
        this.size = size;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
