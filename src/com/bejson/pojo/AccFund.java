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
public class AccFund {

    private String Area;
    private Date RegisterDate;
    private String FirstMonth;
    private String ToMonth;
    private String State;
    private String Pay;
    private String OwnPercent;
    private String ComPercent;
    private String Organname;
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

    public void setFirstMonth(String FirstMonth) {
         this.FirstMonth = FirstMonth;
     }
     public String getFirstMonth() {
         return FirstMonth;
     }

    public void setToMonth(String ToMonth) {
         this.ToMonth = ToMonth;
     }
     public String getToMonth() {
         return ToMonth;
     }

    public void setState(String State) {
         this.State = State;
     }
     public String getState() {
         return State;
     }

    public void setPay(String Pay) {
         this.Pay = Pay;
     }
     public String getPay() {
         return Pay;
     }

    public void setOwnPercent(String OwnPercent) {
         this.OwnPercent = OwnPercent;
     }
     public String getOwnPercent() {
         return OwnPercent;
     }

    public void setComPercent(String ComPercent) {
         this.ComPercent = ComPercent;
     }
     public String getComPercent() {
         return ComPercent;
     }

    public void setOrganname(String Organname) {
         this.Organname = Organname;
     }
     public String getOrganname() {
         return Organname;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setGetTime(Date GetTime) {
         this.GetTime = GetTime;
     }
     public Date getGetTime() {
         return GetTime;
     }

}