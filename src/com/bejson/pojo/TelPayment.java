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
public class TelPayment {

    private String Organname;
    private String Type;
    private Date RegisterDate;
    private String State;
    private String ArrearMoney;
    private String ArrearMonths;
    private String Status24;
    private String GetTime;
    public void setOrganname(String Organname) {
         this.Organname = Organname;
     }
     public String getOrganname() {
         return Organname;
     }

    public void setType(String Type) {
         this.Type = Type;
     }
     public String getType() {
         return Type;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setRegisterDate(Date RegisterDate) {
         this.RegisterDate = RegisterDate;
     }
     public Date getRegisterDate() {
         return RegisterDate;
     }

    public void setState(String State) {
         this.State = State;
     }
     public String getState() {
         return State;
     }

    public void setArrearMoney(String ArrearMoney) {
         this.ArrearMoney = ArrearMoney;
     }
     public String getArrearMoney() {
         return ArrearMoney;
     }

    public void setArrearMonths(String ArrearMonths) {
         this.ArrearMonths = ArrearMonths;
     }
     public String getArrearMonths() {
         return ArrearMonths;
     }

    public void setStatus24(String Status24) {
         this.Status24 = Status24;
     }
     public String getStatus24() {
         return Status24;
     }

    public void setGetTime(String GetTime) {
         this.GetTime = GetTime;
     }
     public String getGetTime() {
         return GetTime;
     }

}