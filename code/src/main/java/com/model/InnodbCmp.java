package com.model;

public class InnodbCmp {
    private Integer pageSize;

    private Integer compressOps;

    private Integer compressOpsOk;

    private Integer compressTime;

    private Integer uncompressOps;

    private Integer uncompressTime;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCompressOps() {
        return compressOps;
    }

    public void setCompressOps(Integer compressOps) {
        this.compressOps = compressOps;
    }

    public Integer getCompressOpsOk() {
        return compressOpsOk;
    }

    public void setCompressOpsOk(Integer compressOpsOk) {
        this.compressOpsOk = compressOpsOk;
    }

    public Integer getCompressTime() {
        return compressTime;
    }

    public void setCompressTime(Integer compressTime) {
        this.compressTime = compressTime;
    }

    public Integer getUncompressOps() {
        return uncompressOps;
    }

    public void setUncompressOps(Integer uncompressOps) {
        this.uncompressOps = uncompressOps;
    }

    public Integer getUncompressTime() {
        return uncompressTime;
    }

    public void setUncompressTime(Integer uncompressTime) {
        this.uncompressTime = uncompressTime;
    }
}