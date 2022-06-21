package com.zedrcap.dhaivat.hexcore;

public class trading {
    private String month,day,var,stockname,buyprice,buytp,buysl,sellprice,selltp,sellsl;
   // private String time;
    public trading ()
    {

    }
    public trading(String month, String day, String var, String stockname, String time, String buyprice, String buytp, String buysl, String sellprice, String selltp, String sellsl) {
        this.month = month;
        this.day = day;
        this.var = var;
        this.stockname = stockname;
        //this.time = time;
        this.buyprice = buyprice;
        this.buytp = buytp;
        this.buysl = buysl;
        this.sellprice = sellprice;
        this.selltp = selltp;
        this.sellsl = sellsl;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }

    public String getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(String buyprice) {
        this.buyprice = buyprice;
    }

    public String getBuytp() {
        return buytp;
    }

    public void setBuytp(String buytp) {
        this.buytp = buytp;
    }

    public String getBuysl() {
        return buysl;
    }

    public void setBuysl(String buysl) {
        this.buysl = buysl;
    }

    public String getSellprice() {
        return sellprice;
    }

    public void setSellprice(String sellprice) {
        this.sellprice = sellprice;
    }

    public String getSelltp() {
        return selltp;
    }

    public void setSelltp(String selltp) {
        this.selltp = selltp;
    }

    public String getSellsl() {
        return sellsl;
    }

    public void setSellsl(String sellsl) {
        this.sellsl = sellsl;
    }
}
