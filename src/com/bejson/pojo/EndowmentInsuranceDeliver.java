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
public class EndowmentInsuranceDeliver {

    private String Area;
    private String RetireType;
    private String RetiredDate;
    private String WorkDate;
    private String Money;
    private String PauseReason;
    private String Organname;
    private Date GetTime;
    public void setArea(String Area) {
         this.Area = Area;
     }
     public String getArea() {
         return Area;
     }

    public void setRetireType(String RetireType) {
         this.RetireType = RetireType;
     }
     public String getRetireType() {
         return RetireType;
     }

    public void setRetiredDate(String RetiredDate) {
         this.RetiredDate = RetiredDate;
     }
     public String getRetiredDate() {
         return RetiredDate;
     }

    public void setWorkDate(String WorkDate) {
         this.WorkDate = WorkDate;
     }
     public String getWorkDate() {
         return WorkDate;
     }

    public void setMoney(String Money) {
         this.Money = Money;
     }
     public String getMoney() {
         return Money;
     }

    public void setPauseReason(String PauseReason) {
         this.PauseReason = PauseReason;
     }
     public String getPauseReason() {
         return PauseReason;
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