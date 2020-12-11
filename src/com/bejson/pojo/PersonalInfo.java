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
public class PersonalInfo {

    private Identity Identity;
    private Spouse Spouse;
    private List<Residence> Residence;
    private Professional Professional;
    public void setIdentity(Identity Identity) {
         this.Identity = Identity;
     }
     public Identity getIdentity() {
         return Identity;
     }

    public void setSpouse(Spouse Spouse) {
         this.Spouse = Spouse;
     }
     public Spouse getSpouse() {
         return Spouse;
     }

    public void setResidence(List<Residence> Residence) {
         this.Residence = Residence;
     }
     public List<Residence> getResidence() {
         return Residence;
     }

    public void setProfessional(Professional Professional) {
         this.Professional = Professional;
     }
     public Professional getProfessional() {
         return Professional;
     }

}