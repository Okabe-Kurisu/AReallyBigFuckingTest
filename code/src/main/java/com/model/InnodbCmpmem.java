package com.model;

public class InnodbCmpmem {
    private Integer page_size;

    private Integer buffer_pool_instance;

    private Integer pages_used;

    private Integer pages_free;

    private Long relocation_ops;

    private Integer relocation_time;

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Integer getBuffer_pool_instance() {
        return buffer_pool_instance;
    }

    public void setBuffer_pool_instance(Integer buffer_pool_instance) {
        this.buffer_pool_instance = buffer_pool_instance;
    }

    public Integer getPages_used() {
        return pages_used;
    }

    public void setPages_used(Integer pages_used) {
        this.pages_used = pages_used;
    }

    public Integer getPages_free() {
        return pages_free;
    }

    public void setPages_free(Integer pages_free) {
        this.pages_free = pages_free;
    }

    public Long getRelocation_ops() {
        return relocation_ops;
    }

    public void setRelocation_ops(Long relocation_ops) {
        this.relocation_ops = relocation_ops;
    }

    public Integer getRelocation_time() {
        return relocation_time;
    }

    public void setRelocation_time(Integer relocation_time) {
        this.relocation_time = relocation_time;
    }
}