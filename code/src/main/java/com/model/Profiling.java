package com.model;

import java.math.BigDecimal;

public class Profiling {
    private Integer queryId;

    private Integer seq;

    private String state;

    private BigDecimal duration;

    private BigDecimal cpuUser;

    private BigDecimal cpuSystem;

    private Integer contextVoluntary;

    private Integer contextInvoluntary;

    private Integer blockOpsIn;

    private Integer blockOpsOut;

    private Integer messagesSent;

    private Integer messagesReceived;

    private Integer pageFaultsMajor;

    private Integer pageFaultsMinor;

    private Integer swaps;

    private String sourceFunction;

    private String sourceFile;

    private Integer sourceLine;

    public Integer getQueryId() {
        return queryId;
    }

    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public BigDecimal getCpuUser() {
        return cpuUser;
    }

    public void setCpuUser(BigDecimal cpuUser) {
        this.cpuUser = cpuUser;
    }

    public BigDecimal getCpuSystem() {
        return cpuSystem;
    }

    public void setCpuSystem(BigDecimal cpuSystem) {
        this.cpuSystem = cpuSystem;
    }

    public Integer getContextVoluntary() {
        return contextVoluntary;
    }

    public void setContextVoluntary(Integer contextVoluntary) {
        this.contextVoluntary = contextVoluntary;
    }

    public Integer getContextInvoluntary() {
        return contextInvoluntary;
    }

    public void setContextInvoluntary(Integer contextInvoluntary) {
        this.contextInvoluntary = contextInvoluntary;
    }

    public Integer getBlockOpsIn() {
        return blockOpsIn;
    }

    public void setBlockOpsIn(Integer blockOpsIn) {
        this.blockOpsIn = blockOpsIn;
    }

    public Integer getBlockOpsOut() {
        return blockOpsOut;
    }

    public void setBlockOpsOut(Integer blockOpsOut) {
        this.blockOpsOut = blockOpsOut;
    }

    public Integer getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(Integer messagesSent) {
        this.messagesSent = messagesSent;
    }

    public Integer getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(Integer messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    public Integer getPageFaultsMajor() {
        return pageFaultsMajor;
    }

    public void setPageFaultsMajor(Integer pageFaultsMajor) {
        this.pageFaultsMajor = pageFaultsMajor;
    }

    public Integer getPageFaultsMinor() {
        return pageFaultsMinor;
    }

    public void setPageFaultsMinor(Integer pageFaultsMinor) {
        this.pageFaultsMinor = pageFaultsMinor;
    }

    public Integer getSwaps() {
        return swaps;
    }

    public void setSwaps(Integer swaps) {
        this.swaps = swaps;
    }

    public String getSourceFunction() {
        return sourceFunction;
    }

    public void setSourceFunction(String sourceFunction) {
        this.sourceFunction = sourceFunction == null ? null : sourceFunction.trim();
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile == null ? null : sourceFile.trim();
    }

    public Integer getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(Integer sourceLine) {
        this.sourceLine = sourceLine;
    }
}