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
public class AwardCreditInfo {

    private String FinanceOrg;
    private String FinanceType;
    private String Account;
    private String Currency;
    private Date OpenDate;
    private String CreditLimitAmount;
    private String GuaranteeType;
    public void setFinanceOrg(String FinanceOrg) {
         this.FinanceOrg = FinanceOrg;
     }
     public String getFinanceOrg() {
         return FinanceOrg;
     }

    public void setFinanceType(String FinanceType) {
         this.FinanceType = FinanceType;
     }
     public String getFinanceType() {
         return FinanceType;
     }

    public void setAccount(String Account) {
         this.Account = Account;
     }
     public String getAccount() {
         return Account;
     }

    public void setCurrency(String Currency) {
         this.Currency = Currency;
     }
     public String getCurrency() {
         return Currency;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setOpenDate(Date OpenDate) {
         this.OpenDate = OpenDate;
     }
     public Date getOpenDate() {
         return OpenDate;
     }

    public void setCreditLimitAmount(String CreditLimitAmount) {
         this.CreditLimitAmount = CreditLimitAmount;
     }
     public String getCreditLimitAmount() {
         return CreditLimitAmount;
     }

    public void setGuaranteeType(String GuaranteeType) {
         this.GuaranteeType = GuaranteeType;
     }
     public String getGuaranteeType() {
         return GuaranteeType;
     }

}