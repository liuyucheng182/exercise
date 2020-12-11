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
public class AdminAward {

    private String Organname;
    private String Content;
    private Date BeginDate;
    private Date EndDate;
    public void setOrganname(String Organname) {
         this.Organname = Organname;
     }
     public String getOrganname() {
         return Organname;
     }

    public void setContent(String Content) {
         this.Content = Content;
     }
     public String getContent() {
         return Content;
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

}