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
public class Identity {

    private String Gender;
    private Date Birthday;
    private String MaritalState;
    private String Mobile;
    private String OfficeTelephoneNo;
    private String HomeTelephoneNo;
    private String EduLevel;
    private String EduDegree;
    private String PostAddress;
    private String RegisteredAddress;
    public void setGender(String Gender) {
         this.Gender = Gender;
     }
     public String getGender() {
         return Gender;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setBirthday(Date Birthday) {
         this.Birthday = Birthday;
     }
     public Date getBirthday() {
         return Birthday;
     }

    public void setMaritalState(String MaritalState) {
         this.MaritalState = MaritalState;
     }
     public String getMaritalState() {
         return MaritalState;
     }

    public void setMobile(String Mobile) {
         this.Mobile = Mobile;
     }
     public String getMobile() {
         return Mobile;
     }

    public void setOfficeTelephoneNo(String OfficeTelephoneNo) {
         this.OfficeTelephoneNo = OfficeTelephoneNo;
     }
     public String getOfficeTelephoneNo() {
         return OfficeTelephoneNo;
     }

    public void setHomeTelephoneNo(String HomeTelephoneNo) {
         this.HomeTelephoneNo = HomeTelephoneNo;
     }
     public String getHomeTelephoneNo() {
         return HomeTelephoneNo;
     }

    public void setEduLevel(String EduLevel) {
         this.EduLevel = EduLevel;
     }
     public String getEduLevel() {
         return EduLevel;
     }

    public void setEduDegree(String EduDegree) {
         this.EduDegree = EduDegree;
     }
     public String getEduDegree() {
         return EduDegree;
     }

    public void setPostAddress(String PostAddress) {
         this.PostAddress = PostAddress;
     }
     public String getPostAddress() {
         return PostAddress;
     }

    public void setRegisteredAddress(String RegisteredAddress) {
         this.RegisteredAddress = RegisteredAddress;
     }
     public String getRegisteredAddress() {
         return RegisteredAddress;
     }

}