package com.model;

public class InnodbBufferPoolStats {
    private Long poolId;

    private Long poolSize;

    private Long freeBuffers;

    private Long databasePages;

    private Long oldDatabasePages;

    private Long modifiedDatabasePages;

    private Long pendingDecompress;

    private Long pendingReads;

    private Long pendingFlushLru;

    private Long pendingFlushList;

    private Long pagesMadeYoung;

    private Long pagesNotMadeYoung;

    private Double pagesMadeYoungRate;

    private Double pagesMadeNotYoungRate;

    private Long numberPagesRead;

    private Long numberPagesCreated;

    private Long numberPagesWritten;

    private Double pagesReadRate;

    private Double pagesCreateRate;

    private Double pagesWrittenRate;

    private Long numberPagesGet;

    private Long hitRate;

    private Long youngMakePerThousandGets;

    private Long notYoungMakePerThousandGets;

    private Long numberPagesReadAhead;

    private Long numberReadAheadEvicted;

    private Double readAheadRate;

    private Double readAheadEvictedRate;

    private Long lruIoTotal;

    private Long lruIoCurrent;

    private Long uncompressTotal;

    private Long uncompressCurrent;

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Long getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Long poolSize) {
        this.poolSize = poolSize;
    }

    public Long getFreeBuffers() {
        return freeBuffers;
    }

    public void setFreeBuffers(Long freeBuffers) {
        this.freeBuffers = freeBuffers;
    }

    public Long getDatabasePages() {
        return databasePages;
    }

    public void setDatabasePages(Long databasePages) {
        this.databasePages = databasePages;
    }

    public Long getOldDatabasePages() {
        return oldDatabasePages;
    }

    public void setOldDatabasePages(Long oldDatabasePages) {
        this.oldDatabasePages = oldDatabasePages;
    }

    public Long getModifiedDatabasePages() {
        return modifiedDatabasePages;
    }

    public void setModifiedDatabasePages(Long modifiedDatabasePages) {
        this.modifiedDatabasePages = modifiedDatabasePages;
    }

    public Long getPendingDecompress() {
        return pendingDecompress;
    }

    public void setPendingDecompress(Long pendingDecompress) {
        this.pendingDecompress = pendingDecompress;
    }

    public Long getPendingReads() {
        return pendingReads;
    }

    public void setPendingReads(Long pendingReads) {
        this.pendingReads = pendingReads;
    }

    public Long getPendingFlushLru() {
        return pendingFlushLru;
    }

    public void setPendingFlushLru(Long pendingFlushLru) {
        this.pendingFlushLru = pendingFlushLru;
    }

    public Long getPendingFlushList() {
        return pendingFlushList;
    }

    public void setPendingFlushList(Long pendingFlushList) {
        this.pendingFlushList = pendingFlushList;
    }

    public Long getPagesMadeYoung() {
        return pagesMadeYoung;
    }

    public void setPagesMadeYoung(Long pagesMadeYoung) {
        this.pagesMadeYoung = pagesMadeYoung;
    }

    public Long getPagesNotMadeYoung() {
        return pagesNotMadeYoung;
    }

    public void setPagesNotMadeYoung(Long pagesNotMadeYoung) {
        this.pagesNotMadeYoung = pagesNotMadeYoung;
    }

    public Double getPagesMadeYoungRate() {
        return pagesMadeYoungRate;
    }

    public void setPagesMadeYoungRate(Double pagesMadeYoungRate) {
        this.pagesMadeYoungRate = pagesMadeYoungRate;
    }

    public Double getPagesMadeNotYoungRate() {
        return pagesMadeNotYoungRate;
    }

    public void setPagesMadeNotYoungRate(Double pagesMadeNotYoungRate) {
        this.pagesMadeNotYoungRate = pagesMadeNotYoungRate;
    }

    public Long getNumberPagesRead() {
        return numberPagesRead;
    }

    public void setNumberPagesRead(Long numberPagesRead) {
        this.numberPagesRead = numberPagesRead;
    }

    public Long getNumberPagesCreated() {
        return numberPagesCreated;
    }

    public void setNumberPagesCreated(Long numberPagesCreated) {
        this.numberPagesCreated = numberPagesCreated;
    }

    public Long getNumberPagesWritten() {
        return numberPagesWritten;
    }

    public void setNumberPagesWritten(Long numberPagesWritten) {
        this.numberPagesWritten = numberPagesWritten;
    }

    public Double getPagesReadRate() {
        return pagesReadRate;
    }

    public void setPagesReadRate(Double pagesReadRate) {
        this.pagesReadRate = pagesReadRate;
    }

    public Double getPagesCreateRate() {
        return pagesCreateRate;
    }

    public void setPagesCreateRate(Double pagesCreateRate) {
        this.pagesCreateRate = pagesCreateRate;
    }

    public Double getPagesWrittenRate() {
        return pagesWrittenRate;
    }

    public void setPagesWrittenRate(Double pagesWrittenRate) {
        this.pagesWrittenRate = pagesWrittenRate;
    }

    public Long getNumberPagesGet() {
        return numberPagesGet;
    }

    public void setNumberPagesGet(Long numberPagesGet) {
        this.numberPagesGet = numberPagesGet;
    }

    public Long getHitRate() {
        return hitRate;
    }

    public void setHitRate(Long hitRate) {
        this.hitRate = hitRate;
    }

    public Long getYoungMakePerThousandGets() {
        return youngMakePerThousandGets;
    }

    public void setYoungMakePerThousandGets(Long youngMakePerThousandGets) {
        this.youngMakePerThousandGets = youngMakePerThousandGets;
    }

    public Long getNotYoungMakePerThousandGets() {
        return notYoungMakePerThousandGets;
    }

    public void setNotYoungMakePerThousandGets(Long notYoungMakePerThousandGets) {
        this.notYoungMakePerThousandGets = notYoungMakePerThousandGets;
    }

    public Long getNumberPagesReadAhead() {
        return numberPagesReadAhead;
    }

    public void setNumberPagesReadAhead(Long numberPagesReadAhead) {
        this.numberPagesReadAhead = numberPagesReadAhead;
    }

    public Long getNumberReadAheadEvicted() {
        return numberReadAheadEvicted;
    }

    public void setNumberReadAheadEvicted(Long numberReadAheadEvicted) {
        this.numberReadAheadEvicted = numberReadAheadEvicted;
    }

    public Double getReadAheadRate() {
        return readAheadRate;
    }

    public void setReadAheadRate(Double readAheadRate) {
        this.readAheadRate = readAheadRate;
    }

    public Double getReadAheadEvictedRate() {
        return readAheadEvictedRate;
    }

    public void setReadAheadEvictedRate(Double readAheadEvictedRate) {
        this.readAheadEvictedRate = readAheadEvictedRate;
    }

    public Long getLruIoTotal() {
        return lruIoTotal;
    }

    public void setLruIoTotal(Long lruIoTotal) {
        this.lruIoTotal = lruIoTotal;
    }

    public Long getLruIoCurrent() {
        return lruIoCurrent;
    }

    public void setLruIoCurrent(Long lruIoCurrent) {
        this.lruIoCurrent = lruIoCurrent;
    }

    public Long getUncompressTotal() {
        return uncompressTotal;
    }

    public void setUncompressTotal(Long uncompressTotal) {
        this.uncompressTotal = uncompressTotal;
    }

    public Long getUncompressCurrent() {
        return uncompressCurrent;
    }

    public void setUncompressCurrent(Long uncompressCurrent) {
        this.uncompressCurrent = uncompressCurrent;
    }
}