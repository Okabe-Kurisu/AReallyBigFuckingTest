package com.model;

public class Engines {
    private String ENGINE;

    private String SUPPORT;

    private String COMMENT;

    private String TRANSACTIONS;

    private String XA;

    private String SAVEPOINTS;

    public String getENGINE() {
        return ENGINE;
    }

    public void setENGINE(String ENGINE) {
        this.ENGINE = ENGINE == null ? null : ENGINE.trim();
    }

    public String getSUPPORT() {
        return SUPPORT;
    }

    public void setSUPPORT(String SUPPORT) {
        this.SUPPORT = SUPPORT == null ? null : SUPPORT.trim();
    }

    public String getCOMMENT() {
        return COMMENT;
    }

    public void setCOMMENT(String COMMENT) {
        this.COMMENT = COMMENT == null ? null : COMMENT.trim();
    }

    public String getTRANSACTIONS() {
        return TRANSACTIONS;
    }

    public void setTRANSACTIONS(String TRANSACTIONS) {
        this.TRANSACTIONS = TRANSACTIONS == null ? null : TRANSACTIONS.trim();
    }

    public String getXA() {
        return XA;
    }

    public void setXA(String XA) {
        this.XA = XA == null ? null : XA.trim();
    }

    public String getSAVEPOINTS() {
        return SAVEPOINTS;
    }

    public void setSAVEPOINTS(String SAVEPOINTS) {
        this.SAVEPOINTS = SAVEPOINTS == null ? null : SAVEPOINTS.trim();
    }
}