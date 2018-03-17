package com.model;

public class InnodbBufferPage {
    private Long POOL_ID;

    private Long BLOCK_ID;

    private Long SPACE;

    private Long PAGE_NUMBER;

    private String PAGE_TYPE;

    private Long FLUSH_TYPE;

    private Long FIX_COUNT;

    private String IS_HASHED;

    private Long NEWEST_MODIFICATION;

    private Long OLDEST_MODIFICATION;

    private Long ACCESS_TIME;

    private String TABLE_NAME;

    private String INDEX_NAME;

    private Long NUMBER_RECORDS;

    private Long DATA_SIZE;

    private Long COMPRESSED_SIZE;

    private String PAGE_STATE;

    private String IO_FIX;

    private String IS_OLD;

    private Long FREE_PAGE_CLOCK;

    public Long getPOOL_ID() {
        return POOL_ID;
    }

    public void setPOOL_ID(Long POOL_ID) {
        this.POOL_ID = POOL_ID;
    }

    public Long getBLOCK_ID() {
        return BLOCK_ID;
    }

    public void setBLOCK_ID(Long BLOCK_ID) {
        this.BLOCK_ID = BLOCK_ID;
    }

    public Long getSPACE() {
        return SPACE;
    }

    public void setSPACE(Long SPACE) {
        this.SPACE = SPACE;
    }

    public Long getPAGE_NUMBER() {
        return PAGE_NUMBER;
    }

    public void setPAGE_NUMBER(Long PAGE_NUMBER) {
        this.PAGE_NUMBER = PAGE_NUMBER;
    }

    public String getPAGE_TYPE() {
        return PAGE_TYPE;
    }

    public void setPAGE_TYPE(String PAGE_TYPE) {
        this.PAGE_TYPE = PAGE_TYPE == null ? null : PAGE_TYPE.trim();
    }

    public Long getFLUSH_TYPE() {
        return FLUSH_TYPE;
    }

    public void setFLUSH_TYPE(Long FLUSH_TYPE) {
        this.FLUSH_TYPE = FLUSH_TYPE;
    }

    public Long getFIX_COUNT() {
        return FIX_COUNT;
    }

    public void setFIX_COUNT(Long FIX_COUNT) {
        this.FIX_COUNT = FIX_COUNT;
    }

    public String getIS_HASHED() {
        return IS_HASHED;
    }

    public void setIS_HASHED(String IS_HASHED) {
        this.IS_HASHED = IS_HASHED == null ? null : IS_HASHED.trim();
    }

    public Long getNEWEST_MODIFICATION() {
        return NEWEST_MODIFICATION;
    }

    public void setNEWEST_MODIFICATION(Long NEWEST_MODIFICATION) {
        this.NEWEST_MODIFICATION = NEWEST_MODIFICATION;
    }

    public Long getOLDEST_MODIFICATION() {
        return OLDEST_MODIFICATION;
    }

    public void setOLDEST_MODIFICATION(Long OLDEST_MODIFICATION) {
        this.OLDEST_MODIFICATION = OLDEST_MODIFICATION;
    }

    public Long getACCESS_TIME() {
        return ACCESS_TIME;
    }

    public void setACCESS_TIME(Long ACCESS_TIME) {
        this.ACCESS_TIME = ACCESS_TIME;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME == null ? null : TABLE_NAME.trim();
    }

    public String getINDEX_NAME() {
        return INDEX_NAME;
    }

    public void setINDEX_NAME(String INDEX_NAME) {
        this.INDEX_NAME = INDEX_NAME == null ? null : INDEX_NAME.trim();
    }

    public Long getNUMBER_RECORDS() {
        return NUMBER_RECORDS;
    }

    public void setNUMBER_RECORDS(Long NUMBER_RECORDS) {
        this.NUMBER_RECORDS = NUMBER_RECORDS;
    }

    public Long getDATA_SIZE() {
        return DATA_SIZE;
    }

    public void setDATA_SIZE(Long DATA_SIZE) {
        this.DATA_SIZE = DATA_SIZE;
    }

    public Long getCOMPRESSED_SIZE() {
        return COMPRESSED_SIZE;
    }

    public void setCOMPRESSED_SIZE(Long COMPRESSED_SIZE) {
        this.COMPRESSED_SIZE = COMPRESSED_SIZE;
    }

    public String getPAGE_STATE() {
        return PAGE_STATE;
    }

    public void setPAGE_STATE(String PAGE_STATE) {
        this.PAGE_STATE = PAGE_STATE == null ? null : PAGE_STATE.trim();
    }

    public String getIO_FIX() {
        return IO_FIX;
    }

    public void setIO_FIX(String IO_FIX) {
        this.IO_FIX = IO_FIX == null ? null : IO_FIX.trim();
    }

    public String getIS_OLD() {
        return IS_OLD;
    }

    public void setIS_OLD(String IS_OLD) {
        this.IS_OLD = IS_OLD == null ? null : IS_OLD.trim();
    }

    public Long getFREE_PAGE_CLOCK() {
        return FREE_PAGE_CLOCK;
    }

    public void setFREE_PAGE_CLOCK(Long FREE_PAGE_CLOCK) {
        this.FREE_PAGE_CLOCK = FREE_PAGE_CLOCK;
    }
}