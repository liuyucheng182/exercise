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
public class MessageHeader {

    private String ReportSN;
    private Date QueryTime;
    private Date ReportCreateTime;
    public void setReportSN(String ReportSN) {
         this.ReportSN = ReportSN;
     }
     public String getReportSN() {
         return ReportSN;
     }

    @JSONField(format="yyyy.MM.dd HH:mm:ss")
    public void setQueryTime(Date QueryTime) {
         this.QueryTime = QueryTime;
     }
     public Date getQueryTime() {
         return QueryTime;
     }

    @JSONField(format="yyyy.MM.dd HH:mm:ss")
    public void setReportCreateTime(Date ReportCreateTime) {
         this.ReportCreateTime = ReportCreateTime;
     }
     public Date getReportCreateTime() {
         return ReportCreateTime;
     }

}