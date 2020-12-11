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
public class TaxArrear {

    private String Organname;
    private String TaxArreaAmount;
    private Date Revenuedate;
    public void setOrganname(String Organname) {
         this.Organname = Organname;
     }
     public String getOrganname() {
         return Organname;
     }

    public void setTaxArreaAmount(String TaxArreaAmount) {
         this.TaxArreaAmount = TaxArreaAmount;
     }
     public String getTaxArreaAmount() {
         return TaxArreaAmount;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setRevenuedate(Date Revenuedate) {
         this.Revenuedate = Revenuedate;
     }
     public Date getRevenuedate() {
         return Revenuedate;
     }

}