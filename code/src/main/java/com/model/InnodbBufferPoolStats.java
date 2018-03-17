package com.model;

public class InnodbBufferPoolStats {
    private Long POOL_ID;

    private Long POOL_SIZE;

    private Long FREE_BUFFERS;

    private Long DATABASE_PAGES;

    private Long OLD_DATABASE_PAGES;

    private Long MODIFIED_DATABASE_PAGES;

    private Long PENDING_DECOMPRESS;

    private Long PENDING_READS;

    private Long PENDING_FLUSH_LRU;

    private Long PENDING_FLUSH_LIST;

    private Long PAGES_MADE_YOUNG;

    private Long PAGES_NOT_MADE_YOUNG;

    private Double PAGES_MADE_YOUNG_RATE;

    private Double PAGES_MADE_NOT_YOUNG_RATE;

    private Long NUMBER_PAGES_READ;

    private Long NUMBER_PAGES_CREATED;

    private Long NUMBER_PAGES_WRITTEN;

    private Double PAGES_READ_RATE;

    private Double PAGES_CREATE_RATE;

    private Double PAGES_WRITTEN_RATE;

    private Long NUMBER_PAGES_GET;

    private Long HIT_RATE;

    private Long YOUNG_MAKE_PER_THOUSAND_GETS;

    private Long NOT_YOUNG_MAKE_PER_THOUSAND_GETS;

    private Long NUMBER_PAGES_READ_AHEAD;

    private Long NUMBER_READ_AHEAD_EVICTED;

    private Double READ_AHEAD_RATE;

    private Double READ_AHEAD_EVICTED_RATE;

    private Long LRU_IO_TOTAL;

    private Long LRU_IO_CURRENT;

    private Long UNCOMPRESS_TOTAL;

    private Long UNCOMPRESS_CURRENT;

    public Long getPOOL_ID() {
        return POOL_ID;
    }

    public void setPOOL_ID(Long POOL_ID) {
        this.POOL_ID = POOL_ID;
    }

    public Long getPOOL_SIZE() {
        return POOL_SIZE;
    }

    public void setPOOL_SIZE(Long POOL_SIZE) {
        this.POOL_SIZE = POOL_SIZE;
    }

    public Long getFREE_BUFFERS() {
        return FREE_BUFFERS;
    }

    public void setFREE_BUFFERS(Long FREE_BUFFERS) {
        this.FREE_BUFFERS = FREE_BUFFERS;
    }

    public Long getDATABASE_PAGES() {
        return DATABASE_PAGES;
    }

    public void setDATABASE_PAGES(Long DATABASE_PAGES) {
        this.DATABASE_PAGES = DATABASE_PAGES;
    }

    public Long getOLD_DATABASE_PAGES() {
        return OLD_DATABASE_PAGES;
    }

    public void setOLD_DATABASE_PAGES(Long OLD_DATABASE_PAGES) {
        this.OLD_DATABASE_PAGES = OLD_DATABASE_PAGES;
    }

    public Long getMODIFIED_DATABASE_PAGES() {
        return MODIFIED_DATABASE_PAGES;
    }

    public void setMODIFIED_DATABASE_PAGES(Long MODIFIED_DATABASE_PAGES) {
        this.MODIFIED_DATABASE_PAGES = MODIFIED_DATABASE_PAGES;
    }

    public Long getPENDING_DECOMPRESS() {
        return PENDING_DECOMPRESS;
    }

    public void setPENDING_DECOMPRESS(Long PENDING_DECOMPRESS) {
        this.PENDING_DECOMPRESS = PENDING_DECOMPRESS;
    }

    public Long getPENDING_READS() {
        return PENDING_READS;
    }

    public void setPENDING_READS(Long PENDING_READS) {
        this.PENDING_READS = PENDING_READS;
    }

    public Long getPENDING_FLUSH_LRU() {
        return PENDING_FLUSH_LRU;
    }

    public void setPENDING_FLUSH_LRU(Long PENDING_FLUSH_LRU) {
        this.PENDING_FLUSH_LRU = PENDING_FLUSH_LRU;
    }

    public Long getPENDING_FLUSH_LIST() {
        return PENDING_FLUSH_LIST;
    }

    public void setPENDING_FLUSH_LIST(Long PENDING_FLUSH_LIST) {
        this.PENDING_FLUSH_LIST = PENDING_FLUSH_LIST;
    }

    public Long getPAGES_MADE_YOUNG() {
        return PAGES_MADE_YOUNG;
    }

    public void setPAGES_MADE_YOUNG(Long PAGES_MADE_YOUNG) {
        this.PAGES_MADE_YOUNG = PAGES_MADE_YOUNG;
    }

    public Long getPAGES_NOT_MADE_YOUNG() {
        return PAGES_NOT_MADE_YOUNG;
    }

    public void setPAGES_NOT_MADE_YOUNG(Long PAGES_NOT_MADE_YOUNG) {
        this.PAGES_NOT_MADE_YOUNG = PAGES_NOT_MADE_YOUNG;
    }

    public Double getPAGES_MADE_YOUNG_RATE() {
        return PAGES_MADE_YOUNG_RATE;
    }

    public void setPAGES_MADE_YOUNG_RATE(Double PAGES_MADE_YOUNG_RATE) {
        this.PAGES_MADE_YOUNG_RATE = PAGES_MADE_YOUNG_RATE;
    }

    public Double getPAGES_MADE_NOT_YOUNG_RATE() {
        return PAGES_MADE_NOT_YOUNG_RATE;
    }

    public void setPAGES_MADE_NOT_YOUNG_RATE(Double PAGES_MADE_NOT_YOUNG_RATE) {
        this.PAGES_MADE_NOT_YOUNG_RATE = PAGES_MADE_NOT_YOUNG_RATE;
    }

    public Long getNUMBER_PAGES_READ() {
        return NUMBER_PAGES_READ;
    }

    public void setNUMBER_PAGES_READ(Long NUMBER_PAGES_READ) {
        this.NUMBER_PAGES_READ = NUMBER_PAGES_READ;
    }

    public Long getNUMBER_PAGES_CREATED() {
        return NUMBER_PAGES_CREATED;
    }

    public void setNUMBER_PAGES_CREATED(Long NUMBER_PAGES_CREATED) {
        this.NUMBER_PAGES_CREATED = NUMBER_PAGES_CREATED;
    }

    public Long getNUMBER_PAGES_WRITTEN() {
        return NUMBER_PAGES_WRITTEN;
    }

    public void setNUMBER_PAGES_WRITTEN(Long NUMBER_PAGES_WRITTEN) {
        this.NUMBER_PAGES_WRITTEN = NUMBER_PAGES_WRITTEN;
    }

    public Double getPAGES_READ_RATE() {
        return PAGES_READ_RATE;
    }

    public void setPAGES_READ_RATE(Double PAGES_READ_RATE) {
        this.PAGES_READ_RATE = PAGES_READ_RATE;
    }

    public Double getPAGES_CREATE_RATE() {
        return PAGES_CREATE_RATE;
    }

    public void setPAGES_CREATE_RATE(Double PAGES_CREATE_RATE) {
        this.PAGES_CREATE_RATE = PAGES_CREATE_RATE;
    }

    public Double getPAGES_WRITTEN_RATE() {
        return PAGES_WRITTEN_RATE;
    }

    public void setPAGES_WRITTEN_RATE(Double PAGES_WRITTEN_RATE) {
        this.PAGES_WRITTEN_RATE = PAGES_WRITTEN_RATE;
    }

    public Long getNUMBER_PAGES_GET() {
        return NUMBER_PAGES_GET;
    }

    public void setNUMBER_PAGES_GET(Long NUMBER_PAGES_GET) {
        this.NUMBER_PAGES_GET = NUMBER_PAGES_GET;
    }

    public Long getHIT_RATE() {
        return HIT_RATE;
    }

    public void setHIT_RATE(Long HIT_RATE) {
        this.HIT_RATE = HIT_RATE;
    }

    public Long getYOUNG_MAKE_PER_THOUSAND_GETS() {
        return YOUNG_MAKE_PER_THOUSAND_GETS;
    }

    public void setYOUNG_MAKE_PER_THOUSAND_GETS(Long YOUNG_MAKE_PER_THOUSAND_GETS) {
        this.YOUNG_MAKE_PER_THOUSAND_GETS = YOUNG_MAKE_PER_THOUSAND_GETS;
    }

    public Long getNOT_YOUNG_MAKE_PER_THOUSAND_GETS() {
        return NOT_YOUNG_MAKE_PER_THOUSAND_GETS;
    }

    public void setNOT_YOUNG_MAKE_PER_THOUSAND_GETS(Long NOT_YOUNG_MAKE_PER_THOUSAND_GETS) {
        this.NOT_YOUNG_MAKE_PER_THOUSAND_GETS = NOT_YOUNG_MAKE_PER_THOUSAND_GETS;
    }

    public Long getNUMBER_PAGES_READ_AHEAD() {
        return NUMBER_PAGES_READ_AHEAD;
    }

    public void setNUMBER_PAGES_READ_AHEAD(Long NUMBER_PAGES_READ_AHEAD) {
        this.NUMBER_PAGES_READ_AHEAD = NUMBER_PAGES_READ_AHEAD;
    }

    public Long getNUMBER_READ_AHEAD_EVICTED() {
        return NUMBER_READ_AHEAD_EVICTED;
    }

    public void setNUMBER_READ_AHEAD_EVICTED(Long NUMBER_READ_AHEAD_EVICTED) {
        this.NUMBER_READ_AHEAD_EVICTED = NUMBER_READ_AHEAD_EVICTED;
    }

    public Double getREAD_AHEAD_RATE() {
        return READ_AHEAD_RATE;
    }

    public void setREAD_AHEAD_RATE(Double READ_AHEAD_RATE) {
        this.READ_AHEAD_RATE = READ_AHEAD_RATE;
    }

    public Double getREAD_AHEAD_EVICTED_RATE() {
        return READ_AHEAD_EVICTED_RATE;
    }

    public void setREAD_AHEAD_EVICTED_RATE(Double READ_AHEAD_EVICTED_RATE) {
        this.READ_AHEAD_EVICTED_RATE = READ_AHEAD_EVICTED_RATE;
    }

    public Long getLRU_IO_TOTAL() {
        return LRU_IO_TOTAL;
    }

    public void setLRU_IO_TOTAL(Long LRU_IO_TOTAL) {
        this.LRU_IO_TOTAL = LRU_IO_TOTAL;
    }

    public Long getLRU_IO_CURRENT() {
        return LRU_IO_CURRENT;
    }

    public void setLRU_IO_CURRENT(Long LRU_IO_CURRENT) {
        this.LRU_IO_CURRENT = LRU_IO_CURRENT;
    }

    public Long getUNCOMPRESS_TOTAL() {
        return UNCOMPRESS_TOTAL;
    }

    public void setUNCOMPRESS_TOTAL(Long UNCOMPRESS_TOTAL) {
        this.UNCOMPRESS_TOTAL = UNCOMPRESS_TOTAL;
    }

    public Long getUNCOMPRESS_CURRENT() {
        return UNCOMPRESS_CURRENT;
    }

    public void setUNCOMPRESS_CURRENT(Long UNCOMPRESS_CURRENT) {
        this.UNCOMPRESS_CURRENT = UNCOMPRESS_CURRENT;
    }
}