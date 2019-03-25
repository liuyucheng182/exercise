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
public class ForceExecution {

    private String Court;
    private String CaseReason;
    private Date RegisterDate;
    private String ClosedType;
    private String CaseState;
    private Date ClosedDate;
    private String EnforceObject;
    private String EnforceObjectMoney;
    private String AlreadyEnforceObject;
    private String AlreadyEnforceObjectMoney;
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

    public void setCaseState(String CaseState) {
         this.CaseState = CaseState;
     }
     public String getCaseState() {
         return CaseState;
     }
     @JSONField(format="yyyy.MM.dd")
    public void setClosedDate(Date ClosedDate) {
         this.ClosedDate = ClosedDate;
     }
     public Date getClosedDate() {
         return ClosedDate;
     }

    public void setEnforceObject(String EnforceObject) {
         this.EnforceObject = EnforceObject;
     }
     public String getEnforceObject() {
         return EnforceObject;
     }

    public void setEnforceObjectMoney(String EnforceObjectMoney) {
         this.EnforceObjectMoney = EnforceObjectMoney;
     }
     public String getEnforceObjectMoney() {
         return EnforceObjectMoney;
     }

    public void setAlreadyEnforceObject(String AlreadyEnforceObject) {
         this.AlreadyEnforceObject = AlreadyEnforceObject;
     }
     public String getAlreadyEnforceObject() {
         return AlreadyEnforceObject;
     }

    public void setAlreadyEnforceObjectMoney(String AlreadyEnforceObjectMoney) {
         this.AlreadyEnforceObjectMoney = AlreadyEnforceObjectMoney;
     }
     public String getAlreadyEnforceObjectMoney() {
         return AlreadyEnforceObjectMoney;
     }

}