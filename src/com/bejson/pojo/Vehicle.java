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
public class Vehicle {

    private String EngineCode;
    private String LicenseCode;
    private String Brand;
    private String CarType;
    private String UseCharacter;
    private String State;
    private String PledgeFlag;
    private Date GetTime;
    public void setEngineCode(String EngineCode) {
         this.EngineCode = EngineCode;
     }
     public String getEngineCode() {
         return EngineCode;
     }

    public void setLicenseCode(String LicenseCode) {
         this.LicenseCode = LicenseCode;
     }
     public String getLicenseCode() {
         return LicenseCode;
     }

    public void setBrand(String Brand) {
         this.Brand = Brand;
     }
     public String getBrand() {
         return Brand;
     }

    public void setCarType(String CarType) {
         this.CarType = CarType;
     }
     public String getCarType() {
         return CarType;
     }

    public void setUseCharacter(String UseCharacter) {
         this.UseCharacter = UseCharacter;
     }
     public String getUseCharacter() {
         return UseCharacter;
     }

    public void setState(String State) {
         this.State = State;
     }
     public String getState() {
         return State;
     }

    public void setPledgeFlag(String PledgeFlag) {
         this.PledgeFlag = PledgeFlag;
     }
     public String getPledgeFlag() {
         return PledgeFlag;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setGetTime(Date GetTime) {
         this.GetTime = GetTime;
     }
     public Date getGetTime() {
         return GetTime;
     }

}