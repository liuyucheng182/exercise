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
public class Competence {

    private String CompetencyName;
    private String Grade;
    private Date AwardDate;
    private Date EndDate;
    private String RevokeDate;
    private String Organname;
    private String Area;
    public void setCompetencyName(String CompetencyName) {
         this.CompetencyName = CompetencyName;
     }
     public String getCompetencyName() {
         return CompetencyName;
     }

    public void setGrade(String Grade) {
         this.Grade = Grade;
     }
     public String getGrade() {
         return Grade;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setAwardDate(Date AwardDate) {
         this.AwardDate = AwardDate;
     }
     public Date getAwardDate() {
         return AwardDate;
     }
     @JSONField(format="yyyy.MM.dd")
    public void setEndDate(Date EndDate) {
         this.EndDate = EndDate;
     }
     public Date getEndDate() {
         return EndDate;
     }

    public void setRevokeDate(String RevokeDate) {
         this.RevokeDate = RevokeDate;
     }
     public String getRevokeDate() {
         return RevokeDate;
     }

    public void setOrganname(String Organname) {
         this.Organname = Organname;
     }
     public String getOrganname() {
         return Organname;
     }

    public void setArea(String Area) {
         this.Area = Area;
     }
     public String getArea() {
         return Area;
     }

}