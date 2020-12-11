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
public class CivilJudgement {

    private String Court;
    private String CaseReason;
    private Date RegisterDate;
    private String ClosedType;
    private String CaseResult;
    private Date CaseValidatedate;
    private String SuitObject;
    private String SuitObjectMoney;
    public void setCourt(String Court) {
         this.Court = Court;
     }
     public String getCourt() {
         return Court;
     }

    public void setCaseReason(String CaseReason) {
         this.CaseReason = CaseReason;
     }
     public String getCaseReason() {
         return CaseReason;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setRegisterDate(Date RegisterDate) {
         this.RegisterDate = RegisterDate;
     }
     public Date getRegisterDate() {
         return RegisterDate;
     }

    public void setClosedType(String ClosedType) {
         this.ClosedType = ClosedType;
     }
     public String getClosedType() {
         return ClosedType;
     }

    public void setCaseResult(String CaseResult) {
         this.CaseResult = CaseResult;
     }
     public String getCaseResult() {
         return CaseResult;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setCaseValidatedate(Date CaseValidatedate) {
         this.CaseValidatedate = CaseValidatedate;
     }
     public Date getCaseValidatedate() {
         return CaseValidatedate;
     }

    public void setSuitObject(String SuitObject) {
         this.SuitObject = SuitObject;
     }
     public String getSuitObject() {
         return SuitObject;
     }

    public void setSuitObjectMoney(String SuitObjectMoney) {
         this.SuitObjectMoney = SuitObjectMoney;
     }
     public String getSuitObjectMoney() {
         return SuitObjectMoney;
     }

}