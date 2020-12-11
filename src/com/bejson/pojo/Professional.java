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
public class Professional {

    private String Employer;
    private String EmployerAddress;
    private String Occupation;
    private String Industry;
    private String Duty;
    private String Title;
    private String StartYear;
    private Date GetTime;
    public void setEmployer(String Employer) {
         this.Employer = Employer;
     }
     public String getEmployer() {
         return Employer;
     }

    public void setEmployerAddress(String EmployerAddress) {
         this.EmployerAddress = EmployerAddress;
     }
     public String getEmployerAddress() {
         return EmployerAddress;
     }

    public void setOccupation(String Occupation) {
         this.Occupation = Occupation;
     }
     public String getOccupation() {
         return Occupation;
     }

    public void setIndustry(String Industry) {
         this.Industry = Industry;
     }
     public String getIndustry() {
         return Industry;
     }

    public void setDuty(String Duty) {
         this.Duty = Duty;
     }
     public String getDuty() {
         return Duty;
     }

    public void setTitle(String Title) {
         this.Title = Title;
     }
     public String getTitle() {
         return Title;
     }

    public void setStartYear(String StartYear) {
         this.StartYear = StartYear;
     }
     public String getStartYear() {
         return StartYear;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setGetTime(Date GetTime) {
         this.GetTime = GetTime;
     }
     public Date getGetTime() {
         return GetTime;
     }

}