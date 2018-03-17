package com.model;

public class InnodbLockWaits {
    private String requesting_trx_id;

    private String requested_lock_id;

    private String blocking_trx_id;

    private String blocking_lock_id;

    public String getRequesting_trx_id() {
        return requesting_trx_id;
    }

    public void setRequesting_trx_id(String requesting_trx_id) {
        this.requesting_trx_id = requesting_trx_id == null ? null : requesting_trx_id.trim();
    }

    public String getRequested_lock_id() {
        return requested_lock_id;
    }

    public void setRequested_lock_id(String requested_lock_id) {
        this.requested_lock_id = requested_lock_id == null ? null : requested_lock_id.trim();
    }

    public String getBlocking_trx_id() {
        return blocking_trx_id;
    }

    public void setBlocking_trx_id(String blocking_trx_id) {
        this.blocking_trx_id = blocking_trx_id == null ? null : blocking_trx_id.trim();
    }

    public String getBlocking_lock_id() {
        return blocking_lock_id;
    }

    public void setBlocking_lock_id(String blocking_lock_id) {
        this.blocking_lock_id = blocking_lock_id == null ? null : blocking_lock_id.trim();
    }
}