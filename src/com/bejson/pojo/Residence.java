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
public class Residence {

    private String Address;
    private String ResidenceType;
    private Date GetTime;
    public void setAddress(String Address) {
         this.Address = Address;
     }
     public String getAddress() {
         return Address;
     }

    public void setResidenceType(String ResidenceType) {
         this.ResidenceType = ResidenceType;
     }
     public String getResidenceType() {
         return ResidenceType;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setGetTime(Date GetTime) {
         this.GetTime = GetTime;
     }
     public Date getGetTime() {
         return GetTime;
     }

}