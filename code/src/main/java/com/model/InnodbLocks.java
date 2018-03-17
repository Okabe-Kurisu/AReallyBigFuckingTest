package com.model;

public class InnodbLocks {
    private String lock_id;

    private String lock_trx_id;

    private String lock_mode;

    private String lock_type;

    private String lock_table;

    private String lock_index;

    private Long lock_space;

    private Long lock_page;

    private Long lock_rec;

    private String lock_data;

    public String getLock_id() {
        return lock_id;
    }

    public void setLock_id(String lock_id) {
        this.lock_id = lock_id == null ? null : lock_id.trim();
    }

    public String getLock_trx_id() {
        return lock_trx_id;
    }

    public void setLock_trx_id(String lock_trx_id) {
        this.lock_trx_id = lock_trx_id == null ? null : lock_trx_id.trim();
    }

    public String getLock_mode() {
        return lock_mode;
    }

    public void setLock_mode(String lock_mode) {
        this.lock_mode = lock_mode == null ? null : lock_mode.trim();
    }

    public String getLock_type() {
        return lock_type;
    }

    public void setLock_type(String lock_type) {
        this.lock_type = lock_type == null ? null : lock_type.trim();
    }

    public String getLock_table() {
        return lock_table;
    }

    public void setLock_table(String lock_table) {
        this.lock_table = lock_table == null ? null : lock_table.trim();
    }

    public String getLock_index() {
        return lock_index;
    }

    public void setLock_index(String lock_index) {
        this.lock_index = lock_index == null ? null : lock_index.trim();
    }

    public Long getLock_space() {
        return lock_space;
    }

    public void setLock_space(Long lock_space) {
        this.lock_space = lock_space;
    }

    public Long getLock_page() {
        return lock_page;
    }

    public void setLock_page(Long lock_page) {
        this.lock_page = lock_page;
    }

    public Long getLock_rec() {
        return lock_rec;
    }

    public void setLock_rec(Long lock_rec) {
        this.lock_rec = lock_rec;
    }

    public String getLock_data() {
        return lock_data;
    }

    public void setLock_data(String lock_data) {
        this.lock_data = lock_data == null ? null : lock_data.trim();
    }
}