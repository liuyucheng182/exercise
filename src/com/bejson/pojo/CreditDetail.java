/**
  * Copyright 2018 bejson.com 
  */
package com.bejson.pojo;
import java.util.List;

/**
 * Auto-generated: 2018-07-20 11:0:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CreditDetail {

    private AssetDisposition AssetDisposition;
    private AssurerRepay AssurerRepay;
    private List<Loan> Loan;
    private List<Loancard> Loancard;
    private List<StandardLoancard> StandardLoancard;
    private List<GuaranteeInfo> GuaranteeInfo;
    public void setAssetDisposition(AssetDisposition AssetDisposition) {
         this.AssetDisposition = AssetDisposition;
     }
     public AssetDisposition getAssetDisposition() {
         return AssetDisposition;
     }

    public void setAssurerRepay(AssurerRepay AssurerRepay) {
         this.AssurerRepay = AssurerRepay;
     }
     public AssurerRepay getAssurerRepay() {
         return AssurerRepay;
     }

    public void setLoan(List<Loan> Loan) {
         this.Loan = Loan;
     }
     public List<Loan> getLoan() {
         return Loan;
     }

    public void setLoancard(List<Loancard> Loancard) {
         this.Loancard = Loancard;
     }
     public List<Loancard> getLoancard() {
         return Loancard;
     }

    public void setStandardLoancard(List<StandardLoancard> StandardLoancard) {
         this.StandardLoancard = StandardLoancard;
     }
     public List<StandardLoancard> getStandardLoancard() {
         return StandardLoancard;
     }

    public void setGuaranteeInfo(List<GuaranteeInfo> GuaranteeInfo) {
         this.GuaranteeInfo = GuaranteeInfo;
     }
     public List<GuaranteeInfo> getGuaranteeInfo() {
         return GuaranteeInfo;
     }

}