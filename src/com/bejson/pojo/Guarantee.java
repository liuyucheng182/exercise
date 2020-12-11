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
public class Guarantee {

    private String Organname;
    private String ContractMoney;
    private Date BeginDate;
    private Date EndDate;
    private String GuananteeMoney;
    private String GuaranteeBalance;
    private String Class5State;
    private Date BillingDate;
    public void setOrganname(String Organname) {
         this.Organname = Organname;
     }
     public String getOrganname() {
         return Organname;
     }

    public void setContractMoney(String ContractMoney) {
         this.ContractMoney = ContractMoney;
     }
     public String getContractMoney() {
         return ContractMoney;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setBeginDate(Date BeginDate) {
         this.BeginDate = BeginDate;
     }
     public Date getBeginDate() {
         return BeginDate;
     }
     @JSONField(format="yyyy.MM.dd")
    public void setEndDate(Date EndDate) {
         this.EndDate = EndDate;
     }
     public Date getEndDate() {
         return EndDate;
     }

    public void setGuananteeMoney(String GuananteeMoney) {
         this.GuananteeMoney = GuananteeMoney;
     }
     public String getGuananteeMoney() {
         return GuananteeMoney;
     }

    public void setGuaranteeBalance(String GuaranteeBalance) {
         this.GuaranteeBalance = GuaranteeBalance;
     }
     public String getGuaranteeBalance() {
         return GuaranteeBalance;
     }

    public void setClass5State(String Class5State) {
         this.Class5State = Class5State;
     }
     public String getClass5State() {
         return Class5State;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setBillingDate(Date BillingDate) {
         this.BillingDate = BillingDate;
     }
     public Date getBillingDate() {
         return BillingDate;
     }

}