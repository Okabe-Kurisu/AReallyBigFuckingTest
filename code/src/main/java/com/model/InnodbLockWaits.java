package com.model;

public class InnodbLockWaits {
    private String requestingTrxId;

    private String requestedLockId;

    private String blockingTrxId;

    private String blockingLockId;

    public String getRequestingTrxId() {
        return requestingTrxId;
    }

    public void setRequestingTrxId(String requestingTrxId) {
        this.requestingTrxId = requestingTrxId == null ? null : requestingTrxId.trim();
    }

    public String getRequestedLockId() {
        return requestedLockId;
    }

    public void setRequestedLockId(String requestedLockId) {
        this.requestedLockId = requestedLockId == null ? null : requestedLockId.trim();
    }

    public String getBlockingTrxId() {
        return blockingTrxId;
    }

    public void setBlockingTrxId(String blockingTrxId) {
        this.blockingTrxId = blockingTrxId == null ? null : blockingTrxId.trim();
    }

    public String getBlockingLockId() {
        return blockingLockId;
    }

    public void setBlockingLockId(String blockingLockId) {
        this.blockingLockId = blockingLockId == null ? null : blockingLockId.trim();
    }
}