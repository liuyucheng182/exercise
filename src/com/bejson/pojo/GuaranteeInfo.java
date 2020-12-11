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
public class GuaranteeInfo {

    private String GuaranteeFormat;
    private List<Guarantee> Guarantee;
    public void setGuaranteeFormat(String GuaranteeFormat) {
         this.GuaranteeFormat = GuaranteeFormat;
     }
     public String getGuaranteeFormat() {
         return GuaranteeFormat;
     }

    public void setGuarantee(List<Guarantee> Guarantee) {
         this.Guarantee = Guarantee;
     }
     public List<Guarantee> getGuarantee() {
         return Guarantee;
     }

}