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
public class RecordDetail {

    private Date QueryDate;
    private String Querier;
    private String QueryReason;
    
    @JSONField(format="yyyy.MM.dd")
    public void setQueryDate(Date QueryDate) {
         this.QueryDate = QueryDate;
     }
     public Date getQueryDate() {
         return QueryDate;
     }

    public void setQuerier(String Querier) {
         this.Querier = Querier;
     }
     public String getQuerier() {
         return Querier;
     }

    public void setQueryReason(String QueryReason) {
         this.QueryReason = QueryReason;
     }
     public String getQueryReason() {
         return QueryReason;
     }

}