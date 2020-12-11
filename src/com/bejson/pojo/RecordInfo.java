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
public class RecordInfo {

    private String QueryReqFormat;
    private List<RecordDetail> RecordDetail;
    public void setQueryReqFormat(String QueryReqFormat) {
         this.QueryReqFormat = QueryReqFormat;
     }
     public String getQueryReqFormat() {
         return QueryReqFormat;
     }

    public void setRecordDetail(List<RecordDetail> RecordDetail) {
         this.RecordDetail = RecordDetail;
     }
     public List<RecordDetail> getRecordDetail() {
         return RecordDetail;
     }

}