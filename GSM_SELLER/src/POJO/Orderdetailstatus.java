package POJO;

import java.util.HashSet;
import java.util.Set;
// Generated Aug 27, 2011 3:20:53 PM by Hibernate Tools 3.2.1.GA



/**
 * Orderdetailstatus generated by hbm2java
 */
public class Orderdetailstatus  implements java.io.Serializable {


     private Integer orderDetailStatusId;
     private String orderDetailStatus;
     private Set productorderdetails = new HashSet(0);
     

	public Orderdetailstatus() {
    }

    public Orderdetailstatus(String orderDetailStatus) {
       this.orderDetailStatus = orderDetailStatus;
    }
    
    public Orderdetailstatus(String orderDetailStatus, Set productorderdetails) {
        this.orderDetailStatus = orderDetailStatus;
        this.productorderdetails  = productorderdetails;
        
     }
   
    public Integer getOrderDetailStatusId() {
        return this.orderDetailStatusId;
    }
    
    public void setOrderDetailStatusId(Integer orderDetailStatusId) {
        this.orderDetailStatusId = orderDetailStatusId;
    }
    public String getOrderDetailStatus() {
        return this.orderDetailStatus;
    }
    
    public void setOrderDetailStatus(String orderDetailStatus) {
        this.orderDetailStatus = orderDetailStatus;
    }

    public Set getProductorderdetails() {
		return productorderdetails;
	}

	public void setProductorderdetails(Set productorderdetails) {
		this.productorderdetails = productorderdetails;
	}
	

}


