package com.model;

public class InnodbCmpReset {
    private Integer page_size;

    private Integer compress_ops;

    private Integer compress_ops_ok;

    private Integer compress_time;

    private Integer uncompress_ops;

    private Integer uncompress_time;

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Integer getCompress_ops() {
        return compress_ops;
    }

    public void setCompress_ops(Integer compress_ops) {
        this.compress_ops = compress_ops;
    }

    public Integer getCompress_ops_ok() {
        return compress_ops_ok;
    }

    public void setCompress_ops_ok(Integer compress_ops_ok) {
        this.compress_ops_ok = compress_ops_ok;
    }

    public Integer getCompress_time() {
        return compress_time;
    }

    public void setCompress_time(Integer compress_time) {
        this.compress_time = compress_time;
    }

    public Integer getUncompress_ops() {
        return uncompress_ops;
    }

    public void setUncompress_ops(Integer uncompress_ops) {
        this.uncompress_ops = uncompress_ops;
    }

    public Integer getUncompress_time() {
        return uncompress_time;
    }

    public void setUncompress_time(Integer uncompress_time) {
        this.uncompress_time = uncompress_time;
    }
}