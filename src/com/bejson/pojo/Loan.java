/**
  * Copyright 2018 bejson.com 
  */
package com.bejson.pojo;

/**
 * Auto-generated: 2018-07-20 11:0:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Loan {

    private String Cue;
    private ContractInfo ContractInfo;
    private String State;
    private CurrAccountInfo CurrAccountInfo;
    public void setCue(String Cue) {
         this.Cue = Cue;
     }
     public String getCue() {
         return Cue;
     }

    public void setContractInfo(ContractInfo ContractInfo) {
         this.ContractInfo = ContractInfo;
     }
     public ContractInfo getContractInfo() {
         return ContractInfo;
     }

    public void setState(String State) {
         this.State = State;
     }
     public String getState() {
         return State;
     }

    public void setCurrAccountInfo(CurrAccountInfo CurrAccountInfo) {
         this.CurrAccountInfo = CurrAccountInfo;
     }
     public CurrAccountInfo getCurrAccountInfo() {
         return CurrAccountInfo;
     }

}