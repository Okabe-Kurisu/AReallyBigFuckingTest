package com.model;

public class Processlist {
    private Long ID;

    private String USER;

    private String HOST;

    private String DB;

    private String COMMAND;

    private Integer TIME;

    private String STATE;

    private String INFO;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER == null ? null : USER.trim();
    }

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST == null ? null : HOST.trim();
    }

    public String getDB() {
        return DB;
    }

    public void setDB(String DB) {
        this.DB = DB == null ? null : DB.trim();
    }

    public String getCOMMAND() {
        return COMMAND;
    }

    public void setCOMMAND(String COMMAND) {
        this.COMMAND = COMMAND == null ? null : COMMAND.trim();
    }

    public Integer getTIME() {
        return TIME;
    }

    public void setTIME(Integer TIME) {
        this.TIME = TIME;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE == null ? null : STATE.trim();
    }

    public String getINFO() {
        return INFO;
    }

    public void setINFO(String INFO) {
        this.INFO = INFO == null ? null : INFO.trim();
    }
}