package com.model;

import java.util.Date;

public class InnodbTrx {
    private String trx_id;

    private String trx_state;

    private Date trx_started;

    private String trx_requested_lock_id;

    private Date trx_wait_started;

    private Long trx_weight;

    private Long trx_mysql_thread_id;

    private String trx_query;

    private String trx_operation_state;

    private Long trx_tables_in_use;

    private Long trx_tables_locked;

    private Long trx_lock_structs;

    private Long trx_lock_memory_bytes;

    private Long trx_rows_locked;

    private Long trx_rows_modified;

    private Long trx_concurrency_tickets;

    private String trx_isolation_level;

    private Integer trx_unique_checks;

    private Integer trx_foreign_key_checks;

    private String trx_last_foreign_key_error;

    private Integer trx_adaptive_hash_latched;

    private Long trx_adaptive_hash_timeout;

    public String getTrx_id() {
        return trx_id;
    }

    public void setTrx_id(String trx_id) {
        this.trx_id = trx_id == null ? null : trx_id.trim();
    }

    public String getTrx_state() {
        return trx_state;
    }

    public void setTrx_state(String trx_state) {
        this.trx_state = trx_state == null ? null : trx_state.trim();
    }

    public Date getTrx_started() {
        return trx_started;
    }

    public void setTrx_started(Date trx_started) {
        this.trx_started = trx_started;
    }

    public String getTrx_requested_lock_id() {
        return trx_requested_lock_id;
    }

    public void setTrx_requested_lock_id(String trx_requested_lock_id) {
        this.trx_requested_lock_id = trx_requested_lock_id == null ? null : trx_requested_lock_id.trim();
    }

    public Date getTrx_wait_started() {
        return trx_wait_started;
    }

    public void setTrx_wait_started(Date trx_wait_started) {
        this.trx_wait_started = trx_wait_started;
    }

    public Long getTrx_weight() {
        return trx_weight;
    }

    public void setTrx_weight(Long trx_weight) {
        this.trx_weight = trx_weight;
    }

    public Long getTrx_mysql_thread_id() {
        return trx_mysql_thread_id;
    }

    public void setTrx_mysql_thread_id(Long trx_mysql_thread_id) {
        this.trx_mysql_thread_id = trx_mysql_thread_id;
    }

    public String getTrx_query() {
        return trx_query;
    }

    public void setTrx_query(String trx_query) {
        this.trx_query = trx_query == null ? null : trx_query.trim();
    }

    public String getTrx_operation_state() {
        return trx_operation_state;
    }

    public void setTrx_operation_state(String trx_operation_state) {
        this.trx_operation_state = trx_operation_state == null ? null : trx_operation_state.trim();
    }

    public Long getTrx_tables_in_use() {
        return trx_tables_in_use;
    }

    public void setTrx_tables_in_use(Long trx_tables_in_use) {
        this.trx_tables_in_use = trx_tables_in_use;
    }

    public Long getTrx_tables_locked() {
        return trx_tables_locked;
    }

    public void setTrx_tables_locked(Long trx_tables_locked) {
        this.trx_tables_locked = trx_tables_locked;
    }

    public Long getTrx_lock_structs() {
        return trx_lock_structs;
    }

    public void setTrx_lock_structs(Long trx_lock_structs) {
        this.trx_lock_structs = trx_lock_structs;
    }

    public Long getTrx_lock_memory_bytes() {
        return trx_lock_memory_bytes;
    }

    public void setTrx_lock_memory_bytes(Long trx_lock_memory_bytes) {
        this.trx_lock_memory_bytes = trx_lock_memory_bytes;
    }

    public Long getTrx_rows_locked() {
        return trx_rows_locked;
    }

    public void setTrx_rows_locked(Long trx_rows_locked) {
        this.trx_rows_locked = trx_rows_locked;
    }

    public Long getTrx_rows_modified() {
        return trx_rows_modified;
    }

    public void setTrx_rows_modified(Long trx_rows_modified) {
        this.trx_rows_modified = trx_rows_modified;
    }

    public Long getTrx_concurrency_tickets() {
        return trx_concurrency_tickets;
    }

    public void setTrx_concurrency_tickets(Long trx_concurrency_tickets) {
        this.trx_concurrency_tickets = trx_concurrency_tickets;
    }

    public String getTrx_isolation_level() {
        return trx_isolation_level;
    }

    public void setTrx_isolation_level(String trx_isolation_level) {
        this.trx_isolation_level = trx_isolation_level == null ? null : trx_isolation_level.trim();
    }

    public Integer getTrx_unique_checks() {
        return trx_unique_checks;
    }

    public void setTrx_unique_checks(Integer trx_unique_checks) {
        this.trx_unique_checks = trx_unique_checks;
    }

    public Integer getTrx_foreign_key_checks() {
        return trx_foreign_key_checks;
    }

    public void setTrx_foreign_key_checks(Integer trx_foreign_key_checks) {
        this.trx_foreign_key_checks = trx_foreign_key_checks;
    }

    public String getTrx_last_foreign_key_error() {
        return trx_last_foreign_key_error;
    }

    public void setTrx_last_foreign_key_error(String trx_last_foreign_key_error) {
        this.trx_last_foreign_key_error = trx_last_foreign_key_error == null ? null : trx_last_foreign_key_error.trim();
    }

    public Integer getTrx_adaptive_hash_latched() {
        return trx_adaptive_hash_latched;
    }

    public void setTrx_adaptive_hash_latched(Integer trx_adaptive_hash_latched) {
        this.trx_adaptive_hash_latched = trx_adaptive_hash_latched;
    }

    public Long getTrx_adaptive_hash_timeout() {
        return trx_adaptive_hash_timeout;
    }

    public void setTrx_adaptive_hash_timeout(Long trx_adaptive_hash_timeout) {
        this.trx_adaptive_hash_timeout = trx_adaptive_hash_timeout;
    }
}