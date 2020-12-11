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
public class CreditScore {

    private String Score;
    private String ScoreLevel;
    private List<ScoreElements> ScoreElements;
    public void setScore(String Score) {
         this.Score = Score;
     }
     public String getScore() {
         return Score;
     }

    public void setScoreLevel(String ScoreLevel) {
         this.ScoreLevel = ScoreLevel;
     }
     public String getScoreLevel() {
         return ScoreLevel;
     }

    public void setScoreElements(List<ScoreElements> ScoreElements) {
         this.ScoreElements = ScoreElements;
     }
     public List<ScoreElements> getScoreElements() {
         return ScoreElements;
     }

}