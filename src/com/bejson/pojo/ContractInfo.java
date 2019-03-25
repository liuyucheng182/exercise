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
public class ContractInfo {

    private String FinanceOrg;
    private String FinanceType;
    private String Account;
    private String Type;
    private String Currency;
    private Date OpenDate;
    private Date EndDate;
    private String CreditLimitAmount;
    private String GuaranteeType;
    private String PaymentRating;
    private String PaymentCyc;
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

    public void setType(String Type) {
         this.Type = Type;
     }
     public String getType() {
         return Type;
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

     @JSONField(format="yyyy.MM.dd")
    public void setEndDate(Date EndDate) {
         this.EndDate = EndDate;
     }
     public Date getEndDate() {
         return EndDate;
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

    public void setPaymentRating(String PaymentRating) {
         this.PaymentRating = PaymentRating;
     }
     public String getPaymentRating() {
         return PaymentRating;
     }

    public void setPaymentCyc(String PaymentCyc) {
         this.PaymentCyc = PaymentCyc;
     }
     public String getPaymentCyc() {
         return PaymentCyc;
     }

}