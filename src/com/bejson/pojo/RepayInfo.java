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
public class RepayInfo {

    private String ShareCreditLimitAmount;
    private Date RecentPayDate;
    public void setShareCreditLimitAmount(String ShareCreditLimitAmount) {
         this.ShareCreditLimitAmount = ShareCreditLimitAmount;
     }
     public String getShareCreditLimitAmount() {
         return ShareCreditLimitAmount;
     }

     @JSONField(format="yyyy.MM.dd")
    public void setRecentPayDate(Date RecentPayDate) {
         this.RecentPayDate = RecentPayDate;
     }
     public Date getRecentPayDate() {
         return RecentPayDate;
     }

}