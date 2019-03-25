/**
  * Copyright 2018 bejson.com 
  */
package com.bejson.pojo;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Auto-generated: 2018-07-20 11:0:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AssurerRepay {

    private String Organname;
    private Date LatestAssurerRepayDate;
    private String Money;
    private Date LatestRepayDate;
    private String Balance;
    public void setOrganname(String Organname) {
         this.Organname = Organname;
     }
     public String getOrganname() {
         return Organname;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setLatestAssurerRepayDate(Date LatestAssurerRepayDate) {
         this.LatestAssurerRepayDate = LatestAssurerRepayDate;
     }
     public Date getLatestAssurerRepayDate() {
         return LatestAssurerRepayDate;
     }

    public void setMoney(String Money) {
         this.Money = Money;
     }
     public String getMoney() {
         return Money;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setLatestRepayDate(Date LatestRepayDate) {
         this.LatestRepayDate = LatestRepayDate;
     }
     public Date getLatestRepayDate() {
         return LatestRepayDate;
     }

    public void setBalance(String Balance) {
         this.Balance = Balance;
     }
     public String getBalance() {
         return Balance;
     }

}