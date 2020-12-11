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
public class Salvation {

    private String PersonnelType;
    private String Area;
    private String Organname;
    private String Money;
    private Date RegisterDate;
    private Date PassDate;
    private Date GetTime;
    public void setPersonnelType(String PersonnelType) {
         this.PersonnelType = PersonnelType;
     }
     public String getPersonnelType() {
         return PersonnelType;
     }

    public void setArea(String Area) {
         this.Area = Area;
     }
     public String getArea() {
         return Area;
     }

    public void setOrganname(String Organname) {
         this.Organname = Organname;
     }
     public String getOrganname() {
         return Organname;
     }

    public void setMoney(String Money) {
         this.Money = Money;
     }
     public String getMoney() {
         return Money;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setRegisterDate(Date RegisterDate) {
         this.RegisterDate = RegisterDate;
     }
     public Date getRegisterDate() {
         return RegisterDate;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setPassDate(Date PassDate) {
         this.PassDate = PassDate;
     }
     public Date getPassDate() {
         return PassDate;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setGetTime(Date GetTime) {
         this.GetTime = GetTime;
     }
     public Date getGetTime() {
         return GetTime;
     }

}