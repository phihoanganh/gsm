package POJO;
// Generated Aug 12, 2011 5:26:36 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Deliverstatus generated by hbm2java
 */
public class Deliverstatus  implements java.io.Serializable {


     private Integer deliverStatusId;
     private String deliverStatus;
     private String reasonCancel;
     private Set delivers = new HashSet(0);

    public Deliverstatus() {
    }

	
    public Deliverstatus(String deliverStatus,String ReasonCancel) {
        this.deliverStatus = deliverStatus;
        this.reasonCancel=ReasonCancel;
    }
    public Deliverstatus(String deliverStatus,String ReasonCancel, Set delivers) {
       this.deliverStatus = deliverStatus;
       this.reasonCancel=ReasonCancel;
       this.delivers = delivers;
    }
   
    public Integer getDeliverStatusId() {
        return this.deliverStatusId;
    }
    
    public void setDeliverStatusId(Integer deliverStatusId) {
        this.deliverStatusId = deliverStatusId;
    }
    public String getDeliverStatus() {
        return this.deliverStatus;
    }
    
    public void setDeliverStatus(String deliverStatus) {
        this.deliverStatus = deliverStatus;
    }
    
    
    public String getReasonCancel() {
		return reasonCancel;
	}


	public void setReasonCancel(String reasonCancel) {
		reasonCancel = reasonCancel;
	}


	public Set getDelivers() {
        return this.delivers;
    }
    
    public void setDelivers(Set delivers) {
        this.delivers = delivers;
    }




}


