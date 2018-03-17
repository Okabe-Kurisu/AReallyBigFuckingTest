package com.model;

import java.math.BigDecimal;

public class Profiling {
    private Integer QUERY_ID;

    private Integer SEQ;

    private String STATE;

    private BigDecimal DURATION;

    private BigDecimal CPU_USER;

    private BigDecimal CPU_SYSTEM;

    private Integer CONTEXT_VOLUNTARY;

    private Integer CONTEXT_INVOLUNTARY;

    private Integer BLOCK_OPS_IN;

    private Integer BLOCK_OPS_OUT;

    private Integer MESSAGES_SENT;

    private Integer MESSAGES_RECEIVED;

    private Integer PAGE_FAULTS_MAJOR;

    private Integer PAGE_FAULTS_MINOR;

    private Integer SWAPS;

    private String SOURCE_FUNCTION;

    private String SOURCE_FILE;

    private Integer SOURCE_LINE;

    public Integer getQUERY_ID() {
        return QUERY_ID;
    }

    public void setQUERY_ID(Integer QUERY_ID) {
        this.QUERY_ID = QUERY_ID;
    }

    public Integer getSEQ() {
        return SEQ;
    }

    public void setSEQ(Integer SEQ) {
        this.SEQ = SEQ;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE == null ? null : STATE.trim();
    }

    public BigDecimal getDURATION() {
        return DURATION;
    }

    public void setDURATION(BigDecimal DURATION) {
        this.DURATION = DURATION;
    }

    public BigDecimal getCPU_USER() {
        return CPU_USER;
    }

    public void setCPU_USER(BigDecimal CPU_USER) {
        this.CPU_USER = CPU_USER;
    }

    public BigDecimal getCPU_SYSTEM() {
        return CPU_SYSTEM;
    }

    public void setCPU_SYSTEM(BigDecimal CPU_SYSTEM) {
        this.CPU_SYSTEM = CPU_SYSTEM;
    }

    public Integer getCONTEXT_VOLUNTARY() {
        return CONTEXT_VOLUNTARY;
    }

    public void setCONTEXT_VOLUNTARY(Integer CONTEXT_VOLUNTARY) {
        this.CONTEXT_VOLUNTARY = CONTEXT_VOLUNTARY;
    }

    public Integer getCONTEXT_INVOLUNTARY() {
        return CONTEXT_INVOLUNTARY;
    }

    public void setCONTEXT_INVOLUNTARY(Integer CONTEXT_INVOLUNTARY) {
        this.CONTEXT_INVOLUNTARY = CONTEXT_INVOLUNTARY;
    }

    public Integer getBLOCK_OPS_IN() {
        return BLOCK_OPS_IN;
    }

    public void setBLOCK_OPS_IN(Integer BLOCK_OPS_IN) {
        this.BLOCK_OPS_IN = BLOCK_OPS_IN;
    }

    public Integer getBLOCK_OPS_OUT() {
        return BLOCK_OPS_OUT;
    }

    public void setBLOCK_OPS_OUT(Integer BLOCK_OPS_OUT) {
        this.BLOCK_OPS_OUT = BLOCK_OPS_OUT;
    }

    public Integer getMESSAGES_SENT() {
        return MESSAGES_SENT;
    }

    public void setMESSAGES_SENT(Integer MESSAGES_SENT) {
        this.MESSAGES_SENT = MESSAGES_SENT;
    }

    public Integer getMESSAGES_RECEIVED() {
        return MESSAGES_RECEIVED;
    }

    public void setMESSAGES_RECEIVED(Integer MESSAGES_RECEIVED) {
        this.MESSAGES_RECEIVED = MESSAGES_RECEIVED;
    }

    public Integer getPAGE_FAULTS_MAJOR() {
        return PAGE_FAULTS_MAJOR;
    }

    public void setPAGE_FAULTS_MAJOR(Integer PAGE_FAULTS_MAJOR) {
        this.PAGE_FAULTS_MAJOR = PAGE_FAULTS_MAJOR;
    }

    public Integer getPAGE_FAULTS_MINOR() {
        return PAGE_FAULTS_MINOR;
    }

    public void setPAGE_FAULTS_MINOR(Integer PAGE_FAULTS_MINOR) {
        this.PAGE_FAULTS_MINOR = PAGE_FAULTS_MINOR;
    }

    public Integer getSWAPS() {
        return SWAPS;
    }

    public void setSWAPS(Integer SWAPS) {
        this.SWAPS = SWAPS;
    }

    public String getSOURCE_FUNCTION() {
        return SOURCE_FUNCTION;
    }

    public void setSOURCE_FUNCTION(String SOURCE_FUNCTION) {
        this.SOURCE_FUNCTION = SOURCE_FUNCTION == null ? null : SOURCE_FUNCTION.trim();
    }

    public String getSOURCE_FILE() {
        return SOURCE_FILE;
    }

    public void setSOURCE_FILE(String SOURCE_FILE) {
        this.SOURCE_FILE = SOURCE_FILE == null ? null : SOURCE_FILE.trim();
    }

    public Integer getSOURCE_LINE() {
        return SOURCE_LINE;
    }

    public void setSOURCE_LINE(Integer SOURCE_LINE) {
        this.SOURCE_LINE = SOURCE_LINE;
    }
}