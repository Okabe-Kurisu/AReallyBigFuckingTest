package com.model;

public class InnodbCmpmem {
    private Integer pageSize;

    private Integer bufferPoolInstance;

    private Integer pagesUsed;

    private Integer pagesFree;

    private Long relocationOps;

    private Integer relocationTime;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBufferPoolInstance() {
        return bufferPoolInstance;
    }

    public void setBufferPoolInstance(Integer bufferPoolInstance) {
        this.bufferPoolInstance = bufferPoolInstance;
    }

    public Integer getPagesUsed() {
        return pagesUsed;
    }

    public void setPagesUsed(Integer pagesUsed) {
        this.pagesUsed = pagesUsed;
    }

    public Integer getPagesFree() {
        return pagesFree;
    }

    public void setPagesFree(Integer pagesFree) {
        this.pagesFree = pagesFree;
    }

    public Long getRelocationOps() {
        return relocationOps;
    }

    public void setRelocationOps(Long relocationOps) {
        this.relocationOps = relocationOps;
    }

    public Integer getRelocationTime() {
        return relocationTime;
    }

    public void setRelocationTime(Integer relocationTime) {
        this.relocationTime = relocationTime;
    }
}