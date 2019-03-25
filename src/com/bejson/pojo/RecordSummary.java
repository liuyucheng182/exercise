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
public class RecordSummary {

    private List<LatestMonthQueryorgSum> LatestMonthQueryorgSum;
    private List<LatestMonthQueryrecordSum> LatestMonthQueryrecordSum;
    private List<TwoyearQueryrecordSum> TwoyearQueryrecordSum;
    public void setLatestMonthQueryorgSum(List<LatestMonthQueryorgSum> LatestMonthQueryorgSum) {
         this.LatestMonthQueryorgSum = LatestMonthQueryorgSum;
     }
     public List<LatestMonthQueryorgSum> getLatestMonthQueryorgSum() {
         return LatestMonthQueryorgSum;
     }

    public void setLatestMonthQueryrecordSum(List<LatestMonthQueryrecordSum> LatestMonthQueryrecordSum) {
         this.LatestMonthQueryrecordSum = LatestMonthQueryrecordSum;
     }
     public List<LatestMonthQueryrecordSum> getLatestMonthQueryrecordSum() {
         return LatestMonthQueryrecordSum;
     }

    public void setTwoyearQueryrecordSum(List<TwoyearQueryrecordSum> TwoyearQueryrecordSum) {
         this.TwoyearQueryrecordSum = TwoyearQueryrecordSum;
     }
     public List<TwoyearQueryrecordSum> getTwoyearQueryrecordSum() {
         return TwoyearQueryrecordSum;
     }

}