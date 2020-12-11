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
public class EndowmentInsuranceDeposit {

    private String Area;
    private Date RegisterDate;
    private String MonthDuration;
    private String WorkDate;
    private String State;
    private String OwnBasicMoney;
    private String Money;
    private String Organname;
    private String PauseReason;
    private Date GetTime;
    public void setArea(String Area) {
         this.Area = Area;
     }
     public String getArea() {
         return Area;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setRegisterDate(Date RegisterDate) {
         this.RegisterDate = RegisterDate;
     }
     public Date getRegisterDate() {
         return RegisterDate;
     }

    public void setMonthDuration(String MonthDuration) {
         this.MonthDuration = MonthDuration;
     }
     public String getMonthDuration() {
         return MonthDuration;
     }

    public void setWorkDate(String WorkDate) {
         this.WorkDate = WorkDate;
     }
     public String getWorkDate() {
         return WorkDate;
     }

    public void setState(String State) {
         this.State = State;
     }
     public String getState() {
         return State;
     }

    public void setOwnBasicMoney(String OwnBasicMoney) {
         this.OwnBasicMoney = OwnBasicMoney;
     }
     public String getOwnBasicMoney() {
         return OwnBasicMoney;
     }

    public void setMoney(String Money) {
         this.Money = Money;
     }
     public String getMoney() {
         return Money;
     }

    public void setOrganname(String Organname) {
         this.Organname = Organname;
     }
     public String getOrganname() {
         return Organname;
     }

    public void setPauseReason(String PauseReason) {
         this.PauseReason = PauseReason;
     }
     public String getPauseReason() {
         return PauseReason;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setGetTime(Date GetTime) {
         this.GetTime = GetTime;
     }
     public Date getGetTime() {
         return GetTime;
     }

}